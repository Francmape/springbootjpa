package com.skilciti.springdatajpatutorial.repository;

import com.skilciti.springdatajpatutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String name);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String name);

    //JPQL Query is based on the class not in db tables
    @Query("Select s from Student s where s.email = ?1")
    Student getStudentByEmail(String email);

    //JPQL
    @Query("Select s.firstName from Student s where s.email = ?1")
    String getStudentFirstNameByEmail(String email);

    //NATIVE
    @Query(value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1",nativeQuery = true)
    Student getStudentNameByEmailNative(String email);

    //NATIVE NAMED PARAM
    @Query(value = "SELECT * FROM tbl_student s WHERE s.email_address = :emailId",nativeQuery = true)
    Student getStudentNameByEmailNativeNamed(@Param("emailId") String email);

    //UPDATING
    @Modifying
    @Transactional
    @Query(value = "UPDATE tbl_student SET first_name = ?1 WHERE email_address = ?2",nativeQuery = true)
    int updateStudentNameByEmail(String firstName, String email);
}
