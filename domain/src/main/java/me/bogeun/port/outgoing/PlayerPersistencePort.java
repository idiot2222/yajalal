package me.bogeun.port.outgoing;

import me.bogeun.domain.Player;
import me.bogeun.payload.player.PlayerCreateDto;
import me.bogeun.payload.player.PlayerUpdateDto;

public interface PlayerPersistencePort {

    Player createPlayer(PlayerCreateDto createDto);

    Player getPlayerById(Long playerId);

    Player updatePlayer(PlayerUpdateDto updateDto);

    void deletePlayer(Long playerId);

}
