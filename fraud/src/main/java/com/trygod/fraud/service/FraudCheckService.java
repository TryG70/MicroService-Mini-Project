package com.trygod.fraud.service;

import com.trygod.fraud.entity.FraudCheckHistory;
import com.trygod.fraud.repository.FraudCheckHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraudCheckService {

    private final FraudCheckHistoryRepo fraudCheckHistoryRepo;

    @Autowired
    public FraudCheckService(FraudCheckHistoryRepo fraudCheckHistoryRepo) {
        this.fraudCheckHistoryRepo = fraudCheckHistoryRepo;
    }

    public Boolean isFraudster(Integer customerId) {

        fraudCheckHistoryRepo.save(FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .build());
        return false;
    }

}
