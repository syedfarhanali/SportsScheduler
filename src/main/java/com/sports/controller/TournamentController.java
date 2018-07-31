package com.sports.controller;

import com.sports.entity.Tournament;
import com.sports.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by farhans on 7/26/18.
 */
@RestController
@RequestMapping("/tournament")
public class TournamentController {

    @Autowired
    TournamentService tournamentService;

    @RequestMapping(method = RequestMethod.POST)
    public Tournament generateTournament(@RequestParam Integer teamCount,
                                       @RequestParam Date startDate,
                                         HttpSession session){
       return tournamentService.generateTournament(teamCount,startDate);
    }

    @RequestMapping(value = "/{tournamentId}", method = RequestMethod.GET)
    public Tournament getTournament(@PathVariable("tournamentId") Integer tournamentId){
        return tournamentService.getTournament(tournamentId);
    }


}
