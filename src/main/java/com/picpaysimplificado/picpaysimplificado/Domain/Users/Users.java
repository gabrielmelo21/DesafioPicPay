package com.picpaysimplificado.picpaysimplificado.Domain.Users;

import jakarta.persistence.*;

import lombok.Data;


import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "users")
@Data
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "firstName", length = 40, nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 40, nullable = false)
    private String lastName;

    @Column(name = "cpf", length = 15, nullable = false, unique = true)
    private String cpf;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "userType")
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
