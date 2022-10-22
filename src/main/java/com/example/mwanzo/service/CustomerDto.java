package com.example.mwanzo.service;

import com.example.mwanzo.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String walletAddress;
    private String mobileNumber;
    private String socialMedia;
    private String profession;

    public static CustomerDto of(Customer customer){
        Objects.requireNonNull(customer);
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setWalletAddress(customer.getWalletAddress());
        customerDto.setMobileNumber(customer.getMobileNumber());
        customerDto.setSocialMedia(customer.getSocialMedia());
        customerDto.setProfession(customer.getProfession());
        return customerDto;
    }

}
