package me.bogeun.payload.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {

    private Long id;

    private String password;
    private String email;

}
