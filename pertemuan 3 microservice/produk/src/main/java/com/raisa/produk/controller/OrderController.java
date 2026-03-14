package com.raisa.produk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raisa.produk.model.Order;
import com.raisa.produk.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

        @Autowired
        private OrderService orderService;

        @GetMapping
        public ResponseEntity<?> getAllOrders() {
                return ResponseEntity.ok(orderService.getAllOrders());
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> getOrderById(@PathVariable Long id) {
               Order order = orderService.getOrderById(id);
               return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
      
        }

        @PostMapping
        public ResponseEntity<?> createOrder(@RequestBody Order order) {
                Order createdOrder = orderService.createOrder(order);
                return ResponseEntity.ok(createdOrder);
        }

        @DeleteMapping("/pelanggan/{pelangganId}")
        public String hapusBerdasarkanPelanggan(@PathVariable Long pelangganId) {
        orderService.hapusOrderByPelangganId(pelangganId);
        return "Semua order milik pelanggan dengan ID " + pelangganId + " berhasil dihapus!";
        }
}