package com.sports.service;

import com.sports.entity.Event;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by farhans on 7/29/18.
 */
@Service
public class OrganizeEventService {


    public Map<Integer,List<Event>> organize(List<Event> allEvents){

        Map<Integer,List<Event>> schedule = new HashMap<Integer,List<Event>>();

        List<Integer> currentDayTeams = new ArrayList<>();
        List<Integer> previousDayTeams = new ArrayList<>();

        int iteration=0;
        int day = 1;

        while( iteration < allEvents.size()){

            Integer team1 = allEvents.get(iteration).getFirstTeam();
            Integer team2 = allEvents.get(iteration).getSecondTeam();


            Boolean inCurrentDayTeams = !currentDayTeams.isEmpty() && (currentDayTeams.contains(team1) || currentDayTeams.contains(team2) );
            Boolean inPreviousDayTeams = !previousDayTeams.isEmpty() && (previousDayTeams.contains(team1) || previousDayTeams.contains(team2) );

            if(inPreviousDayTeams){
                if(currentDayTeams.isEmpty()){
                    schedule.put(day,null);
                }
                ++day;
                allEvents.get(iteration).setDay(day);
                schedule.put(day, new ArrayList<>(Arrays.asList(allEvents.get(iteration))));
                previousDayTeams.clear();
                previousDayTeams.addAll(currentDayTeams);
                currentDayTeams.clear();
                currentDayTeams.add(team1);
                currentDayTeams.add(team2);
            }else if(inCurrentDayTeams){
                schedule.put(day,null);
                day = day + 2;
                allEvents.get(iteration).setDay(day);
                schedule.put(day, new ArrayList<>(Arrays.asList(allEvents.get(iteration))));
                previousDayTeams.clear();
                currentDayTeams.clear();
                currentDayTeams.add(team1);
                currentDayTeams.add(team2);
            }else{
                if(Objects.nonNull(schedule.get(day))){
                    allEvents.get(iteration).setDay(day);
                    schedule.get(day).add(allEvents.get(iteration));
                    schedule.put(day,schedule.get(day)) ;
                    previousDayTeams.clear();
                    previousDayTeams.addAll(currentDayTeams);
                    previousDayTeams.add(team1);
                    previousDayTeams.add(team2);
                    currentDayTeams.clear();
                    ++day;
                }else{
                    allEvents.get(iteration).setDay(day);
                    schedule.put(day, new ArrayList<>(Arrays.asList(allEvents.get(iteration))));
                    currentDayTeams.add(team1);
                    currentDayTeams.add(team2);
                }
            }
            iteration++ ;
        }

        return schedule;
    }


}
