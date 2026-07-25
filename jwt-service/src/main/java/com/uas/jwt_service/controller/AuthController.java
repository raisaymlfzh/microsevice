package com.uas.jwt_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uas.jwt_service.dto.AuthRequest;
import com.uas.jwt_service.service.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        if ("admin".equals(authRequest.getUsername()) && "rahasia".equals(authRequest.getPassword())) {
            return jwtUtil.generateToken(authRequest.getUsername());
        } else {
            throw new RuntimeException("Akses Ditolak: Username atau Password salah!");
        }
    }
}