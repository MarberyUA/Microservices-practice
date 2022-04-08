package com.rest.microservices.currencyconversionservice.controller;

import com.rest.microservices.currencyconversionservice.dto.CurrencyExchangeDto;
import com.rest.microservices.currencyconversionservice.proxy.CurrencyExchangeProxy;
import com.rest.microservices.currencyconversionservice.service.CurrencyConversionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-conversion")
@AllArgsConstructor
public class CurrencyConversionController {

    private CurrencyConversionService currencyConversionService;
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/from/{exchangingCurrency}/to/{wantedCurrency}/quantity/{quantity}")
    public void getCurrencyConversionData(@PathVariable String exchangingCurrency, @PathVariable String wantedCurrency,
                                          @PathVariable BigDecimal quantity) {
        currencyConversionService.getFromAndToWithQuantityViaRest(exchangingCurrency, wantedCurrency, quantity);
    }

    @GetMapping("/feign/from/{exchangingCurrency}/to/{wantedCurrency}/quantity/{quantity}")
    public void getCurrencyConversionDataViaFeign(@PathVariable String exchangingCurrency, @PathVariable String wantedCurrency,
                                          @PathVariable BigDecimal quantity) {
        CurrencyExchangeDto currencyExchangeDto = currencyExchangeProxy.getCurrencyExchangeData(exchangingCurrency, wantedCurrency);
        System.out.println(currencyExchangeDto);
    }
}
