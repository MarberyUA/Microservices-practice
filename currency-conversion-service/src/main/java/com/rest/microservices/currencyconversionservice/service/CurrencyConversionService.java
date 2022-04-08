package com.rest.microservices.currencyconversionservice.service;

import com.rest.microservices.currencyconversionservice.model.CurrencyConversion;

import java.math.BigDecimal;

public interface CurrencyConversionService extends GenericService {
    CurrencyConversion getFromAndToWithQuantityViaRest(String from, String to, BigDecimal quantity);
}
