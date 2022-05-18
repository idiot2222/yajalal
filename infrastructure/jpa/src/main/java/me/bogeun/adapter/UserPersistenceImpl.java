package me.bogeun.adapter;

import lombok.RequiredArgsConstructor;
import me.bogeun.domain.User;
import me.bogeun.mapper.UserMapper;
import me.bogeun.payload.user.UserCreateDto;
import me.bogeun.payload.user.UserUpdateDto;
import me.bogeun.port.outgoing.UserPersistencePort;
import me.bogeun.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
public class UserPersistenceImpl implements UserPersistencePort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void joinNewUser(UserCreateDto createDto) {
        User user = userMapper.createDtoToUser(createDto);

        userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("invalid user id."));
    }

    @Override
    public List<User> getAllUserList() {
        return userRepository.findAll();
    }

    @Override
    public User updateUserInfo(UserUpdateDto updateDto) {
        User user = getUserById(updateDto.getId());

        user.updateInfo(updateDto);
        userRepository.save(user);

        return user;
    }

    @Override
    public void deleteUser(Long userId) {
        User user = getUserById(userId);

        userRepository.delete(user);
    }
}
