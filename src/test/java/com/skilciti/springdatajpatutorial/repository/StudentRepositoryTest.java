package com.skilciti.springdatajpatutorial.repository;

import com.skilciti.springdatajpatutorial.entity.Guardian;
import com.skilciti.springdatajpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // Not this
//@DataJpaTest //Use this, tests and cleans database
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Guardian guardian = Guardian.builder()
                .name("Francis Akilimali")
                .phone("0722291317")
                .email("francmape@gmail.com")
                .build();

        Student student = Student.builder()
                .firstName("Lisa")
                .lastName("Vidzo")
                .email("lisav@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(">>> ALL STUDENTS: " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> studentList = studentRepository.findByFirstName("Francis");
        System.out.println(">>> " + studentList.size() + " STUDENTS: " + studentList);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("ra");
        System.out.println(">>> " + studentList.size() + " STUDENTS: " + studentList);
    }

    @Test
    public void printStudentByLastNameNotNull() {
        List<Student> studentList = studentRepository.findByLastNameNotNull();
        System.out.println(">>> " + studentList.size() + " STUDENTS: " + studentList);
    }

    @Test
    public void printStudentByGuardianName() {
        List<Student> studentList = studentRepository.findByGuardianName("Francis Akilimali");
        System.out.println(">>> " + studentList.size() + " STUDENTS: " + studentList);
    }

    @Test
    public void getStudentByEmail() {
        Student student = studentRepository.getStudentByEmail("francmape@gmail.com");
        System.out.println(">>> STUDENT: " + student);
    }

    @Test
    public void getStudentFirstNameByEmail() {
        String firstName = studentRepository.getStudentFirstNameByEmail("francmape@gmail.com");
        System.out.println(">>> STUDENT: " + firstName);
    }

    @Test
    public void getStudentByEmailNative() {
        Student student = studentRepository.getStudentNameByEmailNativeNamed("francmape@gmail.com");
        System.out.println(">>> STUDENT: " + student);
    }

    @Test
    public void updateStudentFirstNameEmail() {
        studentRepository.updateStudentNameByEmail("Kunta", "francmape@gmail.com");

    }

}