package me.bogeun.yajalal.port.outgoing;

import me.bogeun.yajalal.domain.User;
import me.bogeun.yajalal.payload.user.UserCreateDto;
import me.bogeun.yajalal.payload.user.UserUpdateDto;

public interface UserPersistencePort {

    User joinNewUser(UserCreateDto createDto);

    User getUserById(Long userId);

    User updateUserInfo(UserUpdateDto updateDto, Long userId);

    void deleteUser(Long userId);

}
