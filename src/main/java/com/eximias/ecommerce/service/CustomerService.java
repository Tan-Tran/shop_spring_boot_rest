package com.eximias.ecommerce.service;

import com.eximias.ecommerce.dto.CustomerDTO;
import com.eximias.ecommerce.entity.Customer;
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
    public Customer toEntity(CustomerDTO dto){
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setAddress(dto.getAddress());
        customer.setDateOfBirth(dto.getDateOfBirth());
        return customer;
    }

    public Customer toEntity(Customer customer, CustomerDTO dto){
        customer.setName(dto.getName());
        customer.setAddress(dto.getAddress());
        customer.setDateOfBirth(dto.getDateOfBirth());
        return customer;
    }
    public CustomerDTO toDto(Customer customer){
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setAddress(customer.getAddress());
        dto.setDateOfBirth(customer.getDateOfBirth());
        return dto;
    }
    public List<CustomerDTO> toDto(List<Customer> customers){
        return customers.stream().map(this::toDto).collect(Collectors.toList());
    }

    public int create(CustomerDTO dto){
        return customerRepository.save(toEntity(dto)).getId();
    }

    public List<CustomerDTO> getAllCustomer(){
        return toDto(customerRepository.findAll());
    }
    public Optional<Customer> findCustomerById(int id) {
        return Optional.of(customerRepository.findById(id)).
                orElseThrow(() -> new RuntimeException("Not found this customer"));
    }

    public boolean deleteById (int id){
        if(customerRepository.findById(id).isPresent()){
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public CustomerDTO update(int id, CustomerDTO dto){
        return findCustomerById(id)
                .map(entity -> toEntity(entity, dto))
                .map(customerRepository::save)
                .map(this::toDto)
                .get();
    }

}
