package me.bogeun.adapter;

import me.bogeun.TestConfig;
import me.bogeun.domain.Player;
import me.bogeun.domain.Position;
import me.bogeun.mapper.PlayerMapper;
import me.bogeun.payload.player.PlayerCreateDto;
import me.bogeun.payload.player.PlayerUpdateDto;
import me.bogeun.payload.user.UserUpdateDto;
import me.bogeun.port.outgoing.PlayerPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@Import(TestConfig.class)
class PlayerPersistenceImplTest {

    @Autowired
    PlayerPersistencePort playerPersistencePort;

    @Autowired
    PlayerMapper playerMapper;

    @BeforeEach
    void beforeEach() {
        PlayerCreateDto createDto = new PlayerCreateDto();
        createDto.setName("test");
        createDto.setLength(200);
        createDto.setWeight(100);
        createDto.setDescription("test");
        createDto.setPosition(Position.C);

        playerPersistencePort.createPlayer(createDto);
    }

    @Test
    void createPlayer() {
        PlayerCreateDto createDto = new PlayerCreateDto();
        createDto.setName("bogeun");
        createDto.setLength(180);
        createDto.setWeight(80);
        createDto.setDescription("babo");
        createDto.setPosition(Position.P);

        playerPersistencePort.createPlayer(createDto);
        Player player = playerPersistencePort.getPlayerById(2L);

        assertEquals("bogeun", player.getName());
        assertEquals(180, player.getLength());
        assertEquals(80, player.getWeight());
        assertEquals("babo", player.getDescription());
        assertEquals(Position.P, player.getPosition());
    }

    @Test
    void getPlayerById() {
        Player player = playerPersistencePort.getPlayerById(1L);

        assertEquals("test", player.getName());
        assertEquals(200, player.getLength());
        assertEquals(100, player.getWeight());
        assertEquals("test", player.getDescription());
        assertEquals(Position.C, player.getPosition());
    }

    @Test
    void updatePlayer() {
        PlayerUpdateDto updateDto = new PlayerUpdateDto();
        updateDto.setId(1L);
        updateDto.setLength(10);
        updateDto.setWeight(10);
        updateDto.setDescription("TEST");
        updateDto.setPosition(Position.P);

        Player player = playerPersistencePort.updatePlayer(updateDto);
        Player foundPlayer = playerPersistencePort.getPlayerById(1L);

        assertEquals(player.getId(), foundPlayer.getId());
        assertEquals(player.getLength(), foundPlayer.getLength());
        assertEquals(player.getWeight(), foundPlayer.getWeight());
        assertEquals(player.getDescription(), foundPlayer.getDescription());
        assertEquals(player.getPosition(), foundPlayer.getPosition());

        assertEquals(1L, player.getId());
        assertEquals(10, player.getLength());
        assertEquals(10, player.getWeight());
        assertEquals("TEST", player.getDescription());
        assertEquals(Position.P, player.getPosition());
    }

    @Test
    void deletePlayer() {
        playerPersistencePort.deletePlayer(1L);

        assertThrows(IllegalArgumentException.class,
                    () -> playerPersistencePort.getPlayerById(1L),
                    "invalid player id.");
    }

}