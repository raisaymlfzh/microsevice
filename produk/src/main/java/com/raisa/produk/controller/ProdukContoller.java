package com.raisa.produk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raisa.produk.model.produk;
import com.raisa.produk.service.ProdukService;


@RestController
@RequestMapping("/api/produk")
public class ProdukContoller {
    @Autowired
    private ProdukService produkService;

    @GetMapping
    public List<produk> getAllProduks(){
     return produkService.getAllProduks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<produk> getProdukById (@PathVariable Long id) {
        produk produk = produkService.getProdukById(id);
        return produk != null ? ResponseEntity.ok(produk) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<produk> createProduk(@RequestBody produk produk) {
    produk createdProduk = produkService.createProduk(produk);
    return ResponseEntity.ok(createdProduk);
}

    @DeleteMapping("//{id}")
    public ResponseEntity<Void> delateProduk(@PathVariable long id){
        produkService.deleteProduk(id);
        return ResponseEntity.noContent().build();
    }

    

}
