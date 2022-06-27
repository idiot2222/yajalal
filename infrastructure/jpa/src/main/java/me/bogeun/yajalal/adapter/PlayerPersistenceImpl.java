package me.bogeun.yajalal.adapter;

import lombok.RequiredArgsConstructor;
import me.bogeun.yajalal.domain.Player;
import me.bogeun.yajalal.domain.User;
import me.bogeun.yajalal.entity.PlayerEntity;
import me.bogeun.yajalal.mapper.PlayerMapper;
import me.bogeun.yajalal.mapper.UserMapper;
import me.bogeun.yajalal.payload.player.PlayerCreateDto;
import me.bogeun.yajalal.payload.player.PlayerUpdateDto;
import me.bogeun.yajalal.port.outgoing.PlayerPersistencePort;
import me.bogeun.yajalal.port.outgoing.UserPersistencePort;
import me.bogeun.yajalal.repository.PlayerRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerPersistenceImpl implements PlayerPersistencePort {

    private final PlayerRepository playerRepository;
    private final UserPersistencePort userPersistencePort;
    private final PlayerMapper playerMapper;
    private final UserMapper userMapper;

    @Override
    public Player createPlayer(PlayerCreateDto createDto, Long userId) {
        PlayerEntity playerEntity = playerMapper.createDtoToPlayerEntity(createDto);
        User user = userPersistencePort.getUserById(userId);
        playerEntity.setUser(userMapper.userToEntity(user));

        playerRepository.save(playerEntity);

        return playerMapper.entityToPlayer(playerEntity);
    }

    @Override
    public Player getPlayerById(Long playerId) {
        PlayerEntity playerEntity = playerRepository.findById(playerId).orElseThrow(() -> new IllegalArgumentException("invalid player id"));

        return playerMapper.entityToPlayer(playerEntity);
    }

    @Override
    public Player updatePlayer(PlayerUpdateDto updateDto, Long playerId) {
        PlayerEntity playerEntity = playerMapper.updateDtoToEntity(updateDto);
        playerEntity.setId(playerId);

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
