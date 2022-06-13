package me.bogeun.adapter;

import lombok.RequiredArgsConstructor;
import me.bogeun.domain.User;
import me.bogeun.payload.user.UserCreateDto;
import me.bogeun.payload.user.UserUpdateDto;
import me.bogeun.port.incoming.UserServicePort;
import me.bogeun.port.outgoing.UserPersistencePort;

import java.util.List;

@RequiredArgsConstructor
public class UserServiceImpl implements UserServicePort {

    private final UserPersistencePort userPersistencePort;

    @Override
    public User createUser(UserCreateDto createDto) {
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
