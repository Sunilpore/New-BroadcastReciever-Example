package firebase.com.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class OrderedReciever1 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        //Here we use resultExtras() insted of intentExtras().
        // Because once the intent is created its data is not going to change remain same for all reciever.So we can't edit the data only read data in this case


        int resultCode = getResultCode();
        String resultData = getResultData();

        //Here getResultExtras(boolean)
        //false -> it will keep null when data is null
        //true -> it will create a new bundle
        Bundle resultExtras = getResultExtras(true);
        String stringExtra = resultExtras.getString("stringExtra");

        resultCode++;
        stringExtra+= "->OR1";
        
        String toastText = "OR1\n" +
                            "resultCode: " + resultCode + "\n" +
                            "resultData: " + resultData + "\n" +
                            "StringExtra: " + stringExtra;
        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
        //Toast.makeText(context, "App trigger event ar OR1", Toast.LENGTH_SHORT).show();

        resultData = "OR1";
        resultExtras.putString("stringExtra",stringExtra);

        setResult(resultCode,resultData, resultExtras);
    }

}
