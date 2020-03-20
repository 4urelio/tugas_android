package com.example.tugas_harian;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BuatBroadcastReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        Toast.makeText(context, "INI TOAST", Toast.LENGTH_SHORT).show();
    }
}
