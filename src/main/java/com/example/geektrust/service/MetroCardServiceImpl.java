package com.example.geektrust.service;

import com.example.geektrust.model.MetroCard;
import com.example.geektrust.model.Station;

/**
 * Implementation of Service {@link MetroCardService}
 */
public class MetroCardServiceImpl implements MetroCardService {

    private final Station station;

    public MetroCardServiceImpl(Station station) {
        this.station = station;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addBalanceToCard(final String cardNumber, final Integer balance){
        if(station.isCardExists(cardNumber))
            station.getMetroCardMap().put(cardNumber,new MetroCard(cardNumber,station.getMetroCardMap().get(cardNumber).getCardBalance() + balance));
        else
            station.getMetroCardMap().put(cardNumber,new MetroCard(cardNumber,balance));


    }


}
