package com.codegym.module4.repository;

import com.codegym.module4.model.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    Page<Promotion> findAll(Pageable pageable);
    Page<Promotion> findAllByDiscountContaining(String discount, Pageable pageable);
}
