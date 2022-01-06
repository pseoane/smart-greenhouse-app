package com.example.smartgreenhouse.model;

public class SensorItems {
    private String sensorName;
    private String currentValue;
    SensorItems(String sensorName, String currentValue){
        this.sensorName = sensorName;
        this.currentValue = currentValue;
    }
    public String getSensorName(){return sensorName;}
    public String getCurrentValue(){return currentValue;}

}
