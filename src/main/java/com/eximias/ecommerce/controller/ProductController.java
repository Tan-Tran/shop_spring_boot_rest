package com.eximias.ecommerce.controller;

import com.eximias.ecommerce.dto.ProductDTO;
import com.eximias.ecommerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getAll(){
        return productService.getAllProduct();
    }
}
