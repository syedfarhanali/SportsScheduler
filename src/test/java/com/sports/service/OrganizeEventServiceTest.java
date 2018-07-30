package com.sports.service;

import com.sports.entity.Event;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by farhans on 7/30/18.
 */
public class OrganizeEventServiceTest extends BaseTest {

    @InjectMocks
    OrganizeEventService organizeEventService;

    @Test
    public void testOrganize(){
        assertEquals(schedule,organizeEventService.organize(events));
    }
}
