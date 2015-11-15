
package com.android.networkapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.lib.networkmonitor.NetworkMonitor;

public class Activity1 extends AppCompatActivity {

    Button detachNetworkMonitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        detachNetworkMonitor = (Button) findViewById(R.id.button1);
        detachNetworkMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkMonitor.detachActivity(Activity1.this);
                Toast.makeText(Activity1.this, getResources().getString(R.string.detach_activity),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        NetworkMonitor.attachActivity(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        NetworkMonitor.detachActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
