package me.bogeun.port.outgoing;

import me.bogeun.domain.User;
import me.bogeun.payload.user.UserCreateDto;
import me.bogeun.payload.user.UserUpdateDto;

import java.util.List;

public interface UserPersistencePort {

    void joinNewUser(UserCreateDto createDto);

    User getUserById(Long userId);

    User updateUserInfo(UserUpdateDto updateDto);

    void deleteUser(Long userId);

}
