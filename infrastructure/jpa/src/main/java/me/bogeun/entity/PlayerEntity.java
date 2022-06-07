package me.bogeun.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.bogeun.domain.Position;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
@Table(name = "PLAYER")
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 10)
    private String name;

    private int length;

    private int weight;

    @Column(length = 50)
    private String description;

    @Enumerated(EnumType.STRING)
    private Position position;

}
