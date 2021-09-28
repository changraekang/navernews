package com.cos.newssavetest;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;


public class NaverNewsTest {
	
	
	
	public void test1() {
		
		RestTemplate rt = new RestTemplate();
		String url= "https://news.naver.com/main/read.naver?mode=LSD&mid=shm&sid1=102&oid=022&aid=0000000001";
		String html = rt.getForObject(url, String.class);
		
		Document doc = null;
		
		doc = Jsoup.parse(html);

		Element companyelem = doc.selectFirst("#wrap > table > tbody > tr > td.aside > div > div:nth-child(1) > h4 > em");
		Element titleelem = doc.selectFirst("#articleTitle");
		Element createdAtelem = doc.selectFirst("#main_content > div.article_header > div.article_info > div > span:nth-child(1)");
		String company =companyelem.text();
		String title =titleelem.text();
		String createdAt =createdAtelem.text();
		System.out.println(company);
		System.out.println(title); 
		System.out.println(createdAt);
	
	}
	
	@Test
	public void test3() {
		RestTemplate rt = new RestTemplate();
		List<NewsTest> nts = new ArrayList<>();
		
		int aidNum = 1 ; 
		for (int i = 1; i < 10; i++) {
			String aid = String.format("%010d", aidNum);
			String url = "https://news.naver.com/main/read.naver?mode=LSD&mid=shm&sid1=102&oid=022&aid=" + aid;
			String html = rt.getForObject(url, String.class);
			Document doc = null;
			doc = Jsoup.parse(html);
			try {
				
				Element titleelem = doc.selectFirst("#articleTitle");
				Element timeelem = doc.selectFirst(".t11");
				Element companyelem = doc.selectFirst("#wrap > table > tbody > tr > td.aside > div > div:nth-child(1) > h4 > em");
				String company = companyelem.text();
				String title = titleelem.text();
				String time = timeelem.text();
				System.out.println(title); //jsoup로 id: articleTitle를 파싱해야함
				System.out.println(time);
				System.out.println(company);
				
				NewsTest nt = NewsTest.builder()
						.title(title)
						.time(time)
						.build();
				
				nts.add(nt);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			aidNum++;
			
			
			
			
			
		}
		System.out.println(nts.size());
		

	}
	
	
}
