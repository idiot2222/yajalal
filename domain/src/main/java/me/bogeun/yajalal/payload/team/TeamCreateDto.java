package me.bogeun.yajalal.payload.team;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamCreateDto {

    private String name;
    private int limit;
    private String description;

}
