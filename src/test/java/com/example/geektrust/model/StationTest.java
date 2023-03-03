package com.example.geektrust.model;

import com.example.geektrust.model.enums.PassengerType;
import com.example.geektrust.model.enums.StationName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {

    private Station station;
    @BeforeEach
    void setUp() {
        station = new Station();
    }

    @Test
    void testGetters() {
        assertNotNull(station.getMetroCardMap());
        assertNotNull(station.getStationNameDiscountMap());
        assertNotNull(station.getStationNameRevenueMap());
        assertNotNull(station.getStationPassengerMap());
    }

    @Test
    void testPrintSummary() {
        StationName stationName = StationName.AIRPORT;
        Map<PassengerType, Integer> passengerMap = new EnumMap<>(PassengerType.class);
        passengerMap.put(PassengerType.ADULT, 10);
        passengerMap.put(PassengerType.KID, 5);
        passengerMap.put(PassengerType.SENIOR_CITIZEN, 3);

        Map<StationName, Integer> revenueMap = new EnumMap<>(StationName.class);
        revenueMap.put(stationName, 100);

        Map<StationName, Integer> discountMap = new EnumMap<>(StationName.class);
        discountMap.put(stationName, 50);


        station.getStationPassengerMap().put(stationName, passengerMap);
        station.getStationNameRevenueMap().putAll(revenueMap);
        station.getStationNameDiscountMap().putAll(discountMap);

        String expected = "TOTAL_COLLECTION AIRPORT 100 50\n" +
                "PASSENGER_TYPE_SUMMARY\n" +
                "ADULT 10\n" +
                "KID 5\n" +
                "SENIOR_CITIZEN 3\n";

        assertEquals(expected, getPrintSummaryOutput(stationName));
    }

    private String getPrintSummaryOutput(StationName stationName) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        station.printSummary(stationName);

        String output = byteArrayOutputStream.toString();

        System.setOut(System.out);

        return output;
    }


}