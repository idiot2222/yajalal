package me.bogeun.adapter;


import me.bogeun.domain.Player;
import me.bogeun.domain.Position;
import me.bogeun.payload.player.PlayerCreateDto;
import me.bogeun.payload.player.PlayerUpdateDto;
import me.bogeun.port.outgoing.PlayerPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceImplTest {

    @Mock
    PlayerPersistencePort playerPersistencePort;

    @InjectMocks
    PlayerServiceImpl playerServicePort;

    PlayerCreateDto createDto;
    Long playerId;
    Player player;

    @BeforeEach
    void beforeEach() {
        createDto = new PlayerCreateDto();
        createDto.setName("test");
        createDto.setLength(180);
        createDto.setWeight(80);
        createDto.setDescription("test.");
        createDto.setPosition(Position.C);

        playerId = 1L;

        player = new Player();
        player.setId(playerId);
        player.setName(createDto.getName());
        player.setLength(createDto.getLength());
        player.setWeight(createDto.getWeight());
        player.setDescription(createDto.getDescription());
        player.setPosition(createDto.getPosition());
    }

    @Test
    void createPlayer() {
        Long userId = 0L;

        when(playerPersistencePort.createPlayer(createDto, userId))
                .thenReturn(player);

        Player result = playerServicePort.createPlayer(createDto, userId);

        assertEquals("test", result.getName());
        assertEquals(180, result.getLength());
        assertEquals(80, result.getWeight());
        assertEquals("test.", result.getDescription());
        assertEquals(Position.C, result.getPosition());
    }

    @Test
    void getPlayerById() {
        when(playerPersistencePort.getPlayerById(playerId)).thenReturn(player);

        Player result = playerServicePort.getPlayerById(playerId);

        assertEquals("test", result.getName());
        assertEquals(180, result.getLength());
        assertEquals(80, result.getWeight());
        assertEquals("test.", result.getDescription());
        assertEquals(Position.C, result.getPosition());
    }

    @Test
    void updatePlayer() {
        PlayerUpdateDto updateDto = new PlayerUpdateDto();
        updateDto.setLength(200);
        updateDto.setWeight(100);
        updateDto.setDescription("updated.");
        updateDto.setPosition(Position.P);

        Player updatedPlayer = new Player();
        updatedPlayer.setId(playerId);
        updatedPlayer.setName(player.getName());
        updatedPlayer.setLength(200);
        updatedPlayer.setWeight(100);
        updatedPlayer.setDescription("updated.");
        updatedPlayer.setPosition(Position.P);

        when(playerPersistencePort.updatePlayer(updateDto, playerId)).thenReturn(updatedPlayer);

        Player result = playerServicePort.updatePlayer(updateDto, playerId);

        assertEquals("test", result.getName());
        assertEquals(200, result.getLength());
        assertEquals(100, result.getWeight());
        assertEquals("updated.", result.getDescription());
        assertEquals(Position.P, result.getPosition());
    }

}
