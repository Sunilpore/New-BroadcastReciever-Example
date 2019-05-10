package com.example.sunil.broadcastreciever_12.explicit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ExampleBroadcastReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "MSG Triggered", Toast.LENGTH_SHORT).show();

        PendingResult pendingResult = goAsync();

        pendingResult.finish();
    }

}
