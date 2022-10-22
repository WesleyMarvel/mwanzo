package com.example.mwanzo.persistence;

import com.example.mwanzo.domain.ClaimedToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClaimedTokenRepository extends JpaRepository<ClaimedToken, Long> {
    Optional<ClaimedToken> findByTokenId(Long tokenId);
    Optional<ClaimedToken> findByCustomer_Id(Long customerId);
    ClaimedToken deleteByTokenId(Long tokenId);
}
