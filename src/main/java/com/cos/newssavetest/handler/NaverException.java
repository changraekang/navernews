package com.cos.newssavetest.handler;

import org.springframework.data.annotation.Id; 
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
@Document( collection = "naver_exception" )
public class NaverException {

	
	@Id
	private String _id;
	
	private String exception;
	private String url;
}
