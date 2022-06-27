package me.bogeun.yajalal.adapter;

import me.bogeun.yajalal.TestConfig;
import me.bogeun.yajalal.domain.Team;
import me.bogeun.yajalal.mapper.TeamMapper;
import me.bogeun.yajalal.payload.team.TeamCreateDto;
import me.bogeun.yajalal.payload.team.TeamUpdateDto;
import me.bogeun.yajalal.port.outgoing.TeamPersistencePort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@Import(TestConfig.class)
class TeamPersistenceImplTest {

    @Autowired
    TeamPersistencePort teamPersistencePort;

    @Autowired
    TeamMapper teamMapper;

    @Test
    @DisplayName("createTeam(), getTeamById()")
    void createTeam() {
        TeamCreateDto createDto = new TeamCreateDto();
        createDto.setName("test");
        createDto.setDescription("team for test");
        createDto.setLimit(9);

        Long teamId = teamPersistencePort.createTeam(createDto).getId();
        Team team = teamPersistencePort.getTeamById(teamId);

        assertEquals("test", team.getName());
        assertEquals("team for test", team.getDescription());
        assertEquals(9, team.getLimit());
    }

    @Test
    void updateTeam() {
        TeamCreateDto createDto = new TeamCreateDto();
        Long teamId = teamPersistencePort.createTeam(createDto).getId();

        TeamUpdateDto updateDto = new TeamUpdateDto();
        updateDto.setName("update");
        updateDto.setDescription("update");
        updateDto.setLimit(9);

        Team team = teamPersistencePort.updateTeam(updateDto, teamId);

        assertEquals("update", team.getName());
        assertEquals("update", team.getDescription());
        assertEquals(9, team.getLimit());
    }

    @Test
    void deleteTeam() {
        TeamCreateDto createDto = new TeamCreateDto();
        Long teamId = teamPersistencePort.createTeam(createDto).getId();

        teamPersistencePort.deleteTeam(teamId);

        assertThrows(IllegalArgumentException.class, () -> teamPersistencePort.getTeamById(teamId), "invalid team id.");
    }

}