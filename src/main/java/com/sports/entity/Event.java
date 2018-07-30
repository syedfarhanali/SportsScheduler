package com.sports.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by farhans on 7/26/18.
 */
@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    Integer firstTeam;

    @Column(nullable = false)
    Integer secondTeam;

    @Column(nullable = false)
    Integer day;

    Date date;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id")
    Tournament tournament;

    public Event(int firstTeam, int secondTeam){
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

}