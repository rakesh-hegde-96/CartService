package com.demo.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.food.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    
}
