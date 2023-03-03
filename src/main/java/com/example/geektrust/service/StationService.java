package com.example.geektrust.service;

import com.example.geektrust.model.enums.PassengerType;
import com.example.geektrust.model.enums.StationName;

/**
 * Service for enabling the functioning of Station . This will have all the business logic of how Station will work.
 */
public interface StationService {

    /**
     * Add balance to MetroCard with given cardNumber
     * @param cardNumber cardNumber to add balance to
     * @param balance balance amount to be added to card
     */
    void addBalanceToCard(final String cardNumber,final Integer balance);

    /**
     * Check in ticket for passenger with metro card from given stationName.
     * @param cardNumber cardNumber to check in with
     * @param passengerType passengerType to calculate fair for passenger based on passengerType
     * @param stationName stationName to check out from
     */

    void checkInTicket(final String cardNumber, final PassengerType passengerType, final StationName stationName);

    /**
     * Print summary for all the stationNames available in StationName.java class
     */
    void printSummary();

}
