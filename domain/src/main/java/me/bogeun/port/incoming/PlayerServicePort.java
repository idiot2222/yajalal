package me.bogeun.port.incoming;

import me.bogeun.domain.User;
import me.bogeun.payload.player.PlayerCreateDto;
import me.bogeun.payload.player.PlayerUpdateDto;
import me.bogeun.payload.user.UserCreateDto;
import me.bogeun.payload.user.UserUpdateDto;

import java.util.List;

public interface PlayerServicePort {

    void createPlayer(PlayerCreateDto createDto);

    User getPlayerById(Long playerId);

    List<User> getAllPlayerList();

    User updatePlayer(PlayerUpdateDto updateDto);

    void deletePlayer(Long playerId);

}
