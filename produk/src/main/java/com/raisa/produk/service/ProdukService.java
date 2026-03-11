package com.raisa.produk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raisa.produk.repository.ProdukRepository;
import com.raisa.produk.model.produk;

@Service
public class ProdukService {
    @Autowired
    private ProdukRepository produkRepository;

    public List<produk> getAllProduks(){
        return produkRepository.findAll();
    }

    public produk getProdukById(Long id){
        return produkRepository.findById(id).orElse(null);
    }

    public produk createProduk( produk produk){
        return produkRepository.save(produk);
    }

    public void deleteProduk(Long id){
        produkRepository.deleteById(id);
    }

}
