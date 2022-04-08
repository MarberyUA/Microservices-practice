package com.rest.microservices.currencyconversionservice.proxy;

import com.rest.microservices.currencyconversionservice.dto.CurrencyExchangeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {
    @GetMapping("/currency-exchange/from/{exchangingCurrency}/to/{wantedCurrency}")
    CurrencyExchangeDto getCurrencyExchangeData(@PathVariable String exchangingCurrency, @PathVariable String wantedCurrency);
}