package com.eximias.ecommerce.controller;

import com.eximias.ecommerce.dto.CustomerDTO;
import com.eximias.ecommerce.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getAll(){
        return customerService.getAllCustomer();
    }


}
