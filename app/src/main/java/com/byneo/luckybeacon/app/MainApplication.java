package com.byneo.luckybeacon.app;

import android.app.Application;

import com.byneo.beaconkeepersdk.service.BeaconService;

/**
 * Created by kaanh on 13.03.2016.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        BeaconService.onApplicationCreate(this);
    }
}
