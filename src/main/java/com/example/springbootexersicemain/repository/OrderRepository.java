package com.example.springbootexersicemain.repository;

import com.example.springbootexersicemain.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
