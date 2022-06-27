package me.bogeun.yajalal.mapper;

import me.bogeun.yajalal.domain.Team;
import me.bogeun.yajalal.entity.TeamEntity;
import me.bogeun.yajalal.payload.team.TeamCreateDto;
import me.bogeun.yajalal.payload.team.TeamUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    @Mapping(target = "id", ignore = true)
    TeamEntity createDtoToEntity(TeamCreateDto createDto);

    Team entityToTeam(TeamEntity entity);

    TeamEntity teamToEntity(Team team);

    TeamEntity updateDtoToEntity(TeamUpdateDto updateDto);

}
