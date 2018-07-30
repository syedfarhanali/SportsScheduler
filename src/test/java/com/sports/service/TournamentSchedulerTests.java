package com.sports.service;

import com.sports.entity.Event;
import com.sports.entity.Tournament;
import com.sports.repository.TournamentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by farhans on 7/29/18.
 */
public class TournamentSchedulerTests extends BaseTest{

    @Mock
    RoundRobinSchedulerServiceImpl schedulerService;

    @Mock
    TournamentRepository tournamentRepository;

    @InjectMocks
    TournamentService tournamentService;

    @Test
    public void testGenerateTournament(){
        Map schedule = new HashMap<Integer,List< Event >>();
        Tournament t = new Tournament();
        t.setId(1);
        when(schedulerService.scheduleTournament(teamCount,date)).thenReturn(schedule);
        when(tournamentRepository.save(any(Tournament.class))).thenReturn(t);

        assertNotNull(tournamentService.generateTournament(teamCount,date));
        verify(schedulerService, times(1)).scheduleTournament(teamCount,date);

       assertEquals(t, tournamentService.generateTournament(teamCount,date));
    }

    @Test
    public void testGetTournament(){
        when(tournamentRepository.findById(any(Integer.class))).thenReturn(Optional.of(new Tournament()));
        assertNotNull(tournamentService.getTournament(1));
    }
}
