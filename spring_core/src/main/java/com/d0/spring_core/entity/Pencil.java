package com.d0.spring_core.entity;

import java.time.LocalDateTime;

public class Pencil {
    private String        vendor;
    private LocalDateTime createdAt;

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
