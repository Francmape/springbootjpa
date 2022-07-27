package com.skilciti.springdatajpatutorial.repository;

import com.skilciti.springdatajpatutorial.entity.Course;
import com.skilciti.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;


@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> list = courseRepository.findAll();
        System.out.println(">>>  COURSES: " + list);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Simon")
                .lastName("Gaitho")
                .build();

        Course course = Course.builder()
                .title("PYTHON101")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable pageable = PageRequest.of(1, 3);

        List<Course> courses = courseRepository.findAll(pageable).getContent();
        long totalElements = courseRepository.findAll(pageable).getTotalElements();
        long totalPages = courseRepository.findAll(pageable).getTotalPages();

        System.out.println(">>>  COURSES: " + courses);
        System.out.println(">>>  PAGES: " + totalPages);
        System.out.println(">>>  ELEMENTS: " + totalElements);
    }


    @Test
    public void findAllSorting() {

        Pageable pageableByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title"));
        Pageable pageableByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending());
        Pageable pageableByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title").descending()
                                .and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(pageableByTitleAndCreditDesc).getContent();
        System.out.println(">>>  COURSES: " + courses);

    }

    //CUSTOM METHOD
    @Test
    public void printFindByTitleContaining() {
        Pageable pageable = PageRequest.of(0, 10);
        List<Course> courses = courseRepository.findByTitleContaining(
                "B",
                pageable).getContent();

        System.out.println(">>>  COURSES: " + courses);

    }


}