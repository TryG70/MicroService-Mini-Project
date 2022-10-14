package com.trygod.fraud.controller;

import com.trygod.fraud.response.FraudCheckResponse;
import com.trygod.fraud.service.FraudCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/fraud-check")
public class FraudCheckHistoryController {

    private final FraudCheckService fraudCheckService;

    @Autowired
    public FraudCheckHistoryController(FraudCheckService fraudCheckService) {
        this.fraudCheckService = fraudCheckService;
    }

    @GetMapping(path = "/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {

        boolean isFraudulentCustomer = fraudCheckService.isFraudster(customerId);

        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
