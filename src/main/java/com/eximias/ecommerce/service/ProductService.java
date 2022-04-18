package com.eximias.ecommerce.service;

import com.eximias.ecommerce.dto.ProductDTO;
import com.eximias.ecommerce.entity.Product;
import com.eximias.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public Product toEntity(ProductDTO productDTO){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setOrigin(productDTO.getOrigin());
        return product;
    }
    public Product toEntity(Product product, ProductDTO productDTO){
        product.setQuantity(productDTO.getQuantity());
        product.setOrigin(productDTO.getOrigin());
        product.setDescription(productDTO.getDescription());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        return product;
    }
    public ProductDTO toDto(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setOrigin(product.getOrigin());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setDescription(product.getDescription());
        return productDTO;
    }
    public List<ProductDTO> toDto(List<Product> products){
        return products.stream().map(this::toDto).collect(Collectors.toList());
    }

    public int create(ProductDTO productDTO) {
        return productRepository.save(toEntity(productDTO)).getId();
    }
    public Optional<Product> findProductById(int id){
        return Optional.of(productRepository.findById(id))
                .orElseThrow(() -> new RuntimeException("Not found this product"));
    }

    public boolean delete(int id){
        if(productRepository.findById(id).isPresent()){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<ProductDTO> getAllProduct(){
        return toDto(productRepository.findAll());
    }

    public ProductDTO update(int id, ProductDTO productDTO){
        return findProductById(id)
                .map(entity -> toEntity(entity, productDTO))
                .map(productRepository:: save)
                .map(this::toDto)
                .get();
    }

}
