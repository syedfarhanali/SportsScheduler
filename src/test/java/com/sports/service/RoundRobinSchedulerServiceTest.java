package com.sports.service;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.sports.entity.Event;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

/**
 * Created by farhans on 7/30/18.
 */
public class RoundRobinSchedulerServiceTest extends BaseTest {

    @Mock
    OrganizeEventService organizeEventService;

    @InjectMocks
    RoundRobinSchedulerServiceImpl roundRobinSchedulerService;

    @Test
    public void tesScheduleTournamentNull(){
        when(organizeEventService.organize(anyList())).thenReturn(schedule);
        assertNotNull(roundRobinSchedulerService.scheduleTournament(6,new Date()));
    }

    @Test
    public void tesScheduleTournamentEvents(){
        when(organizeEventService.organize(anyList())).thenReturn(schedule);
        assertEquals(schedule,roundRobinSchedulerService.scheduleTournament(6,new Date()));
    }


}
