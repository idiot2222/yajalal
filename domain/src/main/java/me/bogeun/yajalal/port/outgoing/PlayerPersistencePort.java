package me.bogeun.yajalal.port.outgoing;

import me.bogeun.yajalal.domain.Player;
import me.bogeun.yajalal.payload.player.PlayerCreateDto;
import me.bogeun.yajalal.payload.player.PlayerUpdateDto;

public interface PlayerPersistencePort {

    Player createPlayer(PlayerCreateDto createDto, Long userId);

    Player getPlayerById(Long playerId);

    Player updatePlayer(PlayerUpdateDto updateDto, Long playerId);

    void deletePlayer(Long playerId);

}
