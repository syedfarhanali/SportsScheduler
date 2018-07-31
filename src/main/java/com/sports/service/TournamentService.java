package com.sports.service;

import com.sports.entity.Event;
import com.sports.entity.Tournament;
import com.sports.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by farhans on 7/26/18.
 */
@Service
public class TournamentService {

    @Autowired
    TournamentRepository tournamentRepository;

    @Autowired
    RoundRobinSchedulerServiceImpl schedulerService;

    @Autowired
    UserService userService;

    @Transactional
    public Tournament generateTournament(Integer teamCount, Date startDate){
        Map<Integer,List<Event>> schedule =  schedulerService.scheduleTournament(teamCount,startDate);
        Tournament t = new Tournament();
        t.setUser(userService.getCurrentUser());
        t  = tournamentRepository.save(t);
        t.updateDetails(schedule);
        t = tournamentRepository.save(t);
        return t;
    };

    @Transactional
    public Tournament getTournament(Integer tournamentId){
        Optional<Tournament> tournament =  tournamentRepository.findById(tournamentId);
        if(tournament.isPresent())
            return tournament.get();

        return null;
    }

}
