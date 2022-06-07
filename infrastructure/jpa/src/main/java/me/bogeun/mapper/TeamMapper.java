package me.bogeun.mapper;

import me.bogeun.domain.Team;
import me.bogeun.entity.TeamEntity;
import me.bogeun.payload.team.TeamCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    @Mapping(target = "id", ignore = true)
    TeamEntity createDtoToEntity(TeamCreateDto createDto);

    Team entityToTeam(TeamEntity entity);

    TeamEntity teamToEntity(Team team);
}
