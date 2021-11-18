package com.cybertek.entity;

import com.cybertek.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name="studentFirstName")
    private String firstName;
    @Column(name="studentLastName")
    private String lastName;
    @Column(name="studentEmailAddress")
    private String email;

    @Transient
    private String city;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    @Column(columnDefinition = "DATE")
    private LocalDate localDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
