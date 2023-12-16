package com.code.cmsystem.controllers;


import com.code.cmsystem.entities.Customer;
import com.code.cmsystem.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        List<Customer> allCustomers = customerService.getCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long theId){
        Customer theCustomer = customerService.getCustomer(theId);
        return new ResponseEntity<>(theCustomer,HttpStatus.OK);
    }

    public int calcAge(Customer customer)
    {
        LocalDate date = LocalDate.parse(customer.getDob());
        Period age = Period.between(date,LocalDate.now());
        return age.getYears();
    }
    public boolean checkOccupation(Customer customer)
    {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("developer");
        arrayList.add("chef");
        arrayList.add("plumber");
        arrayList.add("carpenter");
        arrayList.add("other");
        boolean flag= false;
        for (String occupation: arrayList) {
            if(occupation.equals(customer.getOccupation()))
            {
                flag=true;
            }
        }
        return flag;
    }
    public boolean checkGroup(Customer customer)
    {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hikeon");
        arrayList.add("chef");
        arrayList.add("developer");
        arrayList.add("NA");

        boolean flag= false;
        for (String group: arrayList) {
            if(group.equals(customer.getCustomer_group()))
            {
                flag=true;
            }
        }
        return flag;
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){



        if(calcAge(customer)<18)
        {
            throw new RuntimeException("Age below 18 years");
        }
        if(!checkOccupation(customer))
        {
            throw new RuntimeException("Not desired occupation");
        }
        if(!checkGroup(customer))
        {
            throw new RuntimeException("Not desired group");
        }
        Customer theCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(theCustomer,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        Customer theCustomer = customerService.addCustomer(customer);
        if(calcAge(theCustomer)<18)
        {
            throw new RuntimeException("Age below 18 years");
        }
        if(!checkOccupation(theCustomer))
        {
            throw new RuntimeException("Not desired occupation");
        }
        if(!checkGroup(theCustomer))
        {
            throw new RuntimeException("Not desired group");
        }
        return new ResponseEntity<>(theCustomer,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long theId){
        customerService.deleteCustomer(theId);
    }

}
