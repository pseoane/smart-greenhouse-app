package com.example.smartgreenhouse.model;

import android.widget.LinearLayout;

public class SensorItem {
    private String sensorName;
    private String currentValue;
    private String alarmStatus;

    public SensorItem(String sensorName, String currentValue, String alarmStatus){
        this.sensorName = sensorName;
        this.currentValue = currentValue;
        this.alarmStatus = alarmStatus;
    }

    public String getSensorName() {
        return sensorName;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public String getCurrentBackground(){
        return alarmStatus;
    }

    public void setAlarmStatus(String newStatus) {
        alarmStatus = newStatus;
    }
}
