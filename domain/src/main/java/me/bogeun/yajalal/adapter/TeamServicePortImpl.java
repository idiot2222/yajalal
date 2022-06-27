package me.bogeun.yajalal.adapter;

import lombok.RequiredArgsConstructor;
import me.bogeun.yajalal.domain.Team;
import me.bogeun.yajalal.payload.team.TeamCreateDto;
import me.bogeun.yajalal.payload.team.TeamUpdateDto;
import me.bogeun.yajalal.port.incoming.TeamServicePort;
import me.bogeun.yajalal.port.outgoing.TeamPersistencePort;

@RequiredArgsConstructor
public class TeamServicePortImpl implements TeamServicePort {

    private final TeamPersistencePort teamPersistencePort;

    @Override
    public Team createTeam(TeamCreateDto createDto) {
        return teamPersistencePort.createTeam(createDto);
    }

    @Override
    public Team getTeamById(Long teamId) {
        return teamPersistencePort.getTeamById(teamId);
    }

    @Override
    public Team updateTeam(TeamUpdateDto updateDto, Long teamId) {
        return teamPersistencePort.updateTeam(updateDto, teamId);
    }

    @Override
    public void deleteTeam(Long teamId) {
        teamPersistencePort.deleteTeam(teamId);
    }

}
