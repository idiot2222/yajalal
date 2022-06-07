package me.bogeun.adapter;

import lombok.RequiredArgsConstructor;
import me.bogeun.domain.Team;
import me.bogeun.entity.TeamEntity;
import me.bogeun.mapper.TeamMapper;
import me.bogeun.payload.team.TeamCreateDto;
import me.bogeun.payload.team.TeamUpdateDto;
import me.bogeun.port.outgoing.TeamPersistencePort;
import me.bogeun.repository.TeamRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamPersistenceImpl implements TeamPersistencePort {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    public void createTeam(TeamCreateDto createDto) {
        TeamEntity team = teamMapper.createDtoToEntity(createDto);

        teamRepository.save(team);
    }

    @Override
    public Team getTeamById(Long teamId) {
        TeamEntity entity = teamRepository.findById(teamId).orElseThrow(() -> new IllegalArgumentException("invalid team id."));

        return teamMapper.entityToTeam(entity);
    }

    @Override
    public Team updateTeam(TeamUpdateDto updateDto) {
        Team team = getTeamById(updateDto.getId());
        team.update(updateDto);

        TeamEntity entity = teamMapper.teamToEntity(team);
        teamRepository.save(entity);

        return team;
    }

    @Override
    public void deleteTeam(Long teamId) {
        Team team = getTeamById(teamId);
        TeamEntity entity = teamMapper.teamToEntity(team);

        teamRepository.delete(entity);
    }
}
