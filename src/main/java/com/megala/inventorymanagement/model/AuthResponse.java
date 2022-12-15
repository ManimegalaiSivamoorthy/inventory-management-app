package com.megala.inventorymanagement.model;

import java.util.List;

public class AuthResponse {
    private String userId;
    private List<Role> validRoles;

    public AuthResponse() {
    }

    public AuthResponse(String userId, List<Role> validRoles) {
        this.userId = userId;
        this.validRoles = validRoles;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Role> getValidRoles() {
        return validRoles;
    }

    public void setValidRoles(List<Role> validRoles) {
        this.validRoles = validRoles;
    }
}
