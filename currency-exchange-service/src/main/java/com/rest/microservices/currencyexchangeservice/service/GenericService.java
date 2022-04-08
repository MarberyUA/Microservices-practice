package com.rest.microservices.currencyexchangeservice.service;

public interface GenericService<T> {
    T findBy(Long id);
    void save(T obj);
    void remove(T id);
}
