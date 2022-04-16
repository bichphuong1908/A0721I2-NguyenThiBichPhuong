package com.codegym.baithi.service.ipml;

import com.codegym.baithi.model.KhuyenMai;
import com.codegym.baithi.repository.KhuyenMaiRepository;
import com.codegym.baithi.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhuyenMaiServiceIpml implements KhuyenMaiService {
    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;

    @Override
    public List<KhuyenMai> findAll() {
        return khuyenMaiRepository.findAll();
    }

    @Override
    public void save(KhuyenMai khuyenMai) {
        khuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public void delete(Long id) {
        khuyenMaiRepository.deleteById(id);
    }

    @Override
    public Optional<KhuyenMai> findById(Long id) {
        return khuyenMaiRepository.findById(id);
    }

    @Override
    public Page<KhuyenMai> findAll(Pageable pageable) {
        return khuyenMaiRepository.findAll(pageable);
    }

    @Override
    public Page<KhuyenMai> findAllByMucGiamGiaContaining(String mucGiamGia, Pageable pageable) {
        return khuyenMaiRepository.findAllByMucGiamGiaContaining(mucGiamGia, pageable);
    }
}
