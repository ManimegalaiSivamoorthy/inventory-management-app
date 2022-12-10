package com.megala.inventorymanagement.service;

import com.megala.inventorymanagement.exception.ResourceNotFound;
import com.megala.inventorymanagement.model.AuthRequest;
import com.megala.inventorymanagement.model.AuthResponse;
import com.megala.inventorymanagement.model.Item;
import com.megala.inventorymanagement.model.Role;
import com.megala.inventorymanagement.rest.AuthClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    AuthClient authClient;

    public boolean validateUser(String userId, List<Role> expectedRole) {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setUserId(userId);
        AuthResponse response = authClient.getAuthData(authRequest);
        for (Role role: expectedRole) {
            if (response.getValidRoles().contains(role))
                return true;
        }
        return false;
    }
}
