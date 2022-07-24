package com.skilciti.springdatajpatutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // Adds builder pattern for entity
@AttributeOverrides({ // When you want to override an existing column with a new one
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name = "phone",
                column = @Column(name = "guardian_phone")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email")
        )
})

public class Guardian {
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
}
