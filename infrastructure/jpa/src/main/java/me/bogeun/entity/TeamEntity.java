package me.bogeun.entity;

import javax.persistence.*;

@Entity
@Table(name = "TEAM")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 10)
    private String name;

    private int limit;

    @Column(length = 50)
    private String description;

}
