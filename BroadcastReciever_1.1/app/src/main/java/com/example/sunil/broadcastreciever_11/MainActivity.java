package com.example.sunil.broadcastreciever_11;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Don't use both Activity registerReceiver() and Manifest registerReceiver() at a same time else app will crash.
    private static final String ActA="register_via_activity";
//    private static final String ActB="android.net.conn.CONNECTIVITY_CHANGE";   //Copy String content from manifest
    Intent a,b;
    Button status;

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(new InternetConnect_Reciever(),new IntentFilter(ActA));
//        registerReceiver(new InternetConnect_Reciever(),new IntentFilter(ActB));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       status= (Button) findViewById(R.id.bt_status);

        a=new Intent(ActA);
//        b=new Intent(ActB);

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendBroadcast(a);
//                sendBroadcast(b);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(new InternetConnect_Reciever());
    }

}
