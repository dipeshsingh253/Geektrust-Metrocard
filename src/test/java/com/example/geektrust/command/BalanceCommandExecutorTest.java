package com.example.geektrust.command;

import com.example.geektrust.model.Command;
import com.example.geektrust.service.StationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BalanceCommandExecutorTest {


    private StationService stationService;
    private BalanceCommandExecutor balanceCommandExecutor;
    @BeforeEach
    void setUp() {

        stationService = mock(StationService.class);
        balanceCommandExecutor = new BalanceCommandExecutor(stationService);
    }

    @Test
    void testValidBalanceCommand(){
        assertTrue(balanceCommandExecutor.validate(new Command("BALANCE METRO_CARD_NUMBER 600")));
    }

    @Test
    void testInValidBalanceCommand(){
        assertFalse(balanceCommandExecutor.validate(new Command("BALANCE METRO_CARD_NUMBER")));
        assertFalse(balanceCommandExecutor.validate(new Command("BALANCE 600")));

    }

    @Test
    void testValidBalanceCommandExecution(){
        balanceCommandExecutor.execute(new Command("BALANCE METRO_CARD_NUMBER 600"));
        verify(stationService).addBalanceToCard("METRO_CARD_NUMBER",600);
    }

}