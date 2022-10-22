package com.example.mwanzo.service.claimedtoken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimedTokenRequest {
    private Long id;
    private Boolean claimed;
    private String contractAddress;
    private Long customerId;
    private Long tokenId;
}
