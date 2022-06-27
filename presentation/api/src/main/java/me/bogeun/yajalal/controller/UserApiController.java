package me.bogeun.yajalal.controller;

import lombok.RequiredArgsConstructor;
import me.bogeun.yajalal.domain.User;
import me.bogeun.yajalal.payload.user.UserCreateDto;
import me.bogeun.yajalal.payload.user.UserUpdateDto;
import me.bogeun.yajalal.port.incoming.UserServicePort;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserServicePort userServicePort;

    @PostMapping("/join")
    public String userJoin(@RequestBody UserCreateDto createDto) {
        userServicePort.createUser(createDto);

        return "ok";
    }

    @GetMapping("/info/{userId}")
    public User userInfo(@PathVariable Long userId) {
        return userServicePort.getUserById(userId);
    }

    @PostMapping("/update/{userId}")
    public User updateUserInfo(@PathVariable Long userId, UserUpdateDto updateDto) {
        return userServicePort.updateUser(updateDto, userId);
    }

    @PostMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        try {
            userServicePort.deleteUser(userId);
        } catch (IllegalArgumentException e) {
            return "error";
        }

        return "ok";
    }
}
