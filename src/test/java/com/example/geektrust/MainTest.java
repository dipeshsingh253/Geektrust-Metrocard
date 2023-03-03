package com.example.geektrust;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;

class MainTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testInputCommand() throws FileNotFoundException {

        final String expectedOutput = "TOTAL_COLLECTION CENTRAL 457 50\n" +
                "PASSENGER_TYPE_SUMMARY\n" +
                "ADULT 2\n" +
                "SENIOR_CITIZEN 1\n" +
                "TOTAL_COLLECTION AIRPORT 252 100\n" +
                "PASSENGER_TYPE_SUMMARY\n" +
                "ADULT 1\n" +
                "KID 1\n" +
                "SENIOR_CITIZEN 1\n";

        Main.main(new String[]{"sample_input/input2.txt"});
        assertEquals(expectedOutput,outputStream.toString());

    }

}