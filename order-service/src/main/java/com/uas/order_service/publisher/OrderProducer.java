package com.uas.order_service.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uas.order_service.config.RabbitMQConfig;

@Service
public class OrderProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrderMessage(Long produkId, int jumlah) {
        // Format pesan
        String message = produkId + ":" + jumlah;
        
        try {
            // Kita coba kirim pesan
            rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, message);
            
            // Log ini akan muncul di terminal jika pengiriman SUKSES
            System.out.println(">>> [SUCCESS] Pesan berhasil masuk ke antrean " + RabbitMQConfig.QUEUE_NAME + ": " + message);
        } catch (Exception e) {
            // Log ini akan muncul jika ada masalah koneksi RabbitMQ
            System.err.println(">>> [ERROR] Gagal mengirim ke RabbitMQ! Pastikan koneksi aman. Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}