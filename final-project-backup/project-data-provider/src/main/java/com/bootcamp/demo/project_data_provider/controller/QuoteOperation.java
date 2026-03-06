package com.bootcamp.demo.project_data_provider.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bootcamp.demo.project_data_provider.dto.StockQuoteDto;

public interface QuoteOperation {
  @GetMapping(value = "/getQuote")
  StockQuoteDto getQuotes(@RequestBody List<String> symbols) throws Exception;
}
