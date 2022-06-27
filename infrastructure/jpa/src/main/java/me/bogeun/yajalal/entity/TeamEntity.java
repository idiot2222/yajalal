package me.bogeun.yajalal.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TEAM")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 10)
    private String name;

    @Column(name = "LIMIT_COUNT")
    private int limit;

    @Column(length = 50)
    private String description;

}
