package me.bogeun.yajalal.port.incoming;

import me.bogeun.yajalal.domain.User;
import me.bogeun.yajalal.payload.user.UserCreateDto;
import me.bogeun.yajalal.payload.user.UserUpdateDto;

public interface UserServicePort {

    User createUser(UserCreateDto createDto);

    User getUserById(Long userId);

    User updateUser(UserUpdateDto updateDto, Long userId);

    void deleteUser(Long userId);

}
