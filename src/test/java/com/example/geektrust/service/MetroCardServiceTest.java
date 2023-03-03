package com.example.geektrust.service;

import com.example.geektrust.model.MetroCard;
import com.example.geektrust.model.Station;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MetroCardServiceTest {

    private MetroCardService metroCardService;
    @BeforeEach
    void setUp(){

        metroCardService = mock(MetroCardServiceImpl.class);
    }
    @Test
    void testAddBalanceToCard() {

        metroCardService.addBalanceToCard("1234567890", 100);
        verify(metroCardService).addBalanceToCard("1234567890",100);



    }


}