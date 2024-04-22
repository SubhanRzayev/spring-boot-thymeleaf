package com.subhan.springbootthymeleaf.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "customer")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = false,name = "first_name")
    private String firstname;

    @Column(unique = false, name = "last_name")
    private String lastname;

    @Column(unique = true, name = "email")
    private String email;
}
