package com.raisa.produk.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raisa.produk.repository.OrderRepository;

import jakarta.transaction.Transactional;

import com.raisa.produk.model.Order;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(Order order) {
    order.hitungTotal();
    return orderRepository.save(order);
}

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

   @Transactional 
    public void hapusOrderByPelangganId(Long pelangganId) {
    orderRepository.deleteByPelangganId(pelangganId);
    }
}