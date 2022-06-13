package me.bogeun.port.incoming;

import me.bogeun.domain.Team;
import me.bogeun.payload.team.TeamCreateDto;
import me.bogeun.payload.team.TeamUpdateDto;

import java.util.List;

public interface TeamServicePort {

    Team createTeam(TeamCreateDto createDto);

    Team getTeamById(Long teamId);

    Team updateTeam(TeamUpdateDto updateDto);

    void deleteTeam(Long teamId);

}
