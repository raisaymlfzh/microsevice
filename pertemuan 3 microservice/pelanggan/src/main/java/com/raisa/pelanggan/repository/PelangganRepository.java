package com.raisa.pelanggan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.raisa.pelanggan.model.Pelanggan;

@Repository
public interface PelangganRepository extends  JpaRepository<Pelanggan, Long>{

}