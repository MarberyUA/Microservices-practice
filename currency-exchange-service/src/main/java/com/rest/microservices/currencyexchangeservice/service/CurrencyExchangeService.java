package com.rest.microservices.currencyexchangeservice.service;

import com.rest.microservices.currencyexchangeservice.model.CurrencyExchange;

import java.util.Optional;

public interface CurrencyExchangeService extends GenericService<CurrencyExchange> {
    Optional<CurrencyExchange> findByFromAndTo(String from, String to);
}
