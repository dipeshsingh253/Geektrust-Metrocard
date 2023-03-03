package com.example.geektrust.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MetroCardTest {

    @Test
    void testMetroCardCreation() {
        String cardNumber = "1234";
        int cardBalance = 50;
        MetroCard metroCard = new MetroCard(cardNumber, cardBalance);

        assertEquals(cardNumber, metroCard.getCardNumber());
        assertEquals(cardBalance, (int)metroCard.getCardBalance());
        assertEquals(0, (int)metroCard.getTravelCount());
    }

    @Test
    void testIncrementTravelCount() {
        String cardNumber = "1234";
        int cardBalance = 50;
        MetroCard metroCard = new MetroCard(cardNumber, cardBalance);

        metroCard.incrementTravelCount();
        metroCard.incrementTravelCount();
        metroCard.incrementTravelCount();

        assertEquals(3, (int)metroCard.getTravelCount());
    }

    @Test
    void testIsReturnJourney() {
        String cardNumber = "1234";
        int cardBalance = 50;
        MetroCard metroCard = new MetroCard(cardNumber, cardBalance);

        metroCard.incrementTravelCount();
        assertFalse(metroCard.isReturnJourney());

        metroCard.incrementTravelCount();
        assertTrue(metroCard.isReturnJourney());

        metroCard.incrementTravelCount();
        assertFalse(metroCard.isReturnJourney());
    }

    @Test
    void testSetCardBalance() {
        String cardNumber = "1234";
        int cardBalance = 50;
        MetroCard metroCard = new MetroCard(cardNumber, cardBalance);

        metroCard.setCardBalance(100);

        assertEquals(100, (int)metroCard.getCardBalance());
    }

}