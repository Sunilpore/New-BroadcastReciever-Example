package com.example.sunil.broadcastreciever_12.explicit;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.sunil.broadcastreciever_12.R;

import java.util.List;

public class ExplicitBroadcastActivity extends AppCompatActivity {

    ExampleBroadcastReciever exampleBroadcastReciever = new ExampleBroadcastReciever();
    LocalBroadcastManager localBroadcastManager;
    Button broadcastMsgBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_broadcast);

        broadcastMsgBut = findViewById(R.id.send_msg);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        broadcastMsgBut.setOnClickListener(v->{
            sendBroadcast();
        });

    }


    public void sendBroadcast(){
        //In most cases this will prefer
        Intent i = new Intent("firebase.com.EXAMPLE_ACTION_EXPLICIT");
        localBroadcastManager.sendBroadcast(i);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter("firebase.com.EXAMPLE_ACTION_EXPLICIT");
        localBroadcastManager.registerReceiver(exampleBroadcastReciever,intentFilter);
    }


    @Override
    protected void onStop() {
        super.onStop();
        localBroadcastManager.unregisterReceiver(exampleBroadcastReciever);
    }


}
