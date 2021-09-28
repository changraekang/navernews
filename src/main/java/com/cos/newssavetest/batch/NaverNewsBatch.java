package com.cos.newssavetest.batch;

import java.util.List; 

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cos.newssavetest.domain.NaverNews;
import com.cos.newssavetest.domain.NaverNewsRepository;
import com.cos.newssavetest.util.NaverNewsCraw;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component
public class NaverNewsBatch {


	private final NaverNewsRepository naverNewsRepository;
	private final NaverNewsCraw naverNewsCraw;
	
	
	@Scheduled(fixedDelay = 1000 * 1 * 1)
	public void newsCrawAndSave() {
		
		
		List<NaverNews> newsList = naverNewsCraw.collect();
		naverNewsRepository.saveAll(newsList);
	}
}
	

