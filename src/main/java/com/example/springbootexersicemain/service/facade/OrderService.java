package com.example.springbootexersicemain.service.facade;

import com.example.springbootexersicemain.model.dto.OrderDto;

public interface OrderService {
    void save(OrderDto.InsertOrderDto orderDto);
    void cancelProducts(Long orderId);
}
