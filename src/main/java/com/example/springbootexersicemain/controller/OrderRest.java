package com.example.springbootexersicemain.controller;

import com.example.springbootexersicemain.model.dto.OrderDto;
import com.example.springbootexersicemain.service.facade.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderRest {

    private final OrderService orderService;

    @PostMapping(path = "/save")
    public ResponseEntity<Void> save(@RequestBody OrderDto.InsertOrderDto dto) {
        orderService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Void> cancellingProduct(@PathVariable Long orderId) {
        orderService.cancelProducts(orderId);
        return ResponseEntity.ok().build();
    }
}
