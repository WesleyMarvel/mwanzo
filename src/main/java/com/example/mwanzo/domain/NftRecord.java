package com.example.mwanzo.domain;

import javax.persistence.*;

@Entity
@Table(name = "nft_record",uniqueConstraints = { @UniqueConstraint(name = "tokenAddress", columnNames = {"token_address"}) })
public class NftRecord {

    @Id
    @GeneratedValue
    private Long tokenId;
    @Column(unique = true, nullable = false, name = "token_address")
    private String tokenAddress;
    @Column(name = "token_count")
    private Integer tokenCount;

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public String getTokenAddress() {
        return tokenAddress;
    }

    public void setTokenAddress(String tokenAddress) {
        this.tokenAddress = tokenAddress;
    }

    public Integer getTokenCount() {
        return tokenCount;
    }

    public void setTokenCount(Integer tokenCount) {
        this.tokenCount = tokenCount;
    }
}
