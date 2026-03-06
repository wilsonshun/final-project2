package com.bootcamp.demo.project_data_provider.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
public class StockQuoteDto {
  @Builder.Default
  private List<QuoteDto> quoteDtos = new ArrayList<>();

  @Builder.Default
  private LocalDateTime quoteTime = LocalDateTime.now();

  @Getter
  @Builder
  public static class QuoteDto {
    @Setter
    private String symbol;
    private Double close;
    private Double high;
    private Double low;
    private Double open;
    private Double time;
    private Double prevClose;
  }
}
