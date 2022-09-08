package com.example.gccoffee.Service;

import com.example.gccoffee.model.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    public Product save(Product product);

    public Product cancel(Product product);

    public Product update(Product product);

    public Optional<Product> findById(UUID id);

}
