package me.bogeun.adapter;

import lombok.RequiredArgsConstructor;
import me.bogeun.domain.User;
import me.bogeun.entity.UserEntity;
import me.bogeun.mapper.UserMapper;
import me.bogeun.payload.user.UserCreateDto;
import me.bogeun.payload.user.UserUpdateDto;
import me.bogeun.port.outgoing.UserPersistencePort;
import me.bogeun.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceImpl implements UserPersistencePort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void joinNewUser(UserCreateDto createDto) {
        User user = userMapper.createDtoToUser(createDto);

        UserEntity entity = userMapper.userToEntity(user);

        userRepository.save(entity);
    }

    @Override
    public User getUserById(Long userId) {
        UserEntity entity = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("invalid user id."));

        return userMapper.entityToUser(entity);
    }

    @Override
    public User updateUserInfo(UserUpdateDto updateDto) {
        UserEntity userEntity = userMapper.updateDtoToEntity(updateDto);
        userRepository.save(userEntity);

        return userMapper.entityToUser(userEntity);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = getUserById(userId);
        UserEntity entity = userMapper.userToEntity(user);

        userRepository.delete(entity);
    }
}
