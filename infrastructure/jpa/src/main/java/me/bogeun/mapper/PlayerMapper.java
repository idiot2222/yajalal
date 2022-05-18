package me.bogeun.mapper;

import me.bogeun.domain.Player;
import me.bogeun.payload.player.PlayerCreateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    Player createDtoToPlayer(PlayerCreateDto createDto);

}
