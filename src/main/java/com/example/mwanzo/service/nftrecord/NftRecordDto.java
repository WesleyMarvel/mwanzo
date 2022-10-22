package com.example.mwanzo.service.nftrecord;

import com.example.mwanzo.domain.NftRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NftRecordDto {
    private Long tokenId;
    private String tokenAddress;
    private Integer tokenCount;

    public static NftRecordDto of(NftRecord nftRecord){
        Objects.requireNonNull(nftRecord);
        NftRecordDto nftRecordDto = new NftRecordDto();
        nftRecordDto.setTokenId(nftRecord.getTokenId());
        nftRecordDto.setTokenAddress(nftRecord.getTokenAddress());
        nftRecordDto.setTokenCount(nftRecord.getTokenCount());
        return nftRecordDto;
    }
}
