package com.sports.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by farhans on 7/26/18.
 */
@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "tournament",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    List<Event> events;

    String uniqueId;

    @Transient
    Map<Integer,List<Event>> schedule;

    public void  updateDetails(Map<Integer,List<Event>> schedule){
        List<Event> events = schedule.values().stream().filter(Objects::nonNull).flatMap(List::stream).collect(Collectors.toList());
        events.stream().forEach(event -> {event.setTournament(this);});
        this.setEvents(events);
        this.setUniqueId(String.valueOf(UUID.randomUUID()));
    }
}
