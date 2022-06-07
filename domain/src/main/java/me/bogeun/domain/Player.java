package me.bogeun.domain;

import lombok.Getter;
import lombok.Setter;
import me.bogeun.payload.player.PlayerUpdateDto;

@Getter
@Setter
public class Player {

    private Long id;

    private String name;
    private int length;
    private int weight;

    private Position position;

    private String description;

    public void updateInfo(PlayerUpdateDto updateDto) {
        int weight = updateDto.getWeight();
        int length = updateDto.getLength();
        String description = updateDto.getDescription();
        Position position = updateDto.getPosition();

        if(weight != 0) {
            this.weight = weight;
        }
        if(length != 0) {
            this.length = length;
        }
        if(description != null) {
            this.description = description;
        }
        if(position != null) {
            this.position = position;
        }
    }
}
