package com.example.tugas_harian;

import android.app.NotificationManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class tab1 extends Fragment {

    public tab1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab1, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button LOGOUT = (Button) view.findViewById(R.id.buttonLogout);
        LOGOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kelogin = new Intent(getActivity(), MainActivity.class);
                startActivity(kelogin);
            }
        });

        Button startJob = (Button) view.findViewById(R.id.startJob);
        Button stopJob = (Button) view.findViewById(R.id.stopJob);
    }

}
