package me.bogeun.payload.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.bogeun.domain.Gender;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserCreateDto {

    private String username;
    private String password;
    private String email;
    private LocalDate birthDate;

    private Gender gender;

    @Builder
    public UserCreateDto(String username, String password, String email, LocalDate birthDate, Gender gender) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.gender = gender;
    }
}
