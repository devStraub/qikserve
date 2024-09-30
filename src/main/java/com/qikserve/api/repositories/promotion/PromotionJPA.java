package com.qikserve.api.repositories.promotion;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qikserve.api.model.entities.Promotion;

public interface PromotionJPA extends JpaRepository<Promotion, Long> {

}
