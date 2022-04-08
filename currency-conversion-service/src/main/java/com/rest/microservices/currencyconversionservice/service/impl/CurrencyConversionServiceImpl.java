package com.rest.microservices.currencyconversionservice.service.impl;

import com.rest.microservices.currencyconversionservice.client.CurrencyExchangeServiceClient;
import com.rest.microservices.currencyconversionservice.dto.CurrencyExchangeDto;
import com.rest.microservices.currencyconversionservice.model.CurrencyConversion;
import com.rest.microservices.currencyconversionservice.service.CurrencyConversionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@AllArgsConstructor
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    private CurrencyExchangeServiceClient currencyExchangeServiceClient;

    @Override
    public CurrencyConversion getFromAndToWithQuantityViaRest(String from, String to, BigDecimal quantity) {
        CurrencyExchangeDto currencyExchangeDto = currencyExchangeServiceClient.getCurrencyExchange(from, to);
        return null;
    }
}
