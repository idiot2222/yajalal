package me.bogeun.adapter;

import me.bogeun.TestConfig;
import me.bogeun.domain.Player;
import me.bogeun.domain.Position;
import me.bogeun.mapper.PlayerMapper;
import me.bogeun.payload.player.PlayerCreateDto;
import me.bogeun.payload.player.PlayerUpdateDto;
import me.bogeun.port.outgoing.PlayerPersistencePort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@Import(TestConfig.class)
@Transactional
class PlayerPersistenceImplTest {

    @Autowired
    PlayerPersistencePort playerPersistencePort;

    @Autowired
    PlayerMapper playerMapper;

    @Test
    @DisplayName("createPlayer(), getPlayerById()")
    void createPlayer() {
        PlayerCreateDto createDto = new PlayerCreateDto();
        createDto.setName("bogeun");
        createDto.setLength(180);
        createDto.setWeight(80);
        createDto.setDescription("babo");
        createDto.setPosition(Position.P);

        Player player = playerPersistencePort.createPlayer(createDto);
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
        Long playerId = playerPersistencePort.createPlayer(createDto).getId();

        PlayerUpdateDto updateDto = new PlayerUpdateDto();
        updateDto.setId(playerId);
        updateDto.setLength(10);
        updateDto.setWeight(10);
        updateDto.setDescription("TEST");
        updateDto.setPosition(Position.P);

        Player player = playerPersistencePort.updatePlayer(updateDto);

        assertEquals(playerId, player.getId());
        assertEquals(10, player.getLength());
        assertEquals(10, player.getWeight());
        assertEquals("TEST", player.getDescription());
        assertEquals(Position.P, player.getPosition());
    }

    @Test
    void deletePlayer() {
        PlayerCreateDto createDto = new PlayerCreateDto();
        Long playerId = playerPersistencePort.createPlayer(createDto).getId();

        playerPersistencePort.deletePlayer(playerId);

        assertThrows(IllegalArgumentException.class,
                    () -> playerPersistencePort.getPlayerById(playerId),
                    "invalid player id.");
    }

}