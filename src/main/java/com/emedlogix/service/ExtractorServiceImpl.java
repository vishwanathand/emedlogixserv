package com.emedlogix.service;

import com.emedlogix.entity.CodeDetails;
import com.emedlogix.entity.CodeInfo;
import com.emedlogix.repository.DBCodeDetailsRepository;
import com.emedlogix.repository.ESCodeInfoRepository;
import generated.ICD10CMTabular;
import jakarta.xml.bind.JAXBContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class ExtractorServiceImpl implements ExtractorService {

    @Autowired
    ESCodeInfoRepository esCodeInfoRepository;

    @Autowired
    DBCodeDetailsRepository dbCodeDetailsRepository;
    public static final Logger logger = LoggerFactory.getLogger(ExtractorServiceImpl.class);

    @Override
    public void doExtractCapterSectionXML() {
        String fileStr = "/Users/mnachiappan/Documents/Development/clarit/icd10cm_codes_2023.txt";
        logger.info("Start Extracting Chapter Section from XML file:", fileStr);
        try{
            JAXBContext context = JAXBContext.newInstance(ICD10CMTabular.class);
            ICD10CMTabular tabular = (ICD10CMTabular)context.createUnmarshaller()
                    .unmarshal(new FileReader("/Users/mnachiappan/Documents/Development/clarit/icd10cm_tabular_2023.xml"));
            logger.info("Retrived Data :", tabular.getChapter().size());
        } catch(Exception e){
            logger.error(e.toString(), e);
        }

        logger.info("Chapter section from XML successfully extracted:");
    }

    @Override
    public void doExtractOrderedCodes() {
        String fileStr = "/Users/mnachiappan/Documents/Development/clarit/icd10cm_order_2023.txt";
        logger.info("Start Extracting Ordered Codes from file {}", fileStr);
        Map<String, CodeDetails> codeDetailsMap = new HashMap<>();
        Map<String, CodeInfo> codeMap = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileStr)));
            String line;
            List<String> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if(line.trim().length()>0){
                    CodeDetails details = parseCodeDetails(line);
                    codeDetailsMap.put(details.getCode(), details);
                    CodeInfo codeInfo = new CodeInfo();
                    codeInfo.setCode(details.getCode());
                    codeInfo.setDescription(details.getLongDescription());
                    codeMap.put(codeInfo.getCode(), codeInfo);
                }
            }
        } catch (IOException e) {

        }
        doSaveCodesToES(codeMap);
        doSaveOrderedCodesToDB(codeDetailsMap);
        logger.info("Code details successfully extracted ordered codes {}", codeDetailsMap.size());

    }

    private void doSaveCodesToES(Map<String, CodeInfo> codeMap){
        if (codeMap != null && !codeMap.isEmpty()) {
            logger.info("Total codes extracted {}", codeMap.entrySet().size());
            esCodeInfoRepository.saveAll(codeMap.values());
        }
        logger.info("Extractor Service Codes completed...");
    }

    private void doSaveOrderedCodesToDB(Map<String, CodeDetails> codeDetailsMap){
        if (codeDetailsMap != null && !codeDetailsMap.isEmpty()) {
            logger.info("Total codes extracted {}", codeDetailsMap.entrySet().size());
            Iterator<Map.Entry<String, CodeDetails>> itr = codeDetailsMap.entrySet().iterator();
            ArrayList dataList = new ArrayList();
            int counter=0;
            while (itr.hasNext()) {
                Map.Entry<String, CodeDetails> entry = itr.next();
                CodeDetails fetchCodeDetails = entry.getValue();
                dataList.add(fetchCodeDetails);
                counter++;
                if(dataList.size()%2000 == 0){
                    dbCodeDetailsRepository.saveAll(dataList);
                    dataList.clear();

                }
            }
            if(!dataList.isEmpty()) {
                dbCodeDetailsRepository.saveAll(dataList);
            }
        }
        logger.info("Extractor Service Ordered Codes completed...");
    }

    public CodeDetails parseCodeDetails(String input) {
        String tokens [] = input.split("[(?=\\s*$)]");
        CodeDetails codeDetails = new CodeDetails();
        int counter = 0;
        boolean skip = false;
        for (String token: tokens) {
            if(!token.isEmpty()) {
                if(counter == 3 && Character.isUpperCase(token.charAt(0)) && skip ) {
                    if(token.length()>2 && codeDetails.getShortDescription().startsWith(token.substring(0,2)) ) {
                        counter++;
                    }
                }
                switch (counter) {
                    case 0:
                        counter++;
                        break;
                    case 1:
                        codeDetails.setCode(token);
                        counter++;
                        break;
                    case 2:
                        codeDetails.setBillable((token.equals("1")?true:false));
                        counter++;
                        break;
                    case 3:
                        codeDetails.setShortDescription((concateDescription(codeDetails.getShortDescription(), token)).trim());
                        skip=true;
                        //counter++;
                        break;
                    case 4:
                        codeDetails.setLongDescription((concateDescription(codeDetails.getLongDescription(), token)).trim());
                        //counter++;
                        break;
                }
            } else {
                if(codeDetails.getShortDescription() != null && codeDetails.getShortDescription().length() > 0 && counter == 3) {
                    counter++;
                }
            }
        }
       // System.out.println(codeDetails.toString());
        return codeDetails;
    }
    private String concateDescription(String previous, String current) {
        return (previous==null?"":previous)+" "+current.trim();
    }
}


