package me.bogeun.yajalal.adapter;

import lombok.RequiredArgsConstructor;
import me.bogeun.yajalal.domain.Team;
import me.bogeun.yajalal.entity.TeamEntity;
import me.bogeun.yajalal.mapper.TeamMapper;
import me.bogeun.yajalal.payload.team.TeamCreateDto;
import me.bogeun.yajalal.payload.team.TeamUpdateDto;
import me.bogeun.yajalal.port.outgoing.TeamPersistencePort;
import me.bogeun.yajalal.repository.TeamRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamPersistenceImpl implements TeamPersistencePort {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    public Team createTeam(TeamCreateDto createDto) {
        TeamEntity teamEntity = teamMapper.createDtoToEntity(createDto);

        teamRepository.save(teamEntity);

        return teamMapper.entityToTeam(teamEntity);
    }

    @Override
    public Team getTeamById(Long teamId) {
        TeamEntity teamEntity = teamRepository.findById(teamId).orElseThrow(() -> new IllegalArgumentException("invalid team id."));

        return teamMapper.entityToTeam(teamEntity);
    }

    @Override
    public Team updateTeam(TeamUpdateDto updateDto, Long teamId) {
        TeamEntity teamEntity = teamMapper.updateDtoToEntity(updateDto);
        teamRepository.save(teamEntity);

        return teamMapper.entityToTeam(teamEntity);
    }

    @Override
    public void deleteTeam(Long teamId) {
        Team team = getTeamById(teamId);
        TeamEntity teamEntity = teamMapper.teamToEntity(team);

        teamRepository.delete(teamEntity);
    }
}
