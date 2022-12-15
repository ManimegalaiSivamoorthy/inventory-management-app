package com.megala.inventorymanagement.rest;

import com.megala.inventorymanagement.model.AuthRequest;
import com.megala.inventorymanagement.model.AuthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8080/auth_management/v1", name = "AuthClient")
public interface AuthClient {
    @PostMapping("/validate")
    AuthResponse getAuthData(@RequestBody AuthRequest request);
}
