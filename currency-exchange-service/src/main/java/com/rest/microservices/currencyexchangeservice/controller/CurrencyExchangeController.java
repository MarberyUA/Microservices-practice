package com.rest.microservices.currencyexchangeservice.controller;

import com.rest.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.rest.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.rest.microservices.currencyexchangeservice.service.CurrencyExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/currency-exchange")
@AllArgsConstructor
public class CurrencyExchangeController {

    private CurrencyExchangeService currencyExchangeService;

    @GetMapping("/from/{exchangingCurrency}/to/{wantedCurrency}")
    public CurrencyExchange getCurrencyExchangeData(@PathVariable String exchangingCurrency, @PathVariable String wantedCurrency) {
        return currencyExchangeService
                .findByFromAndTo(exchangingCurrency, wantedCurrency)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "A conversion of exchanging currency and wanted currency was not found!"));
    }
}
