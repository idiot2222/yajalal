package me.bogeun.yajalal.service;

import lombok.RequiredArgsConstructor;
import me.bogeun.yajalal.domain.User;
import me.bogeun.yajalal.payload.user.UserCreateDto;
import me.bogeun.yajalal.payload.user.UserUpdateDto;
import me.bogeun.yajalal.port.incoming.UserServicePort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserServicePort userServicePort;
    private final PasswordEncoder passwordEncoder;

    public void createUser(UserCreateDto createDto) {
        createDto.setPassword(passwordEncoder.encode(createDto.getPassword()));

        userServicePort.createUser(createDto);
    }

    public User getUserById(Long userId) {
        return userServicePort.getUserById(userId);
    }

    public User updateUser(UserUpdateDto updateDto, Long userId) {
        updateDto.setPassword(passwordEncoder.encode(updateDto.getPassword()));

        return userServicePort.updateUser(updateDto, userId);
    }

    public void deleteUser(Long userId) {
        userServicePort.deleteUser(userId);
    }

}
