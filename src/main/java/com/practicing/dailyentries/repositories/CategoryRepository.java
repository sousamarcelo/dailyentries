package com.practicing.dailyentries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practicing.dailyentries.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
