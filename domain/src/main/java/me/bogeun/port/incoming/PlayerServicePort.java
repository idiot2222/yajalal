package me.bogeun.port.incoming;

import me.bogeun.domain.Player;
import me.bogeun.payload.player.PlayerCreateDto;
import me.bogeun.payload.player.PlayerUpdateDto;

import java.util.List;

public interface PlayerServicePort {

    void createPlayer(PlayerCreateDto createDto);

    Player getPlayerById(Long playerId);

    Player updatePlayer(PlayerUpdateDto updateDto);

    void deletePlayer(Long playerId);

}
