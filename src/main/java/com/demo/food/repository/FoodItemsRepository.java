package com.demo.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.food.entity.FoodItems;

public interface FoodItemsRepository extends JpaRepository<FoodItems, Long> {


	@Query("SELECT f FROM FoodItems f WHERE f.itemName LIKE %:itemName%")
	List<FoodItems> searchByItemNameLike(@Param("itemName") String ItemName);
	
}
