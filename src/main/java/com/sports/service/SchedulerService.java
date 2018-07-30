package com.sports.service;

import com.sports.entity.Event;
import com.sports.entity.Tournament;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by farhans on 7/28/18.
 */
public interface SchedulerService {

    public Map<Integer,List<Event>> scheduleTournament(Integer teamCount, Date startDate);
}
