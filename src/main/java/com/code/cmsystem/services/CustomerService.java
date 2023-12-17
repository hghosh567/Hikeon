package com.code.cmsystem.services;

import com.code.cmsystem.entities.Customer;
import com.code.cmsystem.exceptions.CustomerNotFoundException;
import com.code.cmsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerService {

    private final CustomerRepository customerRepository;

    //This is the service layer to handle requests to Repo Layer

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long theId) {
        return customerRepository.findById(theId)
                .orElseThrow(() -> new CustomerNotFoundException("The required customer couldn't be found"));
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long theId) {
        customerRepository.deleteById(theId);
    }
}
