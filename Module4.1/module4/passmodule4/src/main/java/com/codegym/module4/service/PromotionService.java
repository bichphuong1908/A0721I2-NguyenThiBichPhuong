package com.codegym.module4.service;

import com.codegym.module4.model.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PromotionService {

    Optional<Promotion> findById(Long id);

    void save(Promotion promotion);

    void delete(Long id);

    Page<Promotion> findAll(Pageable pageable);

    Page<Promotion> findAllByDiscountContaining(String discount, Pageable pageable);
}
