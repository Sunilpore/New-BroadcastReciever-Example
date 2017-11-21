package com.example.sunil.broadcastreciever_12;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

/**
 * Created by Sunil on 11/19/2017.
 */

public class Networkstatus extends BroadcastReceiver {

    private static final String ActA = "register_via_activity_A";


    @Override
    public void onReceive(Context context, Intent intent) {

        String status=MainActivity.getConnectivityStatusString(context);

        Snackbar.make(MainActivity.cordl,status,Snackbar.LENGTH_LONG).show();    //Here we use cordl as a object of View class in MainActivity.java

//        Toast.makeText(context, status, Toast.LENGTH_LONG).show();
    }
}


/*BroadcastReceiver A=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String status=MainActivity.getConnectivityStatusString(context);
            Toast.makeText(context, status, Toast.LENGTH_LONG).show();

        }
    };*/