package me.bogeun.adapter;

import lombok.RequiredArgsConstructor;
import me.bogeun.domain.Player;
import me.bogeun.payload.player.PlayerCreateDto;
import me.bogeun.payload.player.PlayerUpdateDto;
import me.bogeun.port.incoming.PlayerServicePort;
import me.bogeun.port.outgoing.PlayerPersistencePort;

import java.util.List;

@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerServicePort {

    private final PlayerPersistencePort playerPersistencePort;

    @Override
    public void createPlayer(PlayerCreateDto createDto, Long userId) {
        playerPersistencePort.createPlayer(createDto, userId);
    }

    @Override
    public Player getPlayerById(Long playerId) {
        return playerPersistencePort.getPlayerById(playerId);
    }

    @Override
    public Player updatePlayer(PlayerUpdateDto updateDto) {
        return playerPersistencePort.updatePlayer(updateDto);
    }

    @Override
    public void deletePlayer(Long playerId) {
        playerPersistencePort.deletePlayer(playerId);
    }

}
