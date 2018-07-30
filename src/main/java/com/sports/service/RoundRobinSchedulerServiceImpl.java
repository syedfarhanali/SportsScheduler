package com.sports.service;

import com.sports.entity.Event;
import com.sports.entity.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.*;

/**
 * Created by farhans on 7/28/18.
 */
@Service
public class RoundRobinSchedulerServiceImpl implements SchedulerService{

    @Autowired
    OrganizeEventService organizeEventService;

    @Override
    public Map<Integer,List<Event>> scheduleTournament(Integer teamCount, Date startDate){
        int[] teamList =  lineupInitialTeams(teamCount);
        List<Event> allEvents = generateEvents(teamList);
        return organizeEventService.organize(allEvents);
    }


    private List<Event> generateEvents(int[] teamList){
        List<Event> matches = new ArrayList<Event>();
        List<Event> flipMatches = new ArrayList<Event>();
        Integer teamCount = teamList.length;

        int totalMatches =  teamCount * (teamCount -1) ; //30
        int matchesInEachRound = teamCount/2;
        int totalRounds = totalMatches / matchesInEachRound ;
        int halfRound = totalRounds /2 ;

        for(int i = 1 ; i <= halfRound ; i++){
            for(int j = 0; j < teamCount/2 ; j++){
                matches.add(new Event(teamList[j],teamList[teamCount -1 -j]));
                flipMatches.add(new Event(teamList[teamCount -1 -j], teamList[j]));
            }
            int temp = teamList[1];

            for(int k=1 ; k< teamCount-1 ; k++){
                int temp2 = teamList[k+1];
                teamList[k+1] = temp;
                temp = temp2;
            }
            teamList[1] = temp;
        }

        matches.addAll(flipMatches);
        return matches;
    };

    private int[] lineupInitialTeams(Integer teamCount){
        int [] teams = new int[teamCount];
        int halfTeam = teamCount/2;
        for(int i=0 ; i < halfTeam ; i++){
            teams[i] = i + 1;
            teams[teamCount - i - 1] =  halfTeam + i + 1;
        }
        teams[halfTeam] = teamCount;
        return teams;
    };

}
