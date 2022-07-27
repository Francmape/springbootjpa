package com.skilciti.springdatajpatutorial.repository;

import com.skilciti.springdatajpatutorial.entity.Course;
import com.skilciti.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseBBA111 = Course.builder().title("BBA111").credit(9).build();
        Course courseBBA112 = Course.builder().title("BBA112").credit(9).build();
        Course courseBBA113 = Course.builder().title("BBA113").credit(9).build();

        Teacher teacher = Teacher.builder()
                .firstName("Jamleck")
                .lastName("Kaitho")
//                .courses(List.of(courseBBA111,courseBBA112,courseBBA113))
                .build();

        teacherRepository.save(teacher);
    }


}