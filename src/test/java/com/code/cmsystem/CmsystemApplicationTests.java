package com.code.cmsystem;

import com.code.cmsystem.entities.Customer;
import com.code.cmsystem.repositories.CustomerRepository;
import com.code.cmsystem.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
class CmsystemApplicationTests {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    public void getCustomerTest(){
    }

    @Test
    void contextLoads() {
    }



}
