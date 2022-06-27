package me.bogeun.yajalal.adapter;

import lombok.RequiredArgsConstructor;
import me.bogeun.yajalal.domain.Player;
import me.bogeun.yajalal.payload.player.PlayerCreateDto;
import me.bogeun.yajalal.payload.player.PlayerUpdateDto;
import me.bogeun.yajalal.port.incoming.PlayerServicePort;
import me.bogeun.yajalal.port.outgoing.PlayerPersistencePort;

@RequiredArgsConstructor
public class PlayerServicePortImpl implements PlayerServicePort {

    private final PlayerPersistencePort playerPersistencePort;

    @Override
    public Player createPlayer(PlayerCreateDto createDto, Long userId) {
        return playerPersistencePort.createPlayer(createDto, userId);
    }

    @Override
    public Player getPlayerById(Long playerId) {
        return playerPersistencePort.getPlayerById(playerId);
    }

    @Override
    public Player updatePlayer(PlayerUpdateDto updateDto, Long playerId) {
        return playerPersistencePort.updatePlayer(updateDto, playerId);
    }

    @Override
    public void deletePlayer(Long playerId) {
        playerPersistencePort.deletePlayer(playerId);
    }

}
