package com.example.smartgreenhouse.model;

public class StatisticItem {
    private String parameterName;
    private String parameterMean;

    public StatisticItem(String parameterName, String parameterMean){
        this.parameterName = parameterName;
        this.parameterMean = parameterMean;
    }

    public String getParameterName() {
        return parameterName;
    }

    public String getParameterMean() {
        return parameterMean;
    }

}
