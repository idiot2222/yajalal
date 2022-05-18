package me.bogeun.adapter;

import lombok.RequiredArgsConstructor;
import me.bogeun.domain.Team;
import me.bogeun.payload.team.TeamCreateDto;
import me.bogeun.payload.team.TeamUpdateDto;
import me.bogeun.port.incoming.TeamServicePort;
import me.bogeun.port.outgoing.TeamPersistencePort;

import java.util.List;

@RequiredArgsConstructor
public class TeamServiceImpl implements TeamServicePort {

    private final TeamPersistencePort teamPersistencePort;

    @Override
    public void createTeam(TeamCreateDto createDto) {
        teamPersistencePort.createTeam(createDto);
    }

    @Override
    public Team getTeamById(Long teamId) {
        return teamPersistencePort.getTeamById(teamId);
    }

    @Override
    public List<Team> getAllTeamList() {
        return teamPersistencePort.getAllTeamList();
    }

    @Override
    public Team updateTeam(TeamUpdateDto updateDto) {
        return teamPersistencePort.updateTeam(updateDto);
    }

    @Override
    public void deleteTeam(Long teamId) {
        teamPersistencePort.deleteTeam(teamId);
    }

}
