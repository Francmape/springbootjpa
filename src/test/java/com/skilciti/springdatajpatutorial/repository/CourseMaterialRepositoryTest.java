package com.skilciti.springdatajpatutorial.repository;

import com.skilciti.springdatajpatutorial.entity.Course;
import com.skilciti.springdatajpatutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .title("Sprint101")
                .credit(7)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.skilciti.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> list = courseMaterialRepository.findAll();

        System.out.println(">>>  COURSE MATERIALS: " + list);

    }


}