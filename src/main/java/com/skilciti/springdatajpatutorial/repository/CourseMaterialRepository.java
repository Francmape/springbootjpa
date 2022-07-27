package com.skilciti.springdatajpatutorial.repository;

import com.skilciti.springdatajpatutorial.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
