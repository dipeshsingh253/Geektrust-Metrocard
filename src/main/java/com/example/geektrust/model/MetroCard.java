package com.example.geektrust.model;

/**
 * MetroCard : Model object to display functioning of MetroCard
 */
public class MetroCard {

    private final String cardNumber;
    private Integer cardBalance;

    private Integer travelCount;
    public MetroCard(String cardNumber,Integer cardBalance){
        this.cardBalance= cardBalance;
        this.cardNumber = cardNumber;
        this.travelCount = 0;
    }


    /**
     * This method will increment the travel count for MetroCard by 1.
     */
    public void incrementTravelCount(){
        this.travelCount++;
    }

    /**
     * This method checks if the journey is a return journey using this metro card
     * @return Boolean value true if its a return journey else false
     */
    public boolean isReturnJourney(){
        return this.travelCount % 2 == 0 && this.travelCount != 0;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public Integer getCardBalance() {
        return cardBalance;
    }

    public Integer getTravelCount() {
        return travelCount;
    }

    public void setCardBalance(Integer cardBalance) {
        this.cardBalance = cardBalance;
    }
}
