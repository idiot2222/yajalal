package me.bogeun.yajalal.payload.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {

    private String password;
    private String email;

}
