package com.skilciti.springdatajpatutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(name = "course_sequence",sequenceName = "course_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="course_sequence" )
    private  Long id;
    private String title;
    private Integer credit;

    @OneToOne(mappedBy = "course") //OneToOne Bi directional mapping. Telling the relationship is already defined by course
    private CourseMaterial courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn( //ManyToOne UniDirectional
            name = "teacher_id",
            referencedColumnName = "id" // teacherId
    )
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "id" //courseId
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "id" //studentId
            )
    )
    private List<Student> students;
    public void addStudents(Student student){
        if(students == null ) students = new ArrayList<>();
        students.add(student);
    }
}
