package com.raisa.produk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.raisa.produk.model.Pelanggan;

@Repository
public interface PelangganRepository extends  JpaRepository<Pelanggan, Long>{

}