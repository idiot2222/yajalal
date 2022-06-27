package me.bogeun.yajalal.controller;

import lombok.RequiredArgsConstructor;
import me.bogeun.yajalal.domain.Team;
import me.bogeun.yajalal.payload.team.TeamCreateDto;
import me.bogeun.yajalal.payload.team.TeamUpdateDto;
import me.bogeun.yajalal.port.incoming.TeamServicePort;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/team")
public class TeamApiController {

    private final TeamServicePort teamServicePort;

    @PostMapping("/create")
    public String createTeam(@RequestBody TeamCreateDto createDto) {
        teamServicePort.createTeam(createDto);

        return "ok";
    }

    @GetMapping("/info/{teamId}")
    public Team teamInfo(@PathVariable Long teamId) {
        return teamServicePort.getTeamById(teamId);
    }

    @PostMapping("/update/{teamId}")
    public String updateTeamInfo(@PathVariable Long teamId,
                                 @RequestBody TeamUpdateDto updateDto) {

        teamServicePort.updateTeam(updateDto, teamId);

        return "ok";
    }

    @PostMapping("/delete/{teamId}")
    public String deleteTeam(@PathVariable Long teamId) {
        try {
            teamServicePort.deleteTeam(teamId);
        } catch (IllegalArgumentException e) {
            return "error";
        }

        return "ok";
    }
}
