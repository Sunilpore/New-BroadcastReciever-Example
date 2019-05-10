package com.example.sunil.broadcastreciever_12.explicit;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.sunil.broadcastreciever_12.R;

import java.util.List;

public class ExplicitBroadcastActivity extends AppCompatActivity {

    Button broadcastMsgBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_broadcast);

        broadcastMsgBut = findViewById(R.id.send_msg);

        broadcastMsgBut.setOnClickListener(v->{
            sendBroadcast();
        });

    }


    public void sendBroadcast(){

        //In most cases this will prefer
        /*Intent i = new Intent(this,SenderBroadcastReciever.class);
        sendBroadcast(i);*/

        {
        //Intent i = new Intent();

         //within same app
        //i.setClass(this,SenderBroadcastReciever.class);
        //ComponentName cm = new ComponentName(this,SenderBroadcastReciever.class);

         //for another app
        //ComponentName cm = new ComponentName("firebase.com.test","firebase.com.test.SenderBroadcastReciever");
        //i.setComponent(cm);

        // i.setClassName("firebase.com.test","firebase.com.test.SenderBroadcastReciever");
        //sendBroadcast(i);
        }


        //Here we didn't required to specify the class name of explicit Intent.
        // Just define the action string inside manifest receiver
        /*Intent i = new Intent("firebase.com.EXAMPLE_ACTION");
        i.setPackage("firebase.com.test");
        sendBroadcast(i);*/


        //when want to deliver action for various app
        Intent i2 = new Intent("firebase.com.EXAMPLE_ACTION_EXPLICIT");
        PackageManager packageManager = getPackageManager();

        List<ResolveInfo> infos = packageManager.queryBroadcastReceivers(i2,0);

        for(ResolveInfo info :infos){
            ComponentName cn = new ComponentName(info.activityInfo.packageName,info.activityInfo.name);
            i2.setComponent(cn);
            sendBroadcast(i2);
        }

    }

}
