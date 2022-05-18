package me.bogeun.adapter;

import lombok.RequiredArgsConstructor;
import me.bogeun.domain.Player;
import me.bogeun.mapper.PlayerMapper;
import me.bogeun.payload.player.PlayerCreateDto;
import me.bogeun.payload.player.PlayerUpdateDto;
import me.bogeun.port.outgoing.PlayerPersistencePort;
import me.bogeun.repository.PlayerRepository;

import java.util.List;

@RequiredArgsConstructor
public class PlayerPersistenceImpl implements PlayerPersistencePort {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public void createPlayer(PlayerCreateDto createDto) {
        Player player = playerMapper.createDtoToPlayer(createDto);

        playerRepository.save(player);
    }

    @Override
    public Player getPlayerById(Long playerId) {
        return playerRepository.findById(playerId).orElseThrow(() -> new IllegalArgumentException("invalid player id"));

    }

    @Override
    public List<Player> getAllPlayerList() {
        return playerRepository.findAll();
    }

    @Override
    public Player updatePlayer(PlayerUpdateDto updateDto) {
        Player player = getPlayerById(updateDto.getId());

        player.updateInfo(updateDto);
        playerRepository.save(player);

        return player;
    }

    @Override
    public void deletePlayer(Long playerId) {
        Player player = getPlayerById(playerId);

        playerRepository.delete(player);
    }
}
