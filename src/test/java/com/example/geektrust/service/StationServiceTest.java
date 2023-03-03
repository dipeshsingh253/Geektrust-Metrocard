package com.example.geektrust.service;

import com.example.geektrust.model.MetroCard;
import com.example.geektrust.model.Station;
import com.example.geektrust.model.enums.PassengerType;
import com.example.geektrust.model.enums.StationName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class StationServiceTest {

    private final String CARD_NUMBER = "1234";
    private final Integer CARD_BALANCE = 500;
    private final PassengerType PASSENGER_TYPE = PassengerType.ADULT;
    private final StationName STATION_NAME = StationName.AIRPORT;

    private MetroCardService metroCardService;
    private Station station;
    private StationService stationService;


    @BeforeEach
    void setUp() {
        station = new Station();
        metroCardService = new MetroCardServiceImpl(station);
        stationService = new StationServiceImpl(metroCardService, station);
    }

    @Test
    void testAddBalanceToCard() {
        stationService.addBalanceToCard(CARD_NUMBER, CARD_BALANCE);

        MetroCard metroCard = station.getMetroCardMap().get(CARD_NUMBER);
        assertNotNull(metroCard);
        assertEquals(CARD_NUMBER, metroCard.getCardNumber());
        assertEquals(CARD_BALANCE, metroCard.getCardBalance());
        assertEquals(0, metroCard.getTravelCount());
        assertFalse(metroCard.isReturnJourney());

        //first journey
        metroCard.incrementTravelCount();
        //return journey
        metroCard.incrementTravelCount();

        assertTrue(metroCard.isReturnJourney());

    }

    @Test
    void testCheckInTicket() {
        station.getMetroCardMap().put(CARD_NUMBER, new MetroCard(CARD_NUMBER, CARD_BALANCE));

        stationService.checkInTicket(CARD_NUMBER, PASSENGER_TYPE, STATION_NAME);

        MetroCard metroCard = station.getMetroCardMap().get(CARD_NUMBER);
        // verify card details
        assertEquals(1, metroCard.getTravelCount());
        assertFalse(metroCard.isReturnJourney());
        assertEquals(Integer.valueOf(CARD_BALANCE - PASSENGER_TYPE.getValue()), metroCard.getCardBalance());

        // verify passenger details
        assertEquals(1, station.getStationPassengerMap().get(STATION_NAME).get(PASSENGER_TYPE));

    }

    @Test
    void testPrintSummary() {
        // Set up test data
        stationService.addBalanceToCard(CARD_NUMBER,600);
        stationService.checkInTicket(CARD_NUMBER,PASSENGER_TYPE,STATION_NAME);

        // Call the method being tested
        stationService.printSummary();

        String expected = "TOTAL_COLLECTION CENTRAL 0 0\n"+
                "PASSENGER_TYPE_SUMMARY\n" +
                "TOTAL_COLLECTION AIRPORT 200 0\n" +
                "PASSENGER_TYPE_SUMMARY\n" +
                "ADULT 1\n" ;


        assertEquals(expected,getPrintSummaryOutput());

    }

    private String getPrintSummaryOutput() {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        for (StationName stationName : StationName.values())
            station.printSummary(stationName);

        String output = byteArrayOutputStream.toString();

        System.setOut(System.out);

        return output;
    }



}