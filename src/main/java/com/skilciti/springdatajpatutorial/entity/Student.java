package com.skilciti.springdatajpatutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data // Generates Getter/Setters/toString/hashCode etc
@AllArgsConstructor
@NoArgsConstructor
@Builder // Adds builder pattern for entity
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique",
                columnNames = "email_address"
        )
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_address", nullable = false)
    private String email;
    @Embedded
    private Guardian guardian;

}
