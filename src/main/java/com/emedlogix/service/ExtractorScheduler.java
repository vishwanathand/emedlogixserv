package com.emedlogix.service;

import com.emedlogix.entity.CodeDetails;
import com.emedlogix.entity.CodeInfo;
import com.emedlogix.repository.DBCodeDetailsRepository;
import com.emedlogix.repository.ESCodeInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

@Service
public class ExtractorScheduler {
    public static final Logger logger = LoggerFactory.getLogger(ExtractorScheduler.class);
    @Autowired
    ExtractorService extractorService;
    @Autowired
    ESCodeInfoRepository esCodeInfoRepository;

    @Autowired
    DBCodeDetailsRepository dbCodeDetailsRepository;


    @Scheduled(fixedDelay = 1000000)
    public void doExtractCode() {
        logger.info("Extractor Service has been initiated Ordered Codes...");
        Map<String, CodeInfo> codeDetailsMap = extractorService.doExtractCodes();
        if (codeDetailsMap != null && !codeDetailsMap.isEmpty()) {
            logger.info("Total codes extracted {}", codeDetailsMap.entrySet().size());
            esCodeInfoRepository.saveAll(codeDetailsMap.values());
        }
        logger.info("Extractor Service Codes completed...");
    }

    @Scheduled(fixedDelay = 1000000)
    public void doExtractOderCode() {
        logger.info("Extractor Service has been initiated for Ordered Codes...");
        Map<String, CodeDetails> codeDetailsMap = extractorService.doExtractOrderedCodes();
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
}
