package com.cos.newssavetest.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NaverNewsRepository extends MongoRepository<NaverNews, String> {

}
