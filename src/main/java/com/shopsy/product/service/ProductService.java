package com.shopsy.product.service;

import com.shopsy.product.dto.ProductRequest;
import com.shopsy.product.entity.Product;
import com.shopsy.product.repository.ProductRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    public Product create(ProductRequest request) {
        Product product = new Product();
        map(request, product);
        return repository.save(product);
    }

    public Product update(UUID id, ProductRequest request) {
        Product product = getById(id);
        map(request, product);
        return repository.save(product);
    }

    private void map(ProductRequest request, Product product) {
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setCategory(request.getCategory());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setImageUrl(request.getImageUrl());
    }
}
