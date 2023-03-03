package com.example.geektrust.service;


/**
 * Service for enabling the functioning of MetroCard. This will have all the business logic of how metro card will work.
 */

public interface MetroCardService {

    /**
     * This method will add balance to metro card for given card number. Card does not exist with given card number then it will create a new metro card with given card number
     * @param cardNumber cardNumber to add balance to
     * @param balance balance amount to add to card
     */
    void addBalanceToCard(final String cardNumber, final Integer balance);

}
