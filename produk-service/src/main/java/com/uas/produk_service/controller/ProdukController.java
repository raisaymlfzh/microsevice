package com.uas.produk_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uas.produk_service.entity.Produk;
import com.uas.produk_service.repository.ProdukRepository;

@RestController
@RequestMapping("/api/produk")
public class ProdukController {

    @Autowired
    private ProdukRepository produkRepository;

    @PostMapping
    public Produk tambahProduk(@RequestBody Produk produk) {
        return produkRepository.save(produk);
    }

    @GetMapping
    public List<Produk> ambilSemuaProduk() {
        return produkRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produk ambilProdukBerdasarkanId(@PathVariable Long id) {
        return produkRepository.findById(id).orElseThrow(() -> new RuntimeException("Produk tidak ditemukan"));
    }
}