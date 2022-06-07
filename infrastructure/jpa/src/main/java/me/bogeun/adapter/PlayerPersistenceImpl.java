package me.bogeun.adapter;

import lombok.RequiredArgsConstructor;
import me.bogeun.domain.Player;
import me.bogeun.entity.PlayerEntity;
import me.bogeun.mapper.PlayerMapper;
import me.bogeun.payload.player.PlayerCreateDto;
import me.bogeun.payload.player.PlayerUpdateDto;
import me.bogeun.port.outgoing.PlayerPersistencePort;
import me.bogeun.repository.PlayerRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerPersistenceImpl implements PlayerPersistencePort {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public Player createPlayer(PlayerCreateDto createDto) {
        PlayerEntity playerEntity = playerMapper.createDtoToPlayerEntity(createDto);

        playerRepository.save(playerEntity);

        return playerMapper.entityToPlayer(playerEntity);
    }

    @Override
    public Player getPlayerById(Long playerId) {
        PlayerEntity playerEntity = playerRepository.findById(playerId).orElseThrow(() -> new IllegalArgumentException("invalid player id"));

        return playerMapper.entityToPlayer(playerEntity);
    }

    @Override
    public Player updatePlayer(PlayerUpdateDto updateDto) {
        PlayerEntity playerEntity = playerMapper.updateDtoToEntity(updateDto);
        playerRepository.save(playerEntity);

        return playerMapper.entityToPlayer(playerEntity);
    }

    @Override
    public void deletePlayer(Long playerId) {
        Player player = getPlayerById(playerId);
        PlayerEntity playerEntity = playerMapper.playerToEntity(player);

        playerRepository.delete(playerEntity);
    }

}
