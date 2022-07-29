package me.bogeun.yajalal.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import me.bogeun.yajalal.domain.User;
import me.bogeun.yajalal.payload.user.UserCreateDto;
import me.bogeun.yajalal.payload.user.UserUpdateDto;
import me.bogeun.yajalal.service.UserService;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserService userService;

    private final ObjectMapper objectMapper;

    @PostMapping("/join")
    public String userJoin(@RequestBody UserCreateDto createDto, Errors errors) throws JsonProcessingException {
        userService.createUser(createDto, errors);

        if(errors.hasErrors()) {
            return objectMapper.writeValueAsString(errors.getAllErrors());
        }

        return "ok";
    }

    @GetMapping("/info/{userId}")
    public User userInfo(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/update/{userId}")
    public User updateUserInfo(@PathVariable Long userId, UserUpdateDto updateDto) {
        return userService.updateUser(updateDto, userId);
    }

    @PostMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        try {
            userService.deleteUser(userId);
        } catch (IllegalArgumentException e) {
            return "error";
        }

        return "ok";
    }

}
