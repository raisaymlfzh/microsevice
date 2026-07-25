package com.uas.order_service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.uas.order_service.entity.Order;
import com.uas.order_service.repository.OrderRepository;
import com.uas.order_service.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public Order buatOrder(@RequestBody Order order) {
        return orderService.buatOrder(order);
    }

    @GetMapping
    public List<Order> ambilSemuaOrder() {
        return orderRepository.findAll();
    }
}