package com.bootcamp.demo.project_data_provider.service;

import com.bootcamp.demo.project_data_provider.model.dto.QuoteDTO;

public interface FinnhubService {
  // DTO
  QuoteDTO getQuote(String symbol);
}

//! 轉入一個股票代號 (symbol)，就要返回 QuoteDTO 
//! QuoteDTO 用嚟包住 API回傳嘅股票報價資料
