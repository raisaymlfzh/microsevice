package com.uas.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uas.order_service.dto.PelangganDTO;

@FeignClient(name = "pelanggan-service")
public interface PelangganClient {
    @GetMapping("/api/pelanggan/{id}")
    PelangganDTO getPelangganById(@PathVariable("id") Long id);
}