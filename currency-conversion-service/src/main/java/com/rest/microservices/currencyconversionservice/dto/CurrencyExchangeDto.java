package com.rest.microservices.currencyconversionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyExchangeDto {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
}
