package com.example.geektrust.command;

import com.example.geektrust.model.Command;
import com.example.geektrust.service.StationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PrintSummaryCommandExecutorTest {


    private StationService stationService;

    private PrintSummaryCommandExecutor printSummaryCommandExecutor;

    @BeforeEach
    void setUp() {
        stationService = mock(StationService.class);
        printSummaryCommandExecutor = new PrintSummaryCommandExecutor(stationService);
    }

    @Test
    void testValidPrintSummaryCommand(){

        assertTrue(printSummaryCommandExecutor.validate(new Command("PRINT_SUMMARY")));

    }

    @Test
    void testInValidPrintSummaryCommand(){
        assertFalse(printSummaryCommandExecutor.validate(new Command("PRINT_SUMMARY AIRPORT")));
    }


    @Test
    void testPrintSummaryCommandExecution(){
        printSummaryCommandExecutor.execute(new Command("PRINT_SUMMARY"));
        verify(stationService).printSummary();
    }

}