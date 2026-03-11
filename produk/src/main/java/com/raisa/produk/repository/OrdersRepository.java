package com.raisa.produk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.raisa.produk.model.order; 

@Repository
public interface OrdersRepository extends JpaRepository<order, Long> {
    void deleteByPelangganId(Integer pelangganId);
}