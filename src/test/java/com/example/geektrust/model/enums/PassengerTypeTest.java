package com.example.geektrust.model.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTypeTest {

    @Test
    void testAdultPassengerTypeValue() {
        assertEquals(Integer.valueOf(200), PassengerType.ADULT.getValue());
    }

    @Test
    void testSeniorCitizenPassengerTypeValue() {
        assertEquals(Integer.valueOf(100), PassengerType.SENIOR_CITIZEN.getValue());
    }

    @Test
    void testKidPassengerTypeValue() {
        assertEquals(Integer.valueOf(50), PassengerType.KID.getValue());
    }

}