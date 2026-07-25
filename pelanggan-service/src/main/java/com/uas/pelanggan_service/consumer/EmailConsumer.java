package com.uas.pelanggan_service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.uas.pelanggan_service.config.RabbitMQConfig;

@Service
public class EmailConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void consumeOrderMessage(String message) {
        try {
            System.out.println("Pesan diterima di Pelanggan Service: " + message);

            // Parsing pesan dari RabbitMQ
            // Formatnya sama dengan yang dikirim Producer: "produkId:jumlah"
            String[] parts = message.split(":");
            String produkId = parts[0];
            String jumlah = parts[1];

            // Logika pengiriman email atau notifikasi
            System.out.println("--- Proses Notifikasi Email ---");
            System.out.println("Mengirim email ke pelanggan untuk pembelian produk ID: " + produkId);
            System.out.println("Jumlah produk yang dibeli: " + jumlah);
            System.out.println("Status: Email notifikasi berhasil dikirim!");
            System.out.println("-------------------------------");

        } catch (Exception e) {
            System.err.println("Error saat memproses notifikasi email: " + e.getMessage());
        }
    }
}