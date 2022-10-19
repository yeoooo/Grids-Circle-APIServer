package com.example.gccoffee.Service;

import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    public UUID save(Product product);

    public Product cancel(Product product);

    public Product update(Product id,String name, long price, int quantity, String description);

    public Optional<Product> findById(UUID id);

    public String delete(UUID id);

    public List<Product> findByCategory(Category category);

    public Optional<Product> findByName(String productName);

    public List<Product> findAll();

    void truncateRepo();
    
}
