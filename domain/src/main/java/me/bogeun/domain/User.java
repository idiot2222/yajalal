package me.bogeun.domain;

import me.bogeun.payload.user.UserUpdateDto;

import java.time.LocalDateTime;

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
