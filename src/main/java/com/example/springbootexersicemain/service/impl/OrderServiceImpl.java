package com.example.springbootexersicemain.service.impl;

import com.example.springbootexersicemain.model.dto.OrderDto;
import com.example.springbootexersicemain.model.entity.Order;
import com.example.springbootexersicemain.model.entity.Product;
import com.example.springbootexersicemain.model.enums.ProductState;
import com.example.springbootexersicemain.repository.OrderRepository;
import com.example.springbootexersicemain.repository.ProductRepository;
import com.example.springbootexersicemain.service.facade.OrderService;
import com.example.springbootexersicemain.service.facade.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final ProductRepository productRepository;

    @Override
    public void save(OrderDto.InsertOrderDto orderDto) {
        List<Product> productEntityList =
                productService.findProductByProductId(orderDto.getProductId());

        Order entity = new Order()
                .setName(orderDto.getName())
                .setProducts(productEntityList);

        orderRepository.save(entity);
    }

    @Override
    public void cancelProducts(Long orderId) {
        List<Product> productListRelatedToOrderId = productService.findProduct(orderId);

        for (Product product : productListRelatedToOrderId) {
            product.setProductState(ProductState.CANCEL);
            productRepository.save(product);
        }
    }
}