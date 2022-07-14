package me.bogeun.yajalal.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {

    private Long id;

    private String username;
    private String password;
    private String email;
    private LocalDate birthDate;

    private Gender gender;

    private Authority authority;

}
