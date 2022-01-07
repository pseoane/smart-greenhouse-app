package com.example.smartgreenhouse.model;

public class SensorItem {
    private String sensorName;
    private String currentValue;
    public SensorItem(String sensorName, String currentValue){
        this.sensorName = sensorName;
        this.currentValue = currentValue;
    }
    public String getSensorName(){return sensorName;}
    public String getCurrentValue(){return currentValue;}

}
