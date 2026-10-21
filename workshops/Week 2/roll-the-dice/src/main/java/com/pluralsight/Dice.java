package com.pluralsight;

public class Dice {


    public int roll() {
        int minValue = 1;
        int maxValue = 6;
        int randomNumber = (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
        return randomNumber;
    }
}