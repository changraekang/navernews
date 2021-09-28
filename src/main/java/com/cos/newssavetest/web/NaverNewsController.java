package com.cos.newssavetest.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.newssavetest.domain.NaverNews;
import com.cos.newssavetest.domain.NaverNewsRepository;
import com.cos.newssavetest.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class NaverNewsController {

	private final NaverNewsRepository naverNewsRepository;
	
	@GetMapping("/news")
	public CMRespDto<List<NaverNews>> findAll(){
	      return new CMRespDto<>(1, "성공", naverNewsRepository.findAll());
	   } 
}
