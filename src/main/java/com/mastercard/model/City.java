package com.mastercard.model;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class City {

    private static Map<String, Set<String>> cityMap;

    static {
        loadCityData();
    }

    private static void loadCityData() {
        String dataFileName= "src/main/resources/city_data.txt";
        cityMap = new HashMap<>();
        try(Stream<String> dataStream = Files.lines(Paths.get(dataFileName))){
            dataStream.forEach(cityDataLine -> mapConnectedCityData(cityDataLine));
        } catch (IOException e) {
            // Log Error
        }
    }

    private static void mapConnectedCityData(String cityDataLine) {
        if(StringUtils.isNotEmpty(cityDataLine)){
            String[] cityArray = cityDataLine.split(",");
            if (cityArray.length==2){
               String origin = cityArray[0];
               String destination = cityArray[1];
               if(StringUtils.isNotEmpty(origin) && StringUtils.isNotEmpty(destination)){
                   // Removing white space and changing to upper case before loading data to map from both origin and destination
                   origin = origin.trim().toUpperCase();
                   destination = destination.trim().toUpperCase();
                   // Load Data : origin as origin and destination as destination
                   loadMap(origin , destination);
                   // Load Data : destination as origin and origin as destination
                   loadMap(destination , origin);
               }
            }else{
                // Log Error for data corrupted
            }
        }
    }

    private static void loadMap(String origin, String destination) {
        Set<String> connectedCities = cityMap.get(origin);
        if (CollectionUtils.isEmpty(connectedCities)) {
            connectedCities = new HashSet<>();
        }
        connectedCities.add(destination);
        cityMap.put(origin, connectedCities);
    }

    public static boolean isCityConnected(String origin, String destination) {
        Set<String> connectedCities = cityMap.get(origin);
        return CollectionUtils.isNotEmpty(connectedCities) && connectedCities.contains(destination);
    }
}
