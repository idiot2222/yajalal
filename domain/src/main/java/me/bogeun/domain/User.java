package me.bogeun.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class User {

    private Long id;

    private String username;
    private String password;
    private String email;
    private LocalDateTime birthDate;

    private Gender gender;

}
