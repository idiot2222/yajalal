package me.bogeun.yajalal.payload.player;

import lombok.Getter;
import lombok.Setter;
import me.bogeun.yajalal.domain.Position;

@Getter
@Setter
public class PlayerUpdateDto {

    private int length;
    private int weight;

    private Position position;

    private String description;

}
