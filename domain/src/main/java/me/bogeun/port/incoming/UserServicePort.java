package me.bogeun.port.incoming;

import me.bogeun.domain.User;
import me.bogeun.payload.UserCreateDto;
import me.bogeun.payload.UserUpdateDto;

import java.util.List;

public interface UserServicePort {

    void createUser(UserCreateDto createDto);

    User getUserById(Long userId);

    List<User> getAllUserList();

    User updateUser(UserUpdateDto updateDto);

    void deleteUser(Long userId);

}
