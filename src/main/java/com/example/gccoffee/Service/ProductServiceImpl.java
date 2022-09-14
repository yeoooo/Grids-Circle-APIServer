package com.example.gccoffee.Service;

import com.example.gccoffee.Repository.ProductRepository;
import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    public final ProductRepository productRepository;

    @Override
    public Optional<Product> findByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Product save(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public Product cancel(Product product) {
        return null;
    }

    @Override
    public Product update(Product product, String name, Category category, String description) {
        Product target = productRepository.findById(product.getProductId()).get();
        target.setProductName(name);
        target.setCategory(category);
        target.setDescription(description);


        return target;
    }

    @Override
    public Optional<Product> findById(UUID id) {
        Optional<Product> product =  productRepository.findById(id);
        if (product.isEmpty()) {
            throw new IllegalStateException("there's no such product");
        }else{
            return product;
        }
    }

    @Override
    public String delete(UUID id) {
        Optional<Product> target = findById(id);
        productRepository.delete(target.get());
        return target.get().toString();

    }

    @Override
    public List<Product> findByCategory(Category category) {
        List<Product> found = productRepository.findByCategory(category);
//        if (found.size() == 0) {
//            throw new IllegalStateException("there is no product with the category");
//        } else {
            return found;
//        }
    }

}
