package com.project.hm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hm.entity.FoodCategory;
@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {

	FoodCategory findByfoodCategoryType(FoodCategory foodCategory);
}
