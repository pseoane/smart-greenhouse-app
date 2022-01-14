package com.example.smartgreenhouse.model;

public class ActuatorItem {
    private String actuatorName;
    private String currentStatus;
    public ActuatorItem(String actuatorName, String currentStatus){
        this.actuatorName = actuatorName;
        this.currentStatus = currentStatus;
    }
    public String getActuatorName(){return actuatorName;}
    public String getCurrentStatus(){return currentStatus;}

}
