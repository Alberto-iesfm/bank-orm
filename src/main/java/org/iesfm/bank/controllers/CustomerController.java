package org.iesfm.bank.controllers;

import org.iesfm.bank.pojos.Customer;
import org.iesfm.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping (method = RequestMethod.GET, path = "/customers")
    public List<Customer> list(){
        return customerRepository.findAll();
    }

    @RequestMapping (method = RequestMethod.POST, path = "/customers")
    public void add(@RequestBody Customer customer){
        customerRepository.save(customer);
    }
}
