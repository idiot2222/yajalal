package me.bogeun.yajalal.service;

import lombok.RequiredArgsConstructor;
import me.bogeun.yajalal.domain.Authority;
import me.bogeun.yajalal.domain.User;
import me.bogeun.yajalal.payload.user.UserCreateDto;
import me.bogeun.yajalal.payload.user.UserUpdateDto;
import me.bogeun.yajalal.port.incoming.UserServicePort;
import me.bogeun.yajalal.validator.UserCreateValidator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserServicePort userServicePort;

    private final PasswordEncoder passwordEncoder;
    private final UserCreateValidator userCreateValidator;

    public void createUser(UserCreateDto createDto, Errors errors) {
        userCreateValidator.validate(createDto, errors);

        if(errors.hasErrors()) {
            return;
        }

        createDto.setPassword(passwordEncoder.encode(createDto.getPassword()));
        createDto.setAuthority(Authority.COMMON);

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
