package me.bogeun.port.outgoing;

import me.bogeun.domain.Team;
import me.bogeun.payload.team.TeamCreateDto;
import me.bogeun.payload.team.TeamUpdateDto;

public interface TeamPersistencePort {

    Team createTeam(TeamCreateDto createDto);

    Team getTeamById(Long teamId);

    Team updateTeam(TeamUpdateDto updateDto, Long teamId);

    void deleteTeam(Long teamId);

}
