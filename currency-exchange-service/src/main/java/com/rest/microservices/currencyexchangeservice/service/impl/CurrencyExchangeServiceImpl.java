package com.rest.microservices.currencyexchangeservice.service.impl;

import com.rest.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.rest.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.rest.microservices.currencyexchangeservice.service.CurrencyExchangeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    private CurrencyExchangeRepository currencyExchangeRepository;
    private Environment environment;

    @Override
    public Optional<CurrencyExchange> findByFromAndTo(String from, String to) {
        log.info("lol");
        Optional<CurrencyExchange> currencyExchange = currencyExchangeRepository
                .findByFromAndTo(from, to);
        currencyExchange.ifPresent(x -> x.setEnvironment(environment.getProperty("local.server.port")));
        return currencyExchange;
    }

    @Override
    public CurrencyExchange findBy(Long id) {
        return currencyExchangeRepository.getById(id);
    }

    @Override
    public void save(CurrencyExchange obj) {
        currencyExchangeRepository.save(obj);
    }

    @Override
    public void remove(CurrencyExchange obj) {
        currencyExchangeRepository.delete(obj);
    }
}
