package com.uas.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uas.order_service.dto.ProdukDTO;

@FeignClient(name = "produk-service") 
public interface ProdukClient {
    @GetMapping("/api/produk/{id}")
    ProdukDTO getProdukById(@PathVariable("id") Long id);
}