
package com.android.networkapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.lib.networkmonitor.NetworkMonitor;

/**
 * A placeholder fragment containing a simple view.
 */
public class Fragment1 extends Fragment {

    public Fragment1() {
    }

    Button detachNetworkMonitor;

    @Override
    public View
            onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_1, container, false);
        detachNetworkMonitor = (Button) root.findViewById(R.id.button1);
        detachNetworkMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkMonitor.detachFragment(Fragment1.this);
                Toast.makeText(getActivity(), getResources().getString(R.string.detach_fragment),
                        Toast.LENGTH_SHORT).show();
            }
        });

        return root;

    }

    @Override
    public void onResume() {
        super.onResume();
        NetworkMonitor.attachFragment(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        NetworkMonitor.detachFragment(this);
    }
}
