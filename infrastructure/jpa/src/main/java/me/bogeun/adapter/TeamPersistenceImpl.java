package me.bogeun.adapter;

import lombok.RequiredArgsConstructor;
import me.bogeun.domain.Team;
import me.bogeun.mapper.TeamMapper;
import me.bogeun.payload.team.TeamCreateDto;
import me.bogeun.payload.team.TeamUpdateDto;
import me.bogeun.port.outgoing.TeamPersistencePort;
import me.bogeun.repository.TeamRepository;

import java.util.List;

@RequiredArgsConstructor
public class TeamPersistenceImpl implements TeamPersistencePort {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    public void createTeam(TeamCreateDto createDto) {
        Team team = teamMapper.createDtoToTeam(createDto);

        teamRepository.save(team);
    }

    @Override
    public Team getTeamById(Long teamId) {
        return teamRepository.findById(teamId).orElseThrow(() -> new IllegalArgumentException("invalid team id."));
    }

    @Override
    public List<Team> getAllTeamList() {
        return teamRepository.findAll();
    }

    @Override
    public Team updateTeam(TeamUpdateDto updateDto) {
        Team team = getTeamById(updateDto.getId());

        team.update(updateDto);
        teamRepository.save(team);

        return team;
    }

    @Override
    public void deleteTeam(Long teamId) {

    }
}
