package com.example.sunil.broadcastreciever_12;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sunil.broadcastreciever_12.explicit.ExplicitBroadcastActivity;


public class MainActivity extends AppCompatActivity {

    private static final String ActA="register_via_activity_A";
    public static View cordl;

    CoordinatorLayout cordlay;
    Button status;
    Context context;
    Intent a;

    public static int TYPE_WIFI = 1;
    public static int TYPE_MOBILE = 2;
    public static int TYPE_NOT_CONNECTED = 0;

    @Override
    protected void onStart() {
        super.onStart();
         registerReceiver(new Networkstatus(),new IntentFilter(ActA));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status= (Button) findViewById(R.id.bt_status);
//        cordlay= (CoordinatorLayout) findViewById(R.id.tv_cordlay);
        cordl=findViewById(R.id.tv_cordlay);

        a=new Intent(ActA);

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendBroadcast(a);
            }
        });

        Intent i = new Intent(this, ExplicitBroadcastActivity.class);
        startActivity(i);
    }


    public static int getConnectivityStatus(Context context){

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);


        NetworkInfo nwinfo = cm.getActiveNetworkInfo();

        boolean isConnected = nwinfo != null && nwinfo.isConnectedOrConnecting();

        if(isConnected){
            if(nwinfo.getType()== ConnectivityManager.TYPE_WIFI)
                return TYPE_WIFI;

            if(nwinfo.getType() == ConnectivityManager.TYPE_MOBILE)
                return TYPE_MOBILE;
        }

        return TYPE_NOT_CONNECTED;
    }

    public static String getConnectivityStatusString(Context context){

        int connection= getConnectivityStatus(context);

        String status=null;

        if (connection == TYPE_WIFI) {
            status = "Wifi enabled";
        }
        else if (connection == TYPE_MOBILE) {
            status = "Mobile data enabled";
        }
        else if (connection == TYPE_NOT_CONNECTED) {
            status = "No Internet connection";
        }
        return status;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(new Networkstatus());
    }
    
}
