package com.raisa.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raisa.orders.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    void deleteByPelangganId(Long pelangganId);
    
}