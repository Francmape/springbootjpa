package com.skilciti.springdatajpatutorial.repository;

import com.skilciti.springdatajpatutorial.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

public interface CourseRepository extends JpaRepository<Course, Long> {

    //CUSTOM METHODS
    Page<Course> findByTitleContaining(String title, Pageable pageable);
}
