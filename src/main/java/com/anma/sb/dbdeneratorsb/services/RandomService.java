package com.anma.sb.dbdeneratorsb.services;

public interface RandomService {

    String getColor();
    String getCountryCode();
    String getOrigin();
    int getAge(int max);
    String getBody(int length);
    int getRandomSpeed();

    String getRegistry();
}
