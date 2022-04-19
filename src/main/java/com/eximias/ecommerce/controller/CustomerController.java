package com.eximias.ecommerce.controller;

import com.eximias.ecommerce.dto.CustomerDTO;
import com.eximias.ecommerce.entity.Customer;
import com.eximias.ecommerce.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getAll(){
        return customerService.getAllCustomer();
    }

    @GetMapping(path="/{id}")
    public CustomerDTO findById(@PathVariable(name = "id") int id){
        System.out.println(customerService.findCustomerById(id));
        return customerService.findCustomerById(id);
    }

}
