package com.rest.microservices.currencyconversionservice.client;

import com.rest.microservices.currencyconversionservice.dto.CurrencyExchangeDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@AllArgsConstructor
public class CurrencyExchangeServiceClient {

    private String currencyExchangeServiceUrl;
    private RestTemplate restTemplate;

    public CurrencyExchangeDto getCurrencyExchange(String from, String to) {
        UriBuilder uriBuilder = UriComponentsBuilder.fromUriString(currencyExchangeServiceUrl + "/currency-exchange/from/{from}/to/{to}");
        return restTemplate.getForObject(uriBuilder.build(from, to).toString(), CurrencyExchangeDto.class);
    }
}
