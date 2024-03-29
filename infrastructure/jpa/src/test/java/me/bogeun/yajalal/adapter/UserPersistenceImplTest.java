package me.bogeun.yajalal.adapter;

import me.bogeun.yajalal.TestConfig;
import me.bogeun.yajalal.domain.Gender;
import me.bogeun.yajalal.domain.User;
import me.bogeun.yajalal.mapper.UserMapper;
import me.bogeun.yajalal.payload.user.UserCreateDto;
import me.bogeun.yajalal.payload.user.UserUpdateDto;
import me.bogeun.yajalal.port.outgoing.UserPersistencePort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@Import(TestConfig.class)
class UserPersistenceImplTest {

    @Autowired
    UserPersistencePort userPersistencePort;

    @Autowired
    UserMapper userMapper;

    @Test
    @DisplayName("joinNewUser(), getUserById()")
    void joinNewUser() {
        UserCreateDto createDto = new UserCreateDto();
        createDto.setUsername("test");
        createDto.setPassword("password");
        createDto.setBirthDate(LocalDate.of(2000, 10, 10));
        createDto.setEmail("test@email.com");
        createDto.setGender(Gender.MALE);

        Long userId = userPersistencePort.joinNewUser(createDto).getId();
        User user = userPersistencePort.getUserById(userId);

        assertEquals(createDto.getUsername(), user.getUsername());
        assertEquals(createDto.getPassword(), user.getPassword());
        assertEquals(createDto.getBirthDate(), user.getBirthDate());
        assertEquals(createDto.getEmail(), user.getEmail());
        assertEquals(createDto.getGender(), user.getGender());
    }

    @Test
    void updateUserInfo() {
        UserCreateDto createDto = new UserCreateDto();
        Long userId = userPersistencePort.joinNewUser(createDto).getId();

        UserUpdateDto updateDto = new UserUpdateDto();
        updateDto.setEmail("update");
        updateDto.setPassword("update");

        User user = userPersistencePort.updateUserInfo(updateDto, userId);

        assertEquals(updateDto.getEmail(), user.getEmail());
        assertEquals(updateDto.getPassword(), user.getPassword());
    }

    @Test
    void deleteUser() {
        UserCreateDto createDto = new UserCreateDto();
        Long userId = userPersistencePort.joinNewUser(createDto).getId();

        userPersistencePort.deleteUser(userId);

        assertThrows(IllegalArgumentException.class, () -> userPersistencePort.getUserById(userId));
    }

}