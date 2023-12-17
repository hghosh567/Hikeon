package com.code.cmsystem;

import com.code.cmsystem.entities.Customer;
import com.code.cmsystem.repositories.CustomerRepository;
import org.junit.jupiter.api.*;
import org.mockito.internal.hamcrest.HamcrestArgumentMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.hamcrest.CoreMatchers.*;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerRepoTests {

    @Autowired
    private CustomerRepository customerRepository;

    //Following method tests adding customer
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveCustomerTest(){
        Customer customer = new Customer();
        customer.setName("Oswald");
        customer.setDob("1980-10-01");
        customer.setEmail("fur@gmail.com");
        customer.setOccupation("developer");
        customer.setCustomer_group("developer");

        customerRepository.save(customer);
        Assertions.assertTrue(customer.getId()>0);


    }
    //Following method tests getting all customers
    @Test
    @Order(2)
    @Rollback(value = false)
    public void getCustomerTest(){
        List<Customer> customerList = customerRepository.findAll();
        Assertions.assertTrue(customerList.size()>0);
    }
    //Following method tests updating customer
    @Test
    @Order(3)
    @Rollback(value = false)
    public void updateCustomerTest(){
        List<Customer> customers = customerRepository.findAll();
        Long id=1L;
        for(Customer customer:customers)
        {
            id = customer.getId();
        }
        Customer customer = customerRepository.findById(id).get();
        customer.setEmail("care@gmail.com");

        Customer updatedCustomer = customerRepository.save(customer);
        Assertions.assertTrue(updatedCustomer.getEmail().equals("care@gmail.com"));

    }
    //Following method tests deleting customer
    @Test
    @Order(4)
    @Rollback(value = false)
    public void deleteCustomerTest(){
        List<Customer> customers = customerRepository.findAll();
        Long id=1L;
        for(Customer customer:customers)
        {
            id = customer.getId();
        }
        Customer customer = customerRepository.findById(id).get();
        customerRepository.delete(customer);

        Optional<Customer> customer1 = customerRepository.findById(id);
        Customer checkCustomer = null;
        if(customer1.isPresent())
        {
            checkCustomer = customer1.get();
        }
        Assertions.assertNull(checkCustomer);

    }



}
