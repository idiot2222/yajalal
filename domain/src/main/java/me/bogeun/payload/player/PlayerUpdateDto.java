package me.bogeun.payload.player;

import lombok.Getter;
import lombok.Setter;
import me.bogeun.domain.Position;

@Getter
@Setter
public class PlayerUpdateDto {

    private int length;
    private int weight;

    private Position position;

    private String description;

}
