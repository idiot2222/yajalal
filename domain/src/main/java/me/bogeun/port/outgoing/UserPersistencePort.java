package me.bogeun.port.outgoing;

import me.bogeun.domain.User;
import me.bogeun.payload.user.UserCreateDto;
import me.bogeun.payload.user.UserUpdateDto;

import java.util.List;

public interface UserPersistencePort {

    User joinNewUser(UserCreateDto createDto);

    User getUserById(Long userId);

    User updateUserInfo(UserUpdateDto updateDto, Long userId);

    void deleteUser(Long userId);

}
