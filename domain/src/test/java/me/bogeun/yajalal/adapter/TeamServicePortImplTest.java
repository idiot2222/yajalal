package me.bogeun.yajalal.adapter;

import me.bogeun.yajalal.domain.Team;
import me.bogeun.yajalal.payload.team.TeamCreateDto;
import me.bogeun.yajalal.payload.team.TeamUpdateDto;
import me.bogeun.yajalal.port.outgoing.TeamPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TeamServicePortImplTest {

    @Mock
    TeamPersistencePort teamPersistencePort;

    @InjectMocks
    TeamServicePortImpl teamServicePort;

    TeamCreateDto createDto;
    Team team;
    Long teamId;

    @BeforeEach
    void beforeEach() {
        createDto = new TeamCreateDto();
        createDto.setName("test");
        createDto.setDescription("test.");
        createDto.setLimit(9);

        teamId = 1L;

        team = new Team();
        team.setId(teamId);
        team.setName(createDto.getName());
        team.setDescription(createDto.getDescription());
        team.setLimit(createDto.getLimit());
    }

    @Test
    void createTeam() {
        when(teamPersistencePort.createTeam(createDto)).thenReturn(team);

        Team result = teamServicePort.createTeam(createDto);

        assertEquals(teamId, result.getId());
        assertEquals("test", result.getName());
        assertEquals("test.", result.getDescription());
        assertEquals(9, result.getLimit());
    }

    @Test
    void getTeamById() {
        when(teamPersistencePort.getTeamById(teamId)).thenReturn(team);

        Team result = teamServicePort.getTeamById(teamId);

        assertEquals(teamId, result.getId());
        assertEquals("test", result.getName());
        assertEquals("test.", result.getDescription());
        assertEquals(9, result.getLimit());
    }

    @Test
    void updateTeam() {
        TeamUpdateDto updateDto = new TeamUpdateDto();
        updateDto.setName("update");
        updateDto.setDescription("update.");
        updateDto.setLimit(10);

        Team updatedTeam = new Team();
        updatedTeam.setId(teamId);
        updatedTeam.setName(updateDto.getName());
        updatedTeam.setDescription(updateDto.getDescription());
        updatedTeam.setLimit(updateDto.getLimit());

        when(teamPersistencePort.updateTeam(updateDto, teamId)).thenReturn(updatedTeam);

        Team result = teamServicePort.updateTeam(updateDto, teamId);

        assertEquals(teamId, result.getId());
        assertEquals(updateDto.getName(), result.getName());
        assertEquals(updateDto.getDescription(), result.getDescription());
        assertEquals(updateDto.getLimit(), result.getLimit());
    }

}