package com.example.mwanzo.service.claimedtoken;

import com.example.mwanzo.domain.ClaimedToken;
import com.example.mwanzo.domain.Customer;
import com.example.mwanzo.domain.NftRecord;
import com.example.mwanzo.persistence.ClaimedTokenRepository;
import com.example.mwanzo.persistence.CustomerRepository;
import com.example.mwanzo.persistence.TokenRecordRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ClaimedTokenServiceImpl implements ClaimedTokenService{
    private final ClaimedTokenRepository claimedTokenRepository;
    private final TokenRecordRepository tokenRecordRepository;
    private final CustomerRepository customerRepository;

    public ClaimedTokenServiceImpl(ClaimedTokenRepository claimedTokenRepository, TokenRecordRepository tokenRecordRepository, CustomerRepository customerRepository) {
        this.claimedTokenRepository = claimedTokenRepository;
        this.tokenRecordRepository = tokenRecordRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<ClaimedToken> getAll(){
        return claimedTokenRepository.findAll();
    }

    @Override
    public ClaimedTokenDto getByTokenId(Long tokenId){
        Optional<ClaimedToken> optionalClaimedToken = claimedTokenRepository.findByTokenId(tokenId);
        if (optionalClaimedToken.isEmpty()){
            throw new NullPointerException("This field is empty");
        }
        return ClaimedTokenDto.of(optionalClaimedToken.get());
    }

    @Override
    public ClaimedTokenDto getByOwner(Long customerId){
        Optional<ClaimedToken> claimedToken = claimedTokenRepository.findByCustomer_Id(customerId);
        if (claimedToken.isEmpty()){
            throw new NullPointerException("This record was no found");
        }
        return ClaimedTokenDto.of(claimedToken.get());
    }

    @Override
    public ClaimedTokenDto create(ClaimedTokenRequest claimedTokenRequest){
        ClaimedToken claimedToken = new ClaimedToken();
        claimedToken.setClaimed(claimedTokenRequest.getClaimed());
        String contractAddress = tokenRecordRepository.findAll()
                .stream()
                .filter(contractAdd -> contractAdd.getTokenAddress().equals(claimedTokenRequest.getTokenId()))
                .map(NftRecord::getTokenAddress)
                .toString();
        Optional<Customer> customer = customerRepository.findById(claimedTokenRequest.getCustomerId());
        if (customer.isEmpty()){
            throw new NullPointerException("This customer does not exist");
        }
        claimedToken.setContractAddress(contractAddress);
        claimedToken.setTokenId(claimedTokenRequest.getTokenId());
        claimedToken.setCustomer(customer.get());
        ClaimedToken savedClaimedToken = claimedTokenRepository.save(claimedToken);
        return ClaimedTokenDto.of(savedClaimedToken);
    }

    @Override
    public ClaimedTokenDto update(Long tokenId, ClaimedTokenRequest claimedTokenRequest){
        Optional<ClaimedToken> optionalClaimedToken = claimedTokenRepository.findById(tokenId);
        if (optionalClaimedToken.isEmpty()){
            throw new NullPointerException("This Record was not found");
        }
        ClaimedToken updatedClaimedToken = new ClaimedToken();
        updatedClaimedToken.setClaimed(claimedTokenRequest.getClaimed());
        String contractAddress = tokenRecordRepository.findAll().
                stream().
                filter(contractAdd -> contractAdd.getTokenAddress().equals(claimedTokenRequest.getTokenId()))
                .map(NftRecord::getTokenAddress)
                .toString();
        Optional<Customer> customer = customerRepository.findById(claimedTokenRequest.getCustomerId());
        if (customer.isEmpty()){
            throw new NullPointerException("This customer does not exist");
        }
        updatedClaimedToken.setContractAddress(contractAddress);
        updatedClaimedToken.setTokenId(claimedTokenRequest.getTokenId());
        updatedClaimedToken.setCustomer(customer.get());
        ClaimedToken savedUpdatedClaimedToken = claimedTokenRepository.save(updatedClaimedToken);
        return ClaimedTokenDto.of(savedUpdatedClaimedToken);
    }
    @Override
    public void delete(Long tokenId){
        if (tokenId == null){
            throw new NullPointerException("This record was not found");
        }
        claimedTokenRepository.deleteByTokenId(tokenId);
    }
}
