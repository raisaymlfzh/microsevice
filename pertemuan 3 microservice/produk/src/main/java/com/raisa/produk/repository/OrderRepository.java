package com.raisa.produk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.raisa.produk.model.Order; 

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    void deleteByPelangganId(Long pelangganId);
    
}