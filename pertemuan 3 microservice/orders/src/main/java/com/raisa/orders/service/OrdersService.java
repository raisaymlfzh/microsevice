package com.raisa.orders.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raisa.orders.repository.OrderRepository;

import jakarta.transaction.Transactional;

import com.raisa.orders.model.Orders;

@Service
public class OrdersService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders createOrder(Orders order) {
    order.hitungTotal();
    return orderRepository.save(order);
}

    public Orders getOrderById(Long id) {
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
