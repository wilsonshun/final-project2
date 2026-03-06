package com.bootcamp.demo.project_data_provider.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.project_data_provider.dto.StockQuoteDto;
import com.bootcamp.demo.project_data_provider.model.dto.QuoteDTO;

@Component
public class DtoMapper {
  public StockQuoteDto.QuoteDto map(QuoteDTO quoteDTO) {
    return StockQuoteDto.QuoteDto.builder() //
      .open(quoteDTO.getOpen())
      .high(quoteDTO.getHigh())
      .low(quoteDTO.getLow())
      .close(quoteDTO.getClose())
      .prevClose(quoteDTO.getPrevClose())
      .time(quoteDTO.getTime())
      .build();
  }
}
