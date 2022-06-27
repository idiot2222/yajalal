package me.bogeun.yajalal.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Team {

    private Long id;

    private String name;
    private int limit;
    private String description;

}
