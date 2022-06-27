package me.bogeun.yajalal.adapter;

import me.bogeun.yajalal.TestConfig;
import me.bogeun.yajalal.domain.Gender;
import me.bogeun.yajalal.domain.Player;
import me.bogeun.yajalal.domain.Position;
import me.bogeun.yajalal.domain.User;
import me.bogeun.yajalal.mapper.PlayerMapper;
import me.bogeun.yajalal.payload.player.PlayerCreateDto;
import me.bogeun.yajalal.payload.player.PlayerUpdateDto;
import me.bogeun.yajalal.payload.user.UserCreateDto;
import me.bogeun.yajalal.port.outgoing.PlayerPersistencePort;
import me.bogeun.yajalal.port.outgoing.UserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@Import(TestConfig.class)
@Transactional
class PlayerPersistenceImplTest {

    @Autowired
    PlayerPersistencePort playerPersistencePort;
    @Autowired
    UserPersistencePort userPersistencePort;
    @Autowired
    PlayerMapper playerMapper;

    Long userId;

    @BeforeEach
    void beforeAll() {
        UserCreateDto createDto = new UserCreateDto();
        createDto.setUsername("testuser");
        createDto.setPassword("password");
        createDto.setEmail("test123@email.com");
        createDto.setBirthDate(LocalDate.of(2000, 1 ,1));
        createDto.setGender(Gender.MALE);

        User user = userPersistencePort.joinNewUser(createDto);

        userId = user.getId();
    }

    @Test
    @DisplayName("createPlayer(), getPlayerById()")
    void createPlayer() {
        PlayerCreateDto createDto = new PlayerCreateDto();
        createDto.setName("bogeun");
        createDto.setLength(180);
        createDto.setWeight(80);
        createDto.setDescription("babo");
        createDto.setPosition(Position.P);

        Player player = playerPersistencePort.createPlayer(createDto, userId);
        Player foundPlayer = playerPersistencePort.getPlayerById(player.getId());

        assertEquals(player.getName(), foundPlayer.getName());
        assertEquals(player.getLength(), foundPlayer.getLength());
        assertEquals(player.getWeight(), foundPlayer.getWeight());
        assertEquals(player.getDescription(), foundPlayer.getDescription());
        assertEquals(player.getPosition(), foundPlayer.getPosition());
    }

    @Test
    void updatePlayer() {
        PlayerCreateDto createDto = new PlayerCreateDto();
        Long playerId = playerPersistencePort.createPlayer(createDto, userId).getId();

        PlayerUpdateDto updateDto = new PlayerUpdateDto();
        updateDto.setLength(10);
        updateDto.setWeight(10);
        updateDto.setDescription("TEST");
        updateDto.setPosition(Position.P);

        Player player = playerPersistencePort.updatePlayer(updateDto, playerId);

        assertEquals(playerId, player.getId());
        assertEquals(10, player.getLength());
        assertEquals(10, player.getWeight());
        assertEquals("TEST", player.getDescription());
        assertEquals(Position.P, player.getPosition());
    }

    @Test
    void deletePlayer() {
        PlayerCreateDto createDto = new PlayerCreateDto();
        Long playerId = playerPersistencePort.createPlayer(createDto, userId).getId();

        playerPersistencePort.deletePlayer(playerId);

        assertThrows(IllegalArgumentException.class,
                    () -> playerPersistencePort.getPlayerById(playerId),
                    "invalid player id.");
    }

}