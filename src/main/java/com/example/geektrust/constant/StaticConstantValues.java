package com.example.geektrust.constant;

/*
*
*   StaticConstantValues : this class will contain all the constant values needed for this project at one place
*   purpose of this class is to minimize the use of magic variables and make project more maintainable
*
* */

public class StaticConstantValues {

    private StaticConstantValues(){

    }

    // defines minimum possible card balance
    public static final Integer MIN_POSSIBLE_METRO_CARD_BALANCE = 0;

    // defines min possible discount value
    public static final Integer MIN_POSSIBLE_DISCOUNT_AMOUNT = 0;

    // defines min possible discount percentage
    public static final Double MIN_POSSIBLE_DISCOUNT_PERCENTAGE = 0.5;  // 50%


    // defines minimum possible passenger count
    public static final Integer MIN_POSSIBLE_PASSENGER_COUNT = 0;

    // defines service fee on journey cost
    public static final Double SERVICE_FEE_PERCENTAGE = 0.02;   //2%

}
