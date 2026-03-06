package com.bootcamp.demo.project_data_provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.project_data_provider.model.dto.QuoteDTO;
import com.bootcamp.demo.project_data_provider.service.FinnhubService;

//! @Service -> Spring Boot 會自動管理，方便其他地方用 @Autowired 注入
//! @Autowired -> Spring Boot 會自動注入 RestTemplate，用嚟發 HTTP Request

@Service
public class FinnhubServiceImpl implements FinnhubService {
  @Autowired
  private RestTemplate restTemplate;

  @Value("${api.finnhub.api-key}")
  private String apiKey;

  @Value("${api.finnhub.host}")
  private String host;

  @Value("${api.finnhub.version}")
  private String version;

  @Value("${api.finnhub.quote}")
  private String quoteEndpoint;

  @Override
  public QuoteDTO getQuote(String symbol) {
    String url = UriComponentsBuilder.newInstance() //
        .scheme("https") //
        .host(this.host) //
        .pathSegment(this.version) //
        .path(this.quoteEndpoint) //
        .queryParam("symbol", symbol) //
        .queryParam("token", this.apiKey) //
        .build() //
        .toUriString();
    System.out.println("url=" + url);
    return this.restTemplate.getForObject(url, QuoteDTO.class);
  }
}

//! @Value("${api.finnhub.api-key}") -> 由 application.yml 讀取設定值
//! 用 UriComponentsBuilder 建遧一個完成嘅 API URL 
//! .toUriString() 轉成字串 URL 
//! restTemplate.getForObject(url, QuoteDTO.class) -> 發 HTTP GET request，將 JSON Response 自動轉成 QuoteDTO. 