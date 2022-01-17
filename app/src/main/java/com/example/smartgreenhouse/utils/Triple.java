package com.example.smartgreenhouse.utils;

public class Triple {

    private final String first;
    private final String second;
    private final String third;

    public Triple(String first, String second, String third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public String getFirst() { return first; }
    public String getSecond() { return second; }
    public String getThird() { return third; }
}
