package me.bogeun.port.outgoing;

import me.bogeun.domain.User;
import me.bogeun.payload.team.TeamCreateDto;
import me.bogeun.payload.team.TeamUpdateDto;

import java.util.List;

public interface TeamPersistencePort {

    void createTeam(TeamCreateDto createDto);

    User getTeamById(Long teamId);

    List<User> getAllTeamList();

    User updateTeam(TeamUpdateDto updateDto);

    void deleteTeam(Long teamId);

}
