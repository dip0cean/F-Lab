package com.d0.spring_core.service;

import com.d0.spring_core.entity.Pencil;
import com.d0.spring_core.repository.PencilRepository;

public class PencilService {
    // XML 파일로 의존성 주입하기
    private PencilRepository pencilRepository;

    public void setPencilRepository(PencilRepository pencilRepository) {
        this.pencilRepository = pencilRepository;
    }

    public Pencil create(Pencil pencil) {
        pencilRepository.create(pencil);
        System.out.println("제조자 : " + pencil.getVendor());
        System.out.println("제조일자 : " + pencil.getCreatedAt());
        return pencil;
    }
}
