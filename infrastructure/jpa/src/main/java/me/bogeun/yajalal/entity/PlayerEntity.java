package me.bogeun.yajalal.entity;

import lombok.Getter;
import lombok.Setter;
import me.bogeun.yajalal.domain.Position;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    private TeamEntity team;

}
