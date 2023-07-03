package com.emedlogix.service;

import com.emedlogix.entity.CodeDetails;
import com.emedlogix.entity.CodeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExtractorServiceImpl implements ExtractorService {


    public static final Logger logger = LoggerFactory.getLogger(ExtractorServiceImpl.class);

    @Override
    public Map<String, CodeInfo> doExtractCodes() {
        String fileStr = "/Users/mnachiappan/Documents/Development/clarit/icd10cm_codes_2023.txt";
        logger.info("Start Extracting Codes from file {}", fileStr);
        Map<String, CodeInfo> extractedData = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileStr)));
            String line;
            List<String> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                int index = line.indexOf("  ");
                if (index != -1) {
                    CodeInfo codeInfo = new CodeInfo();
                    codeInfo.setCode(line.substring(0, index));
                    codeInfo.setShortDescription(line.substring(index).trim());
                    extractedData.put(codeInfo.getCode(), codeInfo);
                }
            }
            reader.close();
        } catch (IOException e) {

        }
        logger.info("Code details successfully extracted {}", extractedData.size());
        return extractedData;
    }

    @Override
    public Map<String, CodeDetails> doExtractOrderedCodes() {
        String fileStr = "/Users/mnachiappan/Documents/Development/clarit/icd10cm_order_2023.txt";
        logger.info("Start Extracting Ordered Codes from file {}", fileStr);
        Map<String, CodeDetails> extractedData = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileStr)));
            String line;
            List<String> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if(line.trim().length()>0){
                    CodeDetails details = parseCodeDetails(line);
                    extractedData.put(details.getCode(), details);
                }
            }
        } catch (IOException e) {

        }
        logger.info("Code details successfully extracted ordered codes {}", extractedData.size());
        return extractedData;
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


