package com.bootcamp.demo.project_data_provider.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.project_data_provider.controller.QuoteOperation;
import com.bootcamp.demo.project_data_provider.dto.StockQuoteDto;
import com.bootcamp.demo.project_data_provider.mapper.DtoMapper;
import com.bootcamp.demo.project_data_provider.model.dto.QuoteDTO;
import com.bootcamp.demo.project_data_provider.service.FinnhubService;

@RestController
public class QuoteController implements QuoteOperation{
  @Autowired
  private FinnhubService finnhubService;

  @Autowired
  private DtoMapper dtoMapper;

  // ! TBC -> Redis
  @Override
  public StockQuoteDto getQuotes(List<String> symbols) throws Exception {
    StockQuoteDto stockQuoteDto = StockQuoteDto.builder().build();
    for (String symbol : symbols) {
      QuoteDTO quoteDTO = this.finnhubService.getQuote(symbol);
      // Sleep 5 second
      Thread.sleep(5000);
      StockQuoteDto.QuoteDto quoteDto = this.dtoMapper.map(quoteDTO);
      quoteDto.setSymbol(symbol);
      stockQuoteDto.getQuoteDtos().add(quoteDto);
    }
    return stockQuoteDto;
  }
}
