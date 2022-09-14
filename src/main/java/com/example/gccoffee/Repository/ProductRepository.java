package com.example.gccoffee.Repository;

import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    /**
     * GC 커피숍 내 물건
     */
    public List<Product> findByCategory(Category category);

    public static final String FIND_BY_NAME_QUERY = "select p from PRODUCT p where p.PRODUCT_NAME = :productName";
//    @Query(FIND_BY_NAME_QUERY)
    public Optional<Product> findByProductName(String productName);

}
