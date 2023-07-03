package com.emedlogix.service;


import com.emedlogix.entity.CodeDetails;
import com.emedlogix.entity.CodeInfo;

import java.util.Map;

public interface ExtractorService {

    Map<String, CodeInfo> doExtractCodes();

    Map<String, CodeDetails> doExtractOrderedCodes();
}
