package com.codegym.baithi.repository;

import com.codegym.baithi.model.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai, Long> {
    Page<KhuyenMai> findAll(Pageable pageable);
    Page<KhuyenMai> findAllByMucGiamGiaContaining(String mucGiamGia, Pageable pageable);
}
