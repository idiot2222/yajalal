package me.bogeun.port.outgoing;

import me.bogeun.domain.Player;
import me.bogeun.payload.player.PlayerCreateDto;
import me.bogeun.payload.player.PlayerUpdateDto;

import java.util.List;

public interface PlayerPersistencePort {

    void createPlayer(PlayerCreateDto createDto);

    Player getPlayerById(Long playerId);

    List<Player> getAllPlayerList();

    Player updatePlayer(PlayerUpdateDto updateDto);

    void deletePlayer(Long playerId);

}
