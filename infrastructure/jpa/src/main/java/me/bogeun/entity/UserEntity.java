package me.bogeun.entity;

import me.bogeun.domain.Gender;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 20)
    private String username;

    @Column(length = 60)
    private String password;

    @Column(length = 30)
    private String email;

    private LocalDateTime birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
