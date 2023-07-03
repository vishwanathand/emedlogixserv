package com.emedlogix.repository;


import com.emedlogix.entity.CodeInfo;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ESCodeInfoRepository extends ElasticsearchRepository<CodeInfo, String> {

    CodeInfo getByCode(String code);

    List<CodeInfo> findByCode(String s);

    @Query("{\"query\": {\"bool\": {\"should\": [{\"wildcard\": {\"code\": \"I97*\"}}]}}}")
    List<CodeInfo> searchAllcodes(String code);

    List<CodeInfo> findByCodeStartingWith(String code);
}




