package com.example.gccoffee.Service;

import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    public Product save(Product product);

    public Product cancel(Product product);

    public Product update(Product product, String name, Category category, String description);

    public Optional<Product> findById(UUID id);

    public String delete(UUID id);

    public List<Product> findByCategory(Category category);

    public Optional<Product> findByName(String productName);

}
