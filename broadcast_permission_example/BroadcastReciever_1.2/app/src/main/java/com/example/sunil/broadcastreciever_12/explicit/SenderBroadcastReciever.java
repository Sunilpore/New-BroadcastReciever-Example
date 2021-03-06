package com.example.sunil.broadcastreciever_12.explicit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SenderBroadcastReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        //Toast.makeText(context, "MSG Triggered", Toast.LENGTH_SHORT).show();
        int resultCode = getResultCode();
        String resultData = getResultData();

        //Here getResultExtras(boolean)
        //false -> it will keep null when data is null
        //true -> it will create a new bundle
        Bundle resultExtras = getResultExtras(true);
        String stringExtra = resultExtras.getString("stringExtra");

        resultCode++;
        stringExtra+= "->SenderReciever";

        String toastText = "SenderReciever\n" +
                "resultCode: " + resultCode + "\n" +
                "resultData: " + resultData + "\n" +
                "StringExtra: " + stringExtra;
        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
        //Toast.makeText(context, "App trigger event ar OR1", Toast.LENGTH_SHORT).show();

        resultData = "SenderReciever";
        resultExtras.putString("stringExtra",stringExtra);

        setResult(resultCode,resultData, resultExtras);
    }

}
