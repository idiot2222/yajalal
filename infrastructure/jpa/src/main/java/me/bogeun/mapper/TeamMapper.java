package me.bogeun.mapper;

import me.bogeun.domain.Team;
import me.bogeun.payload.team.TeamCreateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    Team createDtoToTeam(TeamCreateDto createDto);

}
