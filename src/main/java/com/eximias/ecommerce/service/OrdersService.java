package com.eximias.ecommerce.service;

import com.eximias.ecommerce.dto.CustomerDTO;
import com.eximias.ecommerce.dto.OrdersDTO;
import com.eximias.ecommerce.entity.OrderItems;
import com.eximias.ecommerce.mapper.OrdersMapper;
import com.eximias.ecommerce.repository.OrdersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrdersService {
    private final OrdersMapper ordersMapper;
    private final OrdersRepository ordersRepository;

    private CustomerService customerService;
    private ProductService productService;

    public int create(OrdersDTO dto){
        CustomerDTO customerDTO = dto.getCustomerDTO();
        List<OrderItems> orderItemsList = dto.getOrderItemsList();
        for(OrderItems item: orderItemsList){
            System.out.println(item);
        }
        return 10000000;
    }
}
