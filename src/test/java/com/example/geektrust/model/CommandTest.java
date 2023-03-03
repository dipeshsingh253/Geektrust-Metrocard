package com.example.geektrust.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void testCommandCreation() {
        String inputLine = "BALANCE card123 50";
        Command command = new Command(inputLine);

        assertEquals("BALANCE", command.getCommandName());
        assertEquals(2, command.getParams().size());
        assertEquals("card123", command.getParams().get(0));
        assertEquals("50", command.getParams().get(1));
    }

    @Test
    void testCommandCreationWithExtraSpaces() {
        String inputLine = "   BALANCE   card123   50   ";
        Command command = new Command(inputLine);

        assertEquals("BALANCE", command.getCommandName());
        assertEquals(2, command.getParams().size());
        assertEquals("card123", command.getParams().get(0));
        assertEquals("50", command.getParams().get(1));
    }

    @Test
    void testCommandCreationWithNoParams() {
        String inputLine = "PRINT_SUMMARY";
        Command command = new Command(inputLine);

        assertEquals("PRINT_SUMMARY", command.getCommandName());
        assertEquals(0, command.getParams().size());
    }


}