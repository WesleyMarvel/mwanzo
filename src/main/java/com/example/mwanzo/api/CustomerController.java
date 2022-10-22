package com.example.mwanzo.api;
import com.example.mwanzo.domain.Customer;
import com.example.mwanzo.service.CustomerDto;
import com.example.mwanzo.service.CustomerRequest;
import com.example.mwanzo.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getById(@PathVariable Long customerId){
        return customerService.getById(customerId);
    }

    @GetMapping("/walletAddress/")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getByWalletAddress(String walletAddress){
        return customerService.getByWalletAddress(walletAddress);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto createCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.createCustomer(customerRequest);
    }

    @PutMapping("/update/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto updateCustomer(@PathVariable Long customerId, @RequestBody CustomerRequest customerRequest){
        return customerService.updateCustomer(customerId, customerRequest);
    }

    @DeleteMapping("/delete/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long customerId){
        customerService.delete(customerId);
    }
}
