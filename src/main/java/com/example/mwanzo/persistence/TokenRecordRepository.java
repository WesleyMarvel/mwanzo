package com.example.mwanzo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mwanzo.domain.NftRecord;

import java.util.Optional;

public interface TokenRecordRepository extends JpaRepository<NftRecord, Long> {

    Optional<NftRecord> findByTokenAddress(String tokenAddress);

}
