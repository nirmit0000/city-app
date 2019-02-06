package com.mastercard.service;

import com.mastercard.model.City;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements ICityService{
    @Override
    public boolean isCityConnected(String origin, String destination) {
        return City.isCityConnected(origin.toUpperCase() , destination.toUpperCase());
    }
}
