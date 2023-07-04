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

    @Scheduled(fixedDelay = 1000000)
    public void doExtractCode() {
        logger.info("Extractor Service has been initiated Codes...");
        extractorService.doExtractCodes();
        logger.info("Extractor Service Codes completed...");
    }

    @Scheduled(fixedDelay = 1000000)
    public void doExtractOderCode() {
        logger.info("Extractor Service has been initiated for Ordered Codes...");
        extractorService.doExtractOrderedCodes();
        logger.info("Extractor Service Ordered Codes completed...");
    }
}
