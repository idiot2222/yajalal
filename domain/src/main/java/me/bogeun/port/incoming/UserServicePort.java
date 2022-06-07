package me.bogeun.port.incoming;

import me.bogeun.domain.User;
import me.bogeun.payload.user.UserCreateDto;
import me.bogeun.payload.user.UserUpdateDto;

import java.util.List;

public interface UserServicePort {

    void createUser(UserCreateDto createDto);

    User getUserById(Long userId);

    User updateUser(UserUpdateDto updateDto);

    void deleteUser(Long userId);

}
