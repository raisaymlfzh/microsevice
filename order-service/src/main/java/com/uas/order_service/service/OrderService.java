package com.uas.order_service.service;

import com.uas.order_service.client.PelangganClient;
import com.uas.order_service.client.ProdukClient;
import com.uas.order_service.dto.PelangganDTO;
import com.uas.order_service.dto.ProdukDTO;
import com.uas.order_service.entity.Order;
import com.uas.order_service.publisher.OrderProducer;
import com.uas.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProdukClient produkClient;

    @Autowired
    private PelangganClient pelangganClient;

    @Autowired
    private OrderProducer orderProducer;

    public Order buatOrder(Order order) {
        // 1. Ambil data pendukung
        ProdukDTO produk = produkClient.getProdukById(order.getProdukId());
        PelangganDTO pelanggan = pelangganClient.getPelangganById(order.getPelangganId());
        
        // 2. Hitung total harga
        order.setTotalHarga(produk.getHarga() * order.getJumlah());
        
        // 3. Simpan order ke database
        Order savedOrder = orderRepository.save(order);
        
        // 4. Kirim notifikasi ke RabbitMQ dengan parameter (produkId, jumlah)
        // Perhatikan baris ini yang sudah hamba perbaiki:
        orderProducer.sendOrderMessage(savedOrder.getProdukId(), savedOrder.getJumlah());
        
        return savedOrder;
    }
}