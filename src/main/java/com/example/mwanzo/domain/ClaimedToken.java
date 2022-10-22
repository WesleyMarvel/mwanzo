package com.example.mwanzo.domain;

import javax.persistence.*;
import java.util.stream.Stream;

@Entity
public class ClaimedToken {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Boolean claimed;
    @Column
    private String contractAddress;
    @ManyToOne
    private Customer customer;
    @Column
    private Long tokenId;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getClaimed() {
        return claimed;
    }

    public void setClaimed(Boolean claimed) {
        this.claimed = claimed;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }
}
