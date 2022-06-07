package me.bogeun.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private Long id;

    private String name;
    private int length;
    private int weight;

    private Position position;

    private String description;

}
