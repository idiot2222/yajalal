package me.bogeun.yajalal.entity;

import lombok.Getter;
import lombok.Setter;
import me.bogeun.yajalal.domain.Authority;
import me.bogeun.yajalal.domain.Gender;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 20)
    private String username;

    @Column(length = 68)
    private String password;

    @Column(length = 320)
    private String email;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Authority authority;

}
