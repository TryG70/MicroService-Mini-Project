package com.trygod.customer.controller;

import com.trygod.customer.dto.CustomerDto;
import com.trygod.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/customer")
public record CustomerController(CustomerService customerService) {

    @PostMapping("/register")
    public void registerCustomer(@RequestBody CustomerDto customerDto) {
        log.info("new customer registration {}", customerDto);
        customerService.registerCustomer(customerDto);
    }
}
