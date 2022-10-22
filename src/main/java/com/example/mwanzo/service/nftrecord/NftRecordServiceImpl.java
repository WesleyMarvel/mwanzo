package com.example.mwanzo.service.nftrecord;

import com.example.mwanzo.domain.NftRecord;
import com.example.mwanzo.persistence.TokenRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NftRecordServiceImpl implements NftRecordService{
    private final TokenRecordRepository tokenRecordRepository;

    public NftRecordServiceImpl(TokenRecordRepository tokenRecordRepository) {
        this.tokenRecordRepository = tokenRecordRepository;
    }

    @Override
    public List<NftRecord> getAll(){
        return tokenRecordRepository.findAll();
    }

    @Override
    public NftRecordDto getById(Long tokenId){
        Optional<NftRecord> optionalNftRecord = tokenRecordRepository.findById(tokenId);
        if (optionalNftRecord.isEmpty()){
            throw new NullPointerException("Record Not Found");
        }
        return NftRecordDto.of(optionalNftRecord.get());
    }

    @Override
    public NftRecordDto create(NftRecordRequest nftRecordRequest){
        NftRecord nftRecord = new NftRecord();
        nftRecord.setTokenAddress(nftRecordRequest.getTokenAddress());
        nftRecord.setTokenCount(nftRecordRequest.getTokenCount());
        NftRecord savedNftRecord = tokenRecordRepository.save(nftRecord);
        return NftRecordDto.of(savedNftRecord);
    }

    @Override
    public NftRecordDto update(Long tokenId, NftRecordRequest nftRecordRequest){
        Optional<NftRecord> optionalNftRecord = tokenRecordRepository.findById(tokenId);
        if (optionalNftRecord.isEmpty()){
            throw new NullPointerException("This Record was not found");
        }
        NftRecord nftRecord = optionalNftRecord.get();
        nftRecord.setTokenAddress(nftRecordRequest.getTokenAddress());
        nftRecord.setTokenCount(nftRecordRequest.getTokenCount());
        NftRecord savedNftRecord = tokenRecordRepository.save(nftRecord);
        return NftRecordDto.of(savedNftRecord);
    }

    @Override
    public NftRecordDto getByTokenAddress(String tokenAddress){
        Optional<NftRecord> optionalNftRecord = tokenRecordRepository.findByTokenAddress(tokenAddress);
        if (optionalNftRecord.isEmpty()){
            throw new NullPointerException("Record not found");
        }
        return NftRecordDto.of(optionalNftRecord.get());
    }

    @Override
    public void delete(Long tokenId){
        if (tokenId == null){
            throw new NullPointerException("This record was not found");
        }
        tokenRecordRepository.deleteById(tokenId);
    }
}
