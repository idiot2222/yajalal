package me.bogeun.payload.user;

import lombok.Getter;
import lombok.Setter;
import me.bogeun.domain.Gender;

import java.time.LocalDate;

@Getter
@Setter
public class UserCreateDto {

    private String username;
    private String password;
    private String email;
    private LocalDate birthDate;

    private Gender gender;

}
