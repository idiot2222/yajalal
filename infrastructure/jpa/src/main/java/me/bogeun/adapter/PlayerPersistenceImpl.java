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
    public void createPlayer(PlayerCreateDto createDto) {
        PlayerEntity player = playerMapper.createDtoToPlayerEntity(createDto);

        playerRepository.save(player);
    }

    @Override
    public Player getPlayerById(Long playerId) {
        PlayerEntity playerEntity = playerRepository.findById(playerId).orElseThrow(() -> new IllegalArgumentException("invalid player id"));

        return playerMapper.entityToPlayer(playerEntity);
    }

    @Override
    public Player updatePlayer(PlayerUpdateDto updateDto) {
        Player player = getPlayerById(updateDto.getId());
        player.updateInfo(updateDto);

        PlayerEntity entity = playerMapper.playerToEntity(player);
        playerRepository.save(entity);

        return player;
    }

    @Override
    public void deletePlayer(Long playerId) {
        Player player = getPlayerById(playerId);
        PlayerEntity entity = playerMapper.playerToEntity(player);

        playerRepository.delete(entity);
    }
}
