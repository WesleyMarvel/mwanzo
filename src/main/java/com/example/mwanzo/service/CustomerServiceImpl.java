package com.example.mwanzo.service;

import com.example.mwanzo.domain.Customer;
import com.example.mwanzo.persistence.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    @Override
    public CustomerDto getById(Long customerId){
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isEmpty()){
            throw new NullPointerException("Record not found");
        }
        return CustomerDto.of(optionalCustomer.get());
    }

    @Override
    public CustomerDto getByWalletAddress(String walletAddress){
        Optional<Customer> optionalCustomer = customerRepository.findByWalletAddress(walletAddress);
        if (optionalCustomer.isEmpty()){
            throw new NullPointerException("Record not found");
        }
        return CustomerDto.of(optionalCustomer.get());
    }

    @Override
    public CustomerDto createCustomer(CustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setEmail(customerRequest.getEmail());
        customer.setWalletAddress(customerRequest.getWalletAddress());
        customer.setMobileNumber(customerRequest.getMobileNumber());
        customer.setSocialMedia(customerRequest.getSocialMedia());
        customer.setProfession(customerRequest.getProfession());
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerDto.of(savedCustomer);
    }

    @Override
    public CustomerDto updateCustomer(Long customerId, CustomerRequest customerRequest){
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isEmpty()){
            throw new NullPointerException("Record not found");
        }
        Customer customer = optionalCustomer.get();
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setEmail(customerRequest.getEmail());
        customer.setWalletAddress(customerRequest.getWalletAddress());
        customer.setMobileNumber(customerRequest.getMobileNumber());
        customer.setSocialMedia(customerRequest.getSocialMedia());
        customer.setProfession(customerRequest.getProfession());
        Customer updatedCustomer = customerRepository.save(customer);
        return CustomerDto.of(updatedCustomer);
    }

    @Override
    public void delete(Long customerId){
        if (customerId == null){
            throw new NullPointerException("This record was not found");
        }
        customerRepository.deleteById(customerId);
    }
}
