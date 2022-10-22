package com.example.mwanzo.service.claimedtoken;

import com.example.mwanzo.domain.ClaimedToken;
import com.example.mwanzo.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimedTokenDto {
    private Long id;
    private Boolean claimed;
    private String contractAddress;
    private Customer customer;
    private Long tokenId;

    public static ClaimedTokenDto of(ClaimedToken claimedToken){
        Objects.requireNonNull(claimedToken);
        ClaimedTokenDto claimedTokenDto = new ClaimedTokenDto();
        claimedTokenDto.setId(claimedToken.getId());
        claimedTokenDto.setClaimed(claimedToken.getClaimed());
        claimedTokenDto.setContractAddress(claimedTokenDto.getContractAddress());
        claimedTokenDto.setCustomer(claimedTokenDto.getCustomer());
        claimedTokenDto.setTokenId(claimedTokenDto.getTokenId());
        return claimedTokenDto;
    }
}
