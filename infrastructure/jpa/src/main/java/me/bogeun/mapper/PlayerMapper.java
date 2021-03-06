package me.bogeun.mapper;

import me.bogeun.domain.Player;
import me.bogeun.entity.PlayerEntity;
import me.bogeun.payload.player.PlayerCreateDto;
import me.bogeun.payload.player.PlayerUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(target = "id", ignore = true)
    PlayerEntity createDtoToPlayerEntity(PlayerCreateDto createDto);

    Player entityToPlayer(PlayerEntity entity);

    PlayerEntity playerToEntity(Player player);

    @Mapping(target = "name", ignore = true)
    PlayerEntity updateDtoToEntity(PlayerUpdateDto updateDto);
}
