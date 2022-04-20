package com.eximias.ecommerce.service;

import com.eximias.ecommerce.dto.CustomerDTO;
import com.eximias.ecommerce.dto.OrdersDTO;
import com.eximias.ecommerce.entity.OrderItems;
import com.eximias.ecommerce.entity.Orders;
import com.eximias.ecommerce.mapper.OrdersMapper;
import com.eximias.ecommerce.repository.OrdersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrdersService {
    private final OrdersMapper ordersMapper;
    private final OrdersRepository ordersRepository;

    private CustomerService customerService;
    private ProductService productService;

    public int create(OrdersDTO dto){
        Orders orders = ordersMapper.toEntity(dto);
        return ordersRepository.save(orders).getId();
    }

    public List<OrdersDTO> toDto(List<Orders> ordersList){
        return ordersList.stream().map(ordersMapper::toDTO).collect(Collectors.toList());
    }

    public List<OrdersDTO> getAllOrders(){
        return toDto(ordersRepository.findAll());
    }
}
