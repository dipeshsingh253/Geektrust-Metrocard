package com.example.geektrust.model;

import com.example.geektrust.exception.NoStationNamesAvailableException;
import com.example.geektrust.model.enums.PassengerType;
import com.example.geektrust.model.enums.StationName;

import java.util.*;
import static java.util.stream.Collectors.toMap;

/**
 * Station : Model object to display functioning of Station
 */
public class Station {
    // keep record of all the MetroCards
    private Map<String,MetroCard> metroCardMap;

    // keep record of passengers count group by PassengerType for all the StationNames
    private final Map<StationName,Map<PassengerType,Integer>> stationPassengerMap;

    // keep record of StationName and total revenue generated by that Station
    private final Map<StationName,Integer> stationNameRevenueMap;

    // keep record of StationName and total discount provided by that Station
    private final Map<StationName,Integer> stationNameDiscountMap;

    /**
     * Constructor : This is one and only constructor described for Station class. This will initialize all variables for every instance of Station class.
     *
     */
    public Station(){
        // initializing values
        this.metroCardMap = new HashMap<>();
        this.stationPassengerMap = new EnumMap<>(StationName.class);
        this.stationNameRevenueMap = new EnumMap<>(StationName.class);
        this.stationNameDiscountMap = new EnumMap<>(StationName.class);

        StationName[] stationNames = StationName.values();

        // if no StationName available in StationName.java file
        if (stationNames.length == 0)
            throw new NoStationNamesAvailableException("No station name available");

        // adding default values to stationPassengerMap,  stationNameDiscountMap, stationNameRevenueMap
        for (StationName stationName : stationNames){
            this.stationPassengerMap.put(stationName,new EnumMap<>(PassengerType.class));
            this.stationNameDiscountMap.put(stationName,0);
            this.stationNameRevenueMap.put(stationName,0);
        }

    }

    /**
     * This print summary for given StationName
     * @param stationName StationName to print summary
     */
    public void printSummary(StationName stationName){

        System.out.println("TOTAL_COLLECTION " + stationName + " " + stationNameRevenueMap.get(stationName) + " " + stationNameDiscountMap.get(stationName));
        System.out.println("PASSENGER_TYPE_SUMMARY");

        Map<PassengerType,Integer> sortedMap = stationPassengerMap.get(stationName)
                .entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    int result = o2.getValue().compareTo(o1.getValue());

                    if (result == 0)
                        return o1.getKey().name().compareTo(o2.getKey().name());

                    return result;
                })
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap :: new));

        sortedMap.forEach(((passengerType, integer) -> System.out.println(passengerType+" "+integer)));
    }

    /**
     * This method will check if MetroCard with given metroCardNumber exists or not
     * @param metroCardNumber cardNumber to check
     * @return Boolean true if MetroCard with given metroCardNumber exists else false
     */
    public boolean isCardExists(String metroCardNumber){
        return metroCardMap.containsKey(metroCardNumber);
    }

    public Map<String, MetroCard> getMetroCardMap() {
        return metroCardMap;
    }

    public Map<StationName, Integer> getStationNameDiscountMap() {
        return stationNameDiscountMap;
    }

    public Map<StationName, Integer> getStationNameRevenueMap() {
        return stationNameRevenueMap;
    }

    public Map<StationName, Map<PassengerType, Integer>> getStationPassengerMap() {
        return stationPassengerMap;
    }

}
