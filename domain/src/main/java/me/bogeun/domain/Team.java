package me.bogeun.domain;

import me.bogeun.payload.team.TeamUpdateDto;

public class Team {

    private Long id;

    private String name;
    private int limit;
    private String description;

    public void update(TeamUpdateDto updateDto) {
        String description = updateDto.getDescription();
        int limit = updateDto.getLimit();

        if(description != null) {
            this.description = description;
        }
        if(limit != 0) {
            this.limit = limit;
        }
    }
}
