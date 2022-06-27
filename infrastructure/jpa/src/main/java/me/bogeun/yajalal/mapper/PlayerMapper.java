package me.bogeun.yajalal.mapper;

import me.bogeun.yajalal.domain.Player;
import me.bogeun.yajalal.entity.PlayerEntity;
import me.bogeun.yajalal.payload.player.PlayerCreateDto;
import me.bogeun.yajalal.payload.player.PlayerUpdateDto;
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
