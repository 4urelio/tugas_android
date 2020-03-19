package com.example.tugas_harian;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BuatBroadcastReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        if (intent.getAction().equalsIgnoreCase("MY_ACTION")){
            Log.i("TAG","Diterima");
        }
    }
}
