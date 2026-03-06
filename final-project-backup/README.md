# final-project

# config > AppConfig.java
# 建立咗一個 RestTemplate Bean, 方便其他 Service 用嚟 call API 

# QuoteOperation 定義咗一個 REST API Endpoint: /getQuote
# 當用戶 call /getQuote，QuoteControll 會收到 symbols list，用 FinnHub Service call API 攞 quote

# model > dto -> mapper > DtoMapper -> dto > StockQuoteDto

# model > dto -> 用 @JsonProperty 將 Finnhub API 嘅 JSON key 對應到 Javafield

# 用 DtoMapper 將 QuoteDTO 轉成 StockQuoteDto.QuoteDto
# 最後組合成 StockQuoteDto 返回

# FinnhubServiceImpl 利用 RestTemplate 去 call Finnhub API 
# 會根據 application.properties 入面設定 api-key 等拼 url，最後返回 QuoteDto 

# 用戶 call /getQuote -> QuoteController 
# QuoteController 呼叫 FinnhubService.getQuote(symbol)
# FinnhubServiceImpl 用 RestTemplate 去 Finnhub API 攞 JSON,轉成QuoteDTO 
# QuoteController 再用 DtoMapper 將 QuoteDTO 轉成 StockQuoteDto.QuoteDto
# 最後組合成 StockQuoteDto 返回俾用戶



