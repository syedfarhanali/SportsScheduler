package com.sports.service;

import com.sports.entity.Event;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by farhans on 7/30/18.
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class BaseTest {

    Map<Integer,List<Event>> schedule =  new HashMap<Integer,List<Event>>();

    List<Event> events =  new ArrayList<Event>();

    Integer teamCount = 6;
    Date date = new Date();

    @Before
    public void setUp() {
        Event event1 = new Event(1,4);
        Event event2 = new Event(2,5);
        Event event3 = new Event(3,6);
        Event event4 = new Event(1,5);
        Event event5 = new Event(4,6);
        Event event6 = new Event(2,3);
        Event event7 = new Event(1,6);
        Event event8 = new Event(5,3);
        Event event9 = new Event(4,2);
        Event event10 = new Event(1,3);
        Event event11 = new Event(6,2);
        Event event12 = new Event(5,4);
        Event event13 = new Event(1,2);
        Event event14 = new Event(3,4);
        Event event15 = new Event(6,5);

        Event event16 = new Event(4,1);
        Event event17 = new Event(5,2);
        Event event18 = new Event(6,3);
        Event event19 = new Event(5,1);
        Event event20 = new Event(6,4);
        Event event21 = new Event(3,2);
        Event event22 = new Event(6,1);
        Event event23 = new Event(3,5);
        Event event24 = new Event(2,4);
        Event event25 = new Event(3,1);
        Event event26 = new Event(2,6);
        Event event27 = new Event(4,5);
        Event event28 = new Event(2,1);
        Event event29 = new Event(4,3);
        Event event30 = new Event(5,6);

        events.addAll(Arrays.asList(event1,event2,event3,event4,event5,event6,event7,event8,event9,event10,event11,
                event12,event13,event14,event15,event16,event17,event18,event19,event20,event21,event22,event23,event24,event25,
                event26,event27,event28,event29,event30));

        schedule.put(1, new ArrayList<>(Arrays.asList(event1,event2)));
        schedule.put(2, new ArrayList<>(Arrays.asList(event3)));
        schedule.put(3, new ArrayList<>(Arrays.asList(event4)));
        schedule.put(4, new ArrayList<>(Arrays.asList(event5,event6)));

        schedule.put(6, new ArrayList<>(Arrays.asList(event7,event8)));
        schedule.put(7, new ArrayList<>(Arrays.asList(event9)));
        schedule.put(8, new ArrayList<>(Arrays.asList(event10)));
        schedule.put(9, new ArrayList<>(Arrays.asList(event11,event12)));

        schedule.put(11, new ArrayList<>(Arrays.asList(event13,event14)));
        schedule.put(12, new ArrayList<>(Arrays.asList(event15)));
        schedule.put(13, new ArrayList<>(Arrays.asList(event16)));
        schedule.put(14, new ArrayList<>(Arrays.asList(event17,event18)));

        schedule.put(16, new ArrayList<>(Arrays.asList(event19,event20)));
        schedule.put(17, new ArrayList<>(Arrays.asList(event21)));
        schedule.put(18, new ArrayList<>(Arrays.asList(event22)));
        schedule.put(19, new ArrayList<>(Arrays.asList(event23,event24)));

        schedule.put(21, new ArrayList<>(Arrays.asList(event25,event26)));
        schedule.put(22, new ArrayList<>(Arrays.asList(event27)));
        schedule.put(23, new ArrayList<>(Arrays.asList(event28)));
        schedule.put(24, new ArrayList<>(Arrays.asList(event29,event30)));

        schedule.put(5, null);
        schedule.put(10, null);
        schedule.put(15, null);
        schedule.put(20, null);

    }
}
