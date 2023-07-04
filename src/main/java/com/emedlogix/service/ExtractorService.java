package com.emedlogix.service;


import com.emedlogix.entity.CodeDetails;
import com.emedlogix.entity.CodeInfo;

import java.util.Map;

public interface ExtractorService {

    void doExtractCodes();

    void doExtractOrderedCodes();
}
