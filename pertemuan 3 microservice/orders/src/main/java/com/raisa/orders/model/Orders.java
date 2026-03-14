package com.raisa.orders.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer pelangganId;
    private Integer produkId;
    private int jumlah;
    private double totalHarga;
    
    private double hargaSatuan;

    public void hitungTotal() {
        if (this.hargaSatuan != 0 && this.jumlah != 0) {
            this.totalHarga = this.jumlah * this.hargaSatuan;
        }
    }


}