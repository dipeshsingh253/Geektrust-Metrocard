package com.example.geektrust.service;

import com.example.geektrust.constant.StaticConstantValues;
import com.example.geektrust.model.MetroCard;
import com.example.geektrust.model.Station;
import com.example.geektrust.model.enums.PassengerType;
import com.example.geektrust.model.enums.StationName;

/**
 * Implementation of Service {@link StationService}
 */
public class StationServiceImpl implements StationService{


    private final MetroCardService metroCardService;
    private final Station station;


    public StationServiceImpl(MetroCardService metroCardService,Station station){
        this.metroCardService = metroCardService;
        this.station = station;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addBalanceToCard(final String cardNumber,final Integer balance){
        metroCardService.addBalanceToCard(cardNumber,balance); // calling metroCard service from station service
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void checkInTicket(final String cardNumber, final PassengerType passengerType, final StationName stationName){



        MetroCard metroCard = station.getMetroCardMap().get(cardNumber);    // fetching metroCard
        metroCard.incrementTravelCount();   // incrementing travel count

        Integer journeyCost = passengerType.getValue(); // getting journey cost for passengerType from value
        Integer discount = StaticConstantValues.MIN_POSSIBLE_DISCOUNT_AMOUNT;

        // if it is a return journey
        if(metroCard.isReturnJourney()){
            discount = (int)(journeyCost*StaticConstantValues.MIN_POSSIBLE_DISCOUNT_PERCENTAGE);
            journeyCost = discount;
        }


        if (metroCard.getCardBalance() < journeyCost){
            journeyCost += (int) ((journeyCost - metroCard.getCardBalance()) * StaticConstantValues.SERVICE_FEE_PERCENTAGE);
            metroCard.setCardBalance(StaticConstantValues.MIN_POSSIBLE_METRO_CARD_BALANCE);
        }else {
            metroCard.setCardBalance(metroCard.getCardBalance() - journeyCost);
        }

        station.getStationPassengerMap().get(stationName).put(passengerType,
                station.getStationPassengerMap().get(stationName).getOrDefault(passengerType,StaticConstantValues.MIN_POSSIBLE_PASSENGER_COUNT) + 1);

        station.getStationNameRevenueMap().put(stationName,
                station.getStationNameRevenueMap().get(stationName)+journeyCost);

        station.getStationNameDiscountMap().put(stationName,
                station.getStationNameDiscountMap().get(stationName) + discount );

        station.getMetroCardMap().put(metroCard.getCardNumber(), metroCard);

    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void printSummary(){

        StationName[] stationNames = StationName.values();

        for (StationName stationName : stationNames)
            station.printSummary(stationName);

    }

}
