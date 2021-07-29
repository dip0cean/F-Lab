package com.d0.spring_core.repository;

import com.d0.spring_core.entity.Pencil;

import java.time.LocalDateTime;

public class PencilRepository {
    public Pencil create(Pencil pencil) {
        pencil.setCreatedAt(LocalDateTime.now());
        return pencil;
    }
}
