package me.bogeun.yajalal.port.outgoing;

import me.bogeun.yajalal.domain.Team;
import me.bogeun.yajalal.payload.team.TeamCreateDto;
import me.bogeun.yajalal.payload.team.TeamUpdateDto;

public interface TeamPersistencePort {

    Team createTeam(TeamCreateDto createDto);

    Team getTeamById(Long teamId);

    Team updateTeam(TeamUpdateDto updateDto, Long teamId);

    void deleteTeam(Long teamId);

}
