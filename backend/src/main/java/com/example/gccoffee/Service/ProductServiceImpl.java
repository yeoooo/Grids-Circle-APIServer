package com.example.gccoffee.Service;

import com.example.gccoffee.Exception.NoSuchProductException;
import com.example.gccoffee.Exception.ProductOnBoardException;
import com.example.gccoffee.Repository.ProductRepository;
import com.example.gccoffee.model.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    public final ProductRepository productRepository;
    public final OrderService orderService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Optional<Product> findByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }


    @Override
    @Transactional
    public UUID save(Product product) {
        log.info("Product saved with \n ID => {} \n Name => {} \n Category => {} \n price => {} \n quantity => {}",
                product.getProductId(), product.getProductName(), product.getCategory(), product.getPrice(), product.getQuantity());
        productRepository.save(product);
        return product.getProductId();
    }

    @Override
    @Transactional
    public Product cancel(Product product) {
        return null;
    }

    @Override
    @Transactional
    public Product update(Product target, String name, long price, int quantity, String description) {
        return productRepository.save(
                target.builder()
                .dto(ProductDTO.builder()
                                .id(target.getProductId())
                                .name(name)
                                .price(price)
                                .quantity(quantity)
                                .category(target.getCategory())
                                .description(description)
                                .build()
                ).build());

    }

    @Override
    public Optional<Product> findById(UUID id) {
        Optional<Product> product =  productRepository.findById(id);
        return product;

    }

    @Override
    @Transactional
    public String delete(UUID id) {
        Optional<Product> target = productRepository.findById(id);
        if (target.isEmpty()) {
            throw new NoSuchProductException("상품이 존재하지 않습니다.");
        }else {
            for (List<OrderItem> o: orderService.findAll().stream().map(Order::getOrderItems).collect(Collectors.toList())) {
                //2022-10-14_yeoooo : Order에서 처리되지 않은 product가 존재하는지 전수 조사
                if (o.stream().map(OrderItem::getProduct).collect(Collectors.toList()).stream().map(Product::getProductId).collect(Collectors.toList()).contains(id)){
                    throw new ProductOnBoardException("처리되지 않은 주문이 존재합니다.");
                }
            }
            productRepository.delete(target.get());
            log.info("[ProductService] product delete id : {}", id);
        }
        return target.get().toString();

    }

    @Override
    public List<Product> findByCategory(Category category) {

        List<Product> found = productRepository.findByCategory(category);
        return found;
    }


}
