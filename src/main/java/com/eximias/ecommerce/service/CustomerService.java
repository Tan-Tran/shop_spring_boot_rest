package com.eximias.ecommerce.service;

import com.eximias.ecommerce.dto.CustomerDTO;
import com.eximias.ecommerce.entity.Customer;
import com.eximias.ecommerce.mapper.CustomerMapper;
import com.eximias.ecommerce.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    public Customer toEntity(Customer customer, CustomerDTO dto){
        customer.setName(dto.getName());
        customer.setAddress(dto.getAddress());
        customer.setDateOfBirth(dto.getDateOfBirth());
        return customer;
    }
    public List<CustomerDTO> toDto(List<Customer> customers){
        return customers.stream().map(customerMapper::toDto).collect(Collectors.toList());
    }
    public int create(CustomerDTO dto){
        return customerRepository.save(customerMapper.toEntity(dto)).getId();
    }
    public List<CustomerDTO> getAllCustomer(){
        return toDto(customerRepository.findAll());
    }
    public CustomerDTO findCustomerById(int id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isPresent()) {
            return customerMapper.toDto(customerOptional.get());
        }
        throw new RuntimeException("Not found this customer");
    }
    public boolean deleteById (int id){
        if(customerRepository.findById(id).isPresent()){
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public CustomerDTO update(int id, CustomerDTO dto){
        return customerRepository.findById(id)
            .map(entity -> toEntity(entity, dto))
            .map(customerRepository::save)
            .map(customerMapper::toDto)
            .get();
    }

}
