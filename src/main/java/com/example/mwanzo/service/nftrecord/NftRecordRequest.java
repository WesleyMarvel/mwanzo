package com.example.mwanzo.service.nftrecord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NftRecordRequest {
    private String tokenAddress;
    private Integer tokenCount;
}
