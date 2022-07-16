package me.bogeun.yajalal.adapter;

import lombok.RequiredArgsConstructor;
import me.bogeun.yajalal.domain.Authority;
import me.bogeun.yajalal.domain.User;
import me.bogeun.yajalal.payload.user.UserCreateDto;
import me.bogeun.yajalal.payload.user.UserUpdateDto;
import me.bogeun.yajalal.port.incoming.UserServicePort;
import me.bogeun.yajalal.port.outgoing.UserPersistencePort;

@RequiredArgsConstructor
public class UserServicePortImpl implements UserServicePort {

    private final UserPersistencePort userPersistencePort;

    @Override
    public User createUser(UserCreateDto createDto) {
        createDto.setAuthority(Authority.COMMON);

        return userPersistencePort.joinNewUser(createDto);
    }

    @Override
    public User getUserById(Long userId) {
        return userPersistencePort.getUserById(userId);
    }

    @Override
    public User updateUser(UserUpdateDto updateDto, Long userId) {
        return userPersistencePort.updateUserInfo(updateDto, userId);
    }

    @Override
    public void deleteUser(Long userId) {
        userPersistencePort.deleteUser(userId);
    }
}
