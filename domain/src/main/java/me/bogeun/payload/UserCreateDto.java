package me.bogeun.payload;

import me.bogeun.domain.Gender;

import java.time.LocalDateTime;

public class UserCreateDto {

    private String username;
    private String password;
    private String email;
    private LocalDateTime birthDate;

    private Gender gender;

}
