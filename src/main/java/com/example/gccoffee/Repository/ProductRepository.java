package com.example.gccoffee.Repository;

import com.example.gccoffee.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    /**
     * GC 커피숍 내 물건
     */

}
