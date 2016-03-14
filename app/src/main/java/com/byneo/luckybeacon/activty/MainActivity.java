package com.byneo.luckybeacon.activty;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.byneo.beaconkeepersdk.content.BeaconEntity;
import com.byneo.beaconkeepersdk.receiver.BeaconReceiver;
import com.byneo.luckybeacon.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    protected BeaconReceiver mBeaconReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.list);
        txt.setText("");

        mBeaconReceiver = new BeaconReceiver() {
            @Override
            protected void onFoundBeacon(Context ctx, final BeaconEntity beaconEntity) {
                Log.d("TEST", beaconEntity.getIBeacon().toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txt.append(beaconEntity.getBluetoothDevice().getName() + "\n" + beaconEntity.getUuid() + "\n\n");
                    }
                });
            }
        };
    }


    @Override
    protected void onStart() {
        super.onStart();

        mBeaconReceiver.register(this);
    }


    @Override
    protected void onStop() {
        super.onStop();

        mBeaconReceiver.unregister(this);
    }
}
