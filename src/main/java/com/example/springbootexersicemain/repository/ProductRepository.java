package com.example.springbootexersicemain.repository;

import com.example.springbootexersicemain.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p FROM Product p JOIN FETCH p.orders o WHERE o.id = :orderId")
    List<Product> findProductsByOrderId(@Param("orderId") Long orderId);
}
