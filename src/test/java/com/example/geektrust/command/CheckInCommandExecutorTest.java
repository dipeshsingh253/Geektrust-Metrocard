package com.example.geektrust.command;

import com.example.geektrust.model.Command;
import com.example.geektrust.model.enums.PassengerType;
import com.example.geektrust.model.enums.StationName;
import com.example.geektrust.service.StationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CheckInCommandExecutorTest {

    private StationService stationService;
    private CheckInCommandExecutor checkinCommandExecutor;
    @BeforeEach
    void setUp() {

        stationService = mock(StationService.class);
        checkinCommandExecutor = new CheckInCommandExecutor(stationService);

    }


    @Test
    void testValidCheckInCommand(){
        assertTrue(checkinCommandExecutor.validate(new Command("CHECK_IN MC1 ADULT CENTRAL")));
    }

    @Test
    void testInValidCheckInCommand(){
        assertFalse(checkinCommandExecutor.validate(new Command("CHECK_IN MC1 ADULT")));
        assertFalse(checkinCommandExecutor.validate(new Command("CHECK_IN MC1")));
        assertFalse(checkinCommandExecutor.validate(new Command("CHECK_IN")));
    }

    @Test
    void testCheckInCommandExecution(){
        checkinCommandExecutor.execute(new Command("CHECK_IN MC1 ADULT CENTRAL"));

        verify(stationService).checkInTicket("MC1", PassengerType.ADULT, StationName.CENTRAL);

    }

}