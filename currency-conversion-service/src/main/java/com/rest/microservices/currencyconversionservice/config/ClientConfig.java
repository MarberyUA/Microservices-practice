package com.rest.microservices.currencyconversionservice.config;

import com.rest.microservices.currencyconversionservice.client.CurrencyExchangeServiceClient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties("currency-conversion-service")
@Getter
@Setter
public class ClientConfig {
    private String currencyExchangeServiceUrl;
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public CurrencyExchangeServiceClient getCurrencyExchangeServiceClient() {
        return new CurrencyExchangeServiceClient(currencyExchangeServiceUrl, restTemplate);
    }
}
