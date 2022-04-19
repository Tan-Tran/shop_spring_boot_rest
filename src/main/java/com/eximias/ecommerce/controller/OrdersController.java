package com.eximias.ecommerce.controller;
import com.eximias.ecommerce.dto.OrdersDTO;
import com.eximias.ecommerce.service.OrdersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrdersController {
    private final OrdersService ordersService;

    @PostMapping(path = "/new")
    public int create(@RequestBody OrdersDTO ordersDTO){
       return ordersService.create(ordersDTO);
    }
}
