package me.bogeun.port.incoming;

import me.bogeun.domain.Team;
import me.bogeun.payload.team.TeamCreateDto;
import me.bogeun.payload.team.TeamUpdateDto;

import java.util.List;

public interface TeamServicePort {

    void createTeam(TeamCreateDto createDto);

    Team getTeamById(Long teamId);

    List<Team> getAllTeamList();

    Team updateTeam(TeamUpdateDto updateDto);

    void deleteTeam(Long teamId);

}
