package me.bogeun.payload.team;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamUpdateDto {

    private Long id;

    private String name;
    private int limit;
    private String description;

}
