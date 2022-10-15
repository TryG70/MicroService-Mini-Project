package com.trygod.customer.service;

import com.trygod.customer.dto.CustomerDto;
import com.trygod.customer.entity.Customer;
import com.trygod.customer.repository.CustomerRepository;
import com.trygod.customer.response.FraudCheckResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {


    public void registerCustomer(CustomerDto customerDto) {

        Customer customer = Customer.builder()
                .firstName(customerDto.firstName())
                .lastName(customerDto.lastName())
                .email(customerDto.email())
                .build();

        //todo: check if email is valid
        //todo: check if email is already registered

        customerRepository.saveAndFlush(customer);

        //todo: check if customer is a fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Customer is a fraudster");
        }


        //todo: send notification
    }
}
