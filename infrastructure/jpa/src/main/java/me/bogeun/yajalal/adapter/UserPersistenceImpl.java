package me.bogeun.yajalal.adapter;

import lombok.RequiredArgsConstructor;
import me.bogeun.yajalal.domain.User;
import me.bogeun.yajalal.entity.UserEntity;
import me.bogeun.yajalal.mapper.UserMapper;
import me.bogeun.yajalal.payload.user.UserCreateDto;
import me.bogeun.yajalal.payload.user.UserUpdateDto;
import me.bogeun.yajalal.port.outgoing.UserPersistencePort;
import me.bogeun.yajalal.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceImpl implements UserPersistencePort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User joinNewUser(UserCreateDto createDto) {
        User user = userMapper.createDtoToUser(createDto);
        UserEntity entity = userMapper.userToEntity(user);

        userRepository.save(entity);

        return userMapper.entityToUser(entity);
    }

    @Override
    public User getUserById(Long userId) {
        UserEntity entity = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("invalid user id."));

        return userMapper.entityToUser(entity);
    }

    @Override
    public User updateUserInfo(UserUpdateDto updateDto, Long userId) {
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
