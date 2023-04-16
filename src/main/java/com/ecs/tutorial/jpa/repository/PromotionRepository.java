package com.ecs.tutorial.jpa.repository;

import com.ecs.tutorial.jpa.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {


}