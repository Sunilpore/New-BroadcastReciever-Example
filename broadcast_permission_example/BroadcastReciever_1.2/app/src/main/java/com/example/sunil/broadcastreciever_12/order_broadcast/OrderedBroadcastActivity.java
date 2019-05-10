package com.example.sunil.broadcastreciever_12.order_broadcast;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.sunil.broadcastreciever_12.R;
import com.example.sunil.broadcastreciever_12.explicit.SenderBroadcastReciever;

public class OrderedBroadcastActivity extends AppCompatActivity {

    Button orderedBroadcastMsgBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordered_broadcast);

        orderedBroadcastMsgBut = findViewById(R.id.send_ordered_broadcasr_msg);

        orderedBroadcastMsgBut.setOnClickListener(v->{
            sendBroadcast();
        });

    }


    public void sendBroadcast() {

        Intent i = new Intent("firebase.com.EXAMPLE_ACTION_ORDER_RECIEVER");
        i.setPackage("firebase.com.test");

        Bundle extras = new Bundle();
        extras.putString("stringExtra","start");

        sendOrderedBroadcast(i, Manifest.permission.WAKE_LOCK,new SenderBroadcastReciever(),
                null,0,"Start",extras);

    }


}
