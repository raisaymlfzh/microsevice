package com.raisa.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raisa.orders.model.Orders;
import com.raisa.orders.service.OrdersService;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

        @Autowired
        private OrdersService ordersService;

        @GetMapping
        public ResponseEntity<?> getAllOrders() {
                return ResponseEntity.ok(ordersService.getAllOrders());
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> getOrderById(@PathVariable Long id) {
               Orders orders = ordersService.getOrderById(id);
               return orders != null ? ResponseEntity.ok(orders) : ResponseEntity.notFound().build();
      
        }

        @PostMapping
        public ResponseEntity<?> createOrder(@RequestBody Orders orders) {
                Orders createdOrder = ordersService.createOrder(orders);
                return ResponseEntity.ok(createdOrder);
        }

        @DeleteMapping("/pelanggan/{pelangganId}")
        public String hapusBerdasarkanPelanggan(@PathVariable Long pelangganId) {
        ordersService.hapusOrderByPelangganId(pelangganId);
        return "Semua orders milik pelanggan dengan ID " + pelangganId + " berhasil dihapus!";
        }
}