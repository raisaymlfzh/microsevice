package com.uas.pelanggan_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uas.pelanggan_service.entity.Pelanggan;
import com.uas.pelanggan_service.repository.PelangganRepository;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {

    @Autowired
    private PelangganRepository pelangganRepository;

    @PostMapping
    public Pelanggan tambahPelanggan(@RequestBody Pelanggan pelanggan) {
        return pelangganRepository.save(pelanggan);
    }

    @GetMapping
    public List<Pelanggan> ambilSemuaPelanggan() {
        return pelangganRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pelanggan ambilPelangganBerdasarkanId(@PathVariable Long id) {
        return pelangganRepository.findById(id).orElseThrow(() -> new RuntimeException("Pelanggan tidak ditemukan"));
    }
}