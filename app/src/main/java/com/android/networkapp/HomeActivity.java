
package com.android.networkapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.lib.networkmonitor.NetworkMonitor;

public class HomeActivity extends AppCompatActivity {

    NetworkMonitor.NetworkChangeListener listener = new NetworkMonitor.NetworkChangeListener() {
        @Override
        public void onConnectivityChanged(boolean connected) {
            Log.d("NetworkApp", "onConnectivityChangedCallback connected: " + connected);
            Toast.makeText(HomeActivity.this, "OnConnectivityChanged", Toast.LENGTH_SHORT).show();
        }
    };

    Button button1;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        NetworkMonitor.initialize(this);

        button1 = (Button) findViewById(R.id.button1);
        button3 = (Button) findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, Activity1.class));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, Activity3.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        NetworkMonitor.attachActivity(this);
        NetworkMonitor.addOnNetworkChangeListener(listener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        NetworkMonitor.detachActivity(this);
        NetworkMonitor.removeNetworkChangeListener(listener);
    }

}
