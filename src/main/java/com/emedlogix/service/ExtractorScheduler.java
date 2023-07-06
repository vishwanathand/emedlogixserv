package com.emedlogix.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ExtractorScheduler {
    public static final Logger logger = LoggerFactory.getLogger(ExtractorScheduler.class);
    @Autowired
    ExtractorService extractorService;

    @Scheduled(fixedDelay = 1000000)
    public void doExtractChaperSectionXML() {
        logger.info("Extractor Service has been initiated for XML extraction...");
        extractorService.doExtractCapterSectionXML();
        logger.info("Extractor Service XML completed...");
    }

    @Scheduled(fixedDelay = 1000000)
    public void doExtractOderCode() {
        logger.info("Extractor Service has been initiated for Ordered Codes...");
        extractorService.doExtractOrderedCodes();
        logger.info("Extractor Service Ordered Codes completed...");
    }
}
