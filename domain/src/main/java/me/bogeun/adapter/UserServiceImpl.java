package me.bogeun.adapter;

import lombok.RequiredArgsConstructor;
import me.bogeun.domain.User;
import me.bogeun.payload.UserCreateDto;
import me.bogeun.payload.UserUpdateDto;
import me.bogeun.port.incoming.UserServicePort;
import me.bogeun.port.outgoing.UserPersistencePort;

import java.util.List;

@RequiredArgsConstructor
public class UserServiceImpl implements UserServicePort {

    private final UserPersistencePort userPersistencePort;

    @Override
    public void createUser(UserCreateDto createDto) {
        userPersistencePort.joinNewUser(createDto);
    }

    @Override
    public User getUserById(Long userId) {
        return userPersistencePort.getUserById(userId);
    }

    @Override
    public List<User> getAllUserList() {
        return userPersistencePort.getAllUserList();
    }

    @Override
    public User updateUser(UserUpdateDto updateDto) {
        return userPersistencePort.updateUserInfo(updateDto);
    }

    @Override
    public void deleteUser(Long userId) {
        userPersistencePort.deleteUser(userId);
    }
}
