package com.example.sunil.broadcastreciever_12.explicit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ExampleBroadcastReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Trigger by locally", Toast.LENGTH_SHORT).show();
    }

}
