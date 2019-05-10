package firebase.com.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.Toast;

public class OrderedReciever2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

       // Toast.makeText(context, "App trigger event ar OR2", Toast.LENGTH_SHORT).show();

        final Handler handler = new Handler();

        PendingResult pendingResult = goAsync();

        new Thread(()->{

            SystemClock.sleep(10000);

            int resultCode = pendingResult.getResultCode();
            String resultData = pendingResult.getResultData();
            Bundle resultExtras = pendingResult.getResultExtras(true);
            String stringExtra = resultExtras.getString("stringExtra");

            resultCode++;
            stringExtra+= "->OR2";

            String toastText = "OR2\n" +
                    "resultCode: " + resultCode + "\n" +
                    "resultData: " + resultData + "\n" +
                    "StringExtra: " + stringExtra;

            handler.post(()->{
                Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
            });


            resultData = "OR2";
            resultExtras.putString("stringExtra",stringExtra);

            pendingResult.setResult(resultCode,resultData, resultExtras);
            pendingResult.finish();
            //abortBroadcast();
        }).start();


    }

}
