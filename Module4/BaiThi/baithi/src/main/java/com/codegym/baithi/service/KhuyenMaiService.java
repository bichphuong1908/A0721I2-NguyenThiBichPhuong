package com.codegym.baithi.service;

import com.codegym.baithi.model.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface KhuyenMaiService {
    List<KhuyenMai> findAll();
    void save(KhuyenMai khuyenMai);
    void delete(Long id);
    Optional<KhuyenMai> findById(Long id);
    Page<KhuyenMai> findAll(Pageable pageable);
    Page<KhuyenMai> findAllByMucGiamGiaContaining(String title, Pageable pageable);
}
