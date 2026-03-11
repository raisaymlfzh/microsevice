package com.raisa.produk.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.raisa.produk.model.order; 
import com.raisa.produk.service.OrdersService;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping
    public List<order> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<order> getOrdersById(@PathVariable Long id) {
        order order = ordersService.getOrdersById(id);
        return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public order createOrder(@RequestBody order order) {
        return ordersService.createOrders(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrders(@PathVariable Long id) {
        ordersService.deleteOrders(id);
        return ResponseEntity.ok().build();
    }
}