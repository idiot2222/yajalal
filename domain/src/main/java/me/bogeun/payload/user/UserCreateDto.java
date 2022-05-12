package me.bogeun.payload.user;

import me.bogeun.domain.Gender;

import java.time.LocalDateTime;

public class UserCreateDto {

    private String username;
    private String password;
    private String email;
    private LocalDateTime birthDate;

    private Gender gender;

}
