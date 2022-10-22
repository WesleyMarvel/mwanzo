package com.example.mwanzo.service.claimedtoken;

import com.example.mwanzo.domain.ClaimedToken;

import java.util.List;

public interface ClaimedTokenService {
    List<ClaimedToken> getAll();

    ClaimedTokenDto getByTokenId(Long tokenId);

    ClaimedTokenDto getByOwner(Long customerId);

    ClaimedTokenDto create(ClaimedTokenRequest claimedTokenRequest);

    ClaimedTokenDto update(Long tokenId, ClaimedTokenRequest claimedTokenRequest);

    void delete(Long tokenId);

}
