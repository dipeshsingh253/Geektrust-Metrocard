package com.example.geektrust.model.enums;

/**
 * This Enum class keeps record of all the PassengerType for this project with their corresponding journey cost as their value
 */


public enum PassengerType {

    ADULT(200),
    SENIOR_CITIZEN(100),
    KID(50);

    private final Integer value;

    private PassengerType(Integer value){
        this.value = value;
    }

    public Integer getValue(){
        return this.value;
    }
}
