package com.example.smartgreenhouse.application;

import android.app.Application;

import com.example.smartgreenhouse.model.Client;

public class SmartGreenhouse extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Client.getSharedInstance().setRequestQueue(this);
    }
}
