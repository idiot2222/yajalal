package me.bogeun.port.outgoing;

import me.bogeun.domain.User;
import me.bogeun.payload.player.PlayerCreateDto;
import me.bogeun.payload.player.PlayerUpdateDto;

import java.util.List;

public interface PlayerPersistencePort {

    void createPlayer(PlayerCreateDto createDto);

    User getPlayerById(Long playerId);

    List<User> getAllPlayerList();

    User updatePlayer(PlayerUpdateDto updateDto);

    void deletePlayer(Long playerId);

}
