package com.example.mwanzo.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String walletAddress;
    private String mobileNumber;
    private String socialMedia;
    private String profession;

}
