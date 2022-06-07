package me.bogeun.domain;

import lombok.Getter;
import lombok.Setter;
import me.bogeun.payload.user.UserUpdateDto;

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



    public void updateInfo(UserUpdateDto updateDto) {
        String email = updateDto.getEmail();
        String password = updateDto.getPassword();

        if(email != null) {
            this.email = email;
        }
        if(password != null) {
            this.password = password;
        }
    }
}
