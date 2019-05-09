package firebase.com.test;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    OrderedReciever1 orderedReciever1 = new OrderedReciever1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter("firebase.com.EXAMPLE_ACTION_EXPLICIT");
        intentFilter.setPriority(1);
        registerReceiver(orderedReciever1,intentFilter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(orderedReciever1);
    }

}
