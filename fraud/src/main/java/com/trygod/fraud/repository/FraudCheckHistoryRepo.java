package com.trygod.fraud.repository;

import com.trygod.fraud.entity.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudCheckHistoryRepo extends JpaRepository<FraudCheckHistory, Integer> {

}
