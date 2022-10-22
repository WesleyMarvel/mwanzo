package com.example.mwanzo.service;

import com.example.mwanzo.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();

    CustomerDto getById(Long customerId);

    CustomerDto getByWalletAddress(String walletAddress);

    CustomerDto createCustomer(CustomerRequest customerRequest);

    CustomerDto updateCustomer(Long customerId, CustomerRequest customerRequest);

    void delete(Long customerId);
}
