package com.rest.microservices.limitsservice.controller;

import com.rest.microservices.limitsservice.bean.Limits;
import com.rest.microservices.limitsservice.configuration.Configuration;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LimitsController {

    private Configuration configuration;

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(configuration.getMaximum(), configuration.getMinimum());
    }
}
