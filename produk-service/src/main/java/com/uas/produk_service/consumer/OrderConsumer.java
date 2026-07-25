package com.uas.produk_service.consumer;

import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uas.produk_service.config.RabbitMQConfig;
import com.uas.produk_service.entity.Produk;
import com.uas.produk_service.repository.ProdukRepository;

@Service
public class OrderConsumer {

    @Autowired
    private ProdukRepository produkRepository;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void consumeOrderMessage(String message) {
        try {
            System.out.println("Pesan diterima dari RabbitMQ: " + message);
            
            String[] parts = message.split(":");
            Long produkId = Long.parseLong(parts[0]);
            int jumlah = Integer.parseInt(parts[1]);

            Optional<Produk> produkOptional = produkRepository.findById(produkId);

            if (produkOptional.isPresent()) {
                Produk produk = produkOptional.get();
                
                int stokBaru = produk.getStok() - jumlah;
                
                if (stokBaru >= 0) {
                    produk.setStok(stokBaru);
                    produkRepository.save(produk);
                    System.out.println("Stok produk ID " + produkId + " berhasil dikurangi menjadi: " + stokBaru);
                } else {
                    System.out.println("Gagal: Stok produk ID " + produkId + " tidak mencukupi!");
                }
            } else {
                System.out.println("Gagal: Produk dengan ID " + produkId + " tidak ditemukan.");
            }
            
        } catch (Exception e) {
            System.err.println("Error saat memproses pesan RabbitMQ: " + e.getMessage());
        }
    }
}