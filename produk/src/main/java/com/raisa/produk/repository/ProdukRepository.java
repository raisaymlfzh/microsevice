package com.raisa.produk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.raisa.produk.model.produk;

@Repository
public interface ProdukRepository extends  JpaRepository<produk, Long>{

}