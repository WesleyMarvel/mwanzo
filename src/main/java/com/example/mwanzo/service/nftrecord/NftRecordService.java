package com.example.mwanzo.service.nftrecord;

import com.example.mwanzo.domain.NftRecord;

import java.util.List;

public interface NftRecordService {

    List<NftRecord> getAll();

    NftRecordDto create(NftRecordRequest nftRecordRequest);

    NftRecordDto update(Long tokenId, NftRecordRequest nftRecordRequest);

    NftRecordDto getById(Long tokenId);

    NftRecordDto getByTokenAddress(String tokenAddress);

    void delete(Long tokenId);
}
