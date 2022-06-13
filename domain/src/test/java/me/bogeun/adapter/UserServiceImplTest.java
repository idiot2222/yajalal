package me.bogeun.adapter;

import me.bogeun.domain.Gender;
import me.bogeun.domain.User;
import me.bogeun.payload.user.UserCreateDto;
import me.bogeun.payload.user.UserUpdateDto;
import me.bogeun.port.incoming.UserServicePort;
import me.bogeun.port.outgoing.UserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserPersistencePort userPersistencePort;

    @InjectMocks
    UserServiceImpl userServicePort;

    UserCreateDto createDto;
    Long userId;
    User user;

    @BeforeEach
    void beforeEach() {
        createDto = new UserCreateDto();
        createDto.setUsername("username");
        createDto.setPassword("password");
        createDto.setEmail("user@email.com");
        createDto.setBirthDate(LocalDate.of(1995, 5, 30));
        createDto.setGender(Gender.MALE);

        userId = 1L;

        user = new User();
        user.setId(userId);
        user.setUsername(createDto.getUsername());
        user.setPassword(createDto.getPassword());
        user.setEmail(createDto.getEmail());
        user.setBirthDate(createDto.getBirthDate());
        user.setGender(createDto.getGender());
    }

    @Test
    void createUser() {
        when(userPersistencePort.joinNewUser(createDto)).thenReturn(user);

        User result = userServicePort.createUser(createDto);

        assertEquals(userId, result.getId());
        assertEquals(createDto.getUsername(), result.getUsername());
        assertEquals(createDto.getPassword(), result.getPassword());
        assertEquals(createDto.getEmail(), result.getEmail());
        assertEquals(createDto.getBirthDate(), result.getBirthDate());
        assertEquals(createDto.getGender(), result.getGender());
    }

    @Test
    void getUserById() {
        when(userPersistencePort.getUserById(userId)).thenReturn(user);

        User result = userServicePort.getUserById(userId);

        assertEquals(userId, result.getId());
        assertEquals(createDto.getUsername(), result.getUsername());
        assertEquals(createDto.getPassword(), result.getPassword());
        assertEquals(createDto.getEmail(), result.getEmail());
        assertEquals(createDto.getBirthDate(), result.getBirthDate());
        assertEquals(createDto.getGender(), result.getGender());
    }

    @Test
    void updateUser() {
        UserUpdateDto updateDto = new UserUpdateDto();
        updateDto.setPassword("password123");
        updateDto.setEmail("updated@email.com");

        User updatedUser = new User();
        updatedUser.setId(userId);
        updatedUser.setUsername(createDto.getUsername());
        updatedUser.setPassword(updateDto.getPassword());
        updatedUser.setEmail(updateDto.getEmail());
        updatedUser.setBirthDate(createDto.getBirthDate());
        updatedUser.setGender(createDto.getGender());

        when(userPersistencePort.updateUserInfo(updateDto, userId)).thenReturn(updatedUser);

        User result = userServicePort.updateUser(updateDto, userId);

        assertEquals(userId, result.getId());
        assertEquals(updatedUser.getUsername(), result.getUsername());
        assertEquals(updatedUser.getPassword(), result.getPassword());
        assertEquals(updatedUser.getEmail(), result.getEmail());
        assertEquals(updatedUser.getBirthDate(), result.getBirthDate());
        assertEquals(updatedUser.getGender(), result.getGender());
    }

}