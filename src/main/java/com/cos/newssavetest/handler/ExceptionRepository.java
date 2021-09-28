package com.cos.newssavetest.handler;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExceptionRepository extends MongoRepository<NaverException,String >{

}
