package com.raisa.produk.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raisa.produk.repository.OrdersRepository;
import com.raisa.produk.model.order; 

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    public List<order> getAllOrders() {
        return ordersRepository.findAll();
    }

    public order getOrdersById(Long id) {
        return ordersRepository.findById(id).orElse(null);
    }

    public order createOrders(order order) {
        return ordersRepository.save(order);
    }

    public void deleteOrders(Long id) {
        ordersRepository.deleteById(id);
    }
}