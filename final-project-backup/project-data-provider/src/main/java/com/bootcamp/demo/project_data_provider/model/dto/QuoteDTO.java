package com.bootcamp.demo.project_data_provider.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


//! @JsonProperty -> 對應 JSON 入面嘅 Key 

@Getter
public class QuoteDTO {
  @JsonProperty(value = "c")
  private Double close;
  @JsonProperty(value = "h")
  private Double high;
  @JsonProperty(value = "l")
  private Double low;
  @JsonProperty(value = "o")
  private Double open;
  @JsonProperty(value = "t")
  private Double time;
  @JsonProperty(value = "pc")
  private Double prevClose;
}

//! DTO 專門接收 Finnhub API 回傳嘅 JSON 
//! API 回傳 JSON -> Java 物件嘅橋樑
//! @JsonProperty 將短字母 key 對應到有意義嘅 Java Field 

