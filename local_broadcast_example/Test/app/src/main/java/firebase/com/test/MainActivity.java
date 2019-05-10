package firebase.com.test;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ExampleBroadcastReciever orderedReciever1 = new ExampleBroadcastReciever();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter("firebase.com.EXAMPLE_ACTION_EXPLICIT");
        registerReceiver(orderedReciever1,intentFilter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(orderedReciever1);
    }

}
