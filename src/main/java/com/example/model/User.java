package com.example.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "pass_word")
    private String passWord;
    @Column(name = "details")
    private String details;
    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;
    @Column(name = "gender")
    private boolean gender;
    @Column(name = "country")
    private String country;
    @Column(name = "smoking")
    private boolean smoking;

    public User(String firstName, String lastName, String passWord, String details, LocalDate birthDay, boolean gender,
            String country, boolean smoking) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passWord = passWord;
        this.details = details;
        this.birthDay = birthDay;
        this.gender = gender;
        this.country = country;
        this.smoking = smoking;
    }

}
