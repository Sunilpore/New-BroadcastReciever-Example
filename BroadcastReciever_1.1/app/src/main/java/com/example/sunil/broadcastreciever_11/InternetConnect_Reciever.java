package com.example.sunil.broadcastreciever_11;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Sunil on 11/19/2017.
 */

public class InternetConnect_Reciever extends BroadcastReceiver {

    private static final String ActA="register_via_activity";
//    private static final String ActB="android.net.conn.CONNECTIVITY_CHANGE";

    @Override
    public void onReceive(Context context, Intent intent) {

            ConnectivityManager cm= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo nwinfo=cm.getActiveNetworkInfo();

            boolean isConnected= nwinfo!=null && nwinfo.isConnectedOrConnecting();


        if(intent.getAction().equals(ActA)) {
            if (isConnected)
                Toast.makeText(context, "Network is connected", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(context, "Network is not connected", Toast.LENGTH_LONG).show();

        }
        //This will used for manifest.For this comment the Activity register receiver else app will crash
         /*else if(intent.getAction().equals(ActB))
        if (isConnected)
            Toast.makeText(context, "Network is connected via Manifest", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context, "Network is disconnected via Manifest ", Toast.LENGTH_LONG).show();*/
    }



}

    /*//This can used when not implement 'BroadcastReceiver' to class 'InternetConnect_Reciever'.
    BroadcastReceiver A=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if(intent.getAction().equals(ActA)){

                ConnectivityManager cm= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

                NetworkInfo nwinfo=cm.getActiveNetworkInfo();

                Boolean isConnected= nwinfo!=null && nwinfo.isConnectedOrConnecting();

                if(isConnected)
                    try {
                        Toast.makeText(context, "Network is connected", Toast.LENGTH_LONG).show();
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                else
                        Toast.makeText(context, "Network is not connected", Toast.LENGTH_LONG).show();

                }
        }*/

