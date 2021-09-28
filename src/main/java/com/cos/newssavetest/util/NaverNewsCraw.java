package com.cos.newssavetest.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cos.newssavetest.domain.NaverNews;

@Component
public class NaverNewsCraw {
	int aidNum = 1;
	
	public List<NaverNews> collect() {
		
		RestTemplate rt = new RestTemplate();
		
		
		List<NaverNews> newsList = new ArrayList<>();

		for (int i = 1; i < 6; i++) {
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
				NaverNews navernews = NaverNews.builder()
						.company(company)
						.title(title)
						.createdAt(time)
						.href(url)
						.build();

				newsList.add(navernews);

			} catch (Exception e) {

			}

			aidNum++;

		}
		 
		return newsList;
		
		
	}

}
