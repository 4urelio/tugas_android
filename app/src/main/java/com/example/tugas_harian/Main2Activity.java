package com.example.tugas_harian;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Notification;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import static com.example.tugas_harian.NotifWifi.CHANNEL_1_ID;
import static com.example.tugas_harian.NotifWifi.CHANNEL_2_ID;

public class Main2Activity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem tab1,tab2,tab3;
    public PageAdapter pagerAdapter;
    private NotificationManagerCompat notificationManager;
    private WifiManager wifiManager;
    private View view;
    private static final String TAG = tab1.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tab1 = (TabItem) findViewById(R.id.tab1);
        tab2 = (TabItem) findViewById(R.id.tab2);
        tab3 = (TabItem) findViewById(R.id.tab3);
        viewPager = findViewById(R.id.viewpager);

        pagerAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0) {
                    pagerAdapter.notifyDataSetChanged();
                }else if(tab.getPosition() == 1) {
                    pagerAdapter.notifyDataSetChanged();
                }else if(tab.getPosition() == 2){
                    pagerAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        notificationManager = NotificationManagerCompat.from(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifiStateReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifiStateReceiver);
    }

    private BroadcastReceiver wifiStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiStateReceiver = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);
            if (wifiStateReceiver == WifiManager.WIFI_STATE_ENABLED){
                wifiOn(view);
            }
            else {
                wifiOff();
            }
        }
    };

    public void wifiOn(View view){
        String title = "Notification";
        String message = "Wifi on";
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_wifi_black_24dp)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notification);

    }

    public void wifiOff(){
        String title = "Notification";
        String message = "Wifi off";
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_signal_wifi_off_black_24dp)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(2, notification);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void scheduleJob(View view){
        ComponentName componentName = new ComponentName(getApplicationContext(), myjobService.class);
        JobInfo info = new JobInfo.Builder(123, componentName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setPersisted(true)
                .setPeriodic(15 * 60 * 1000) // dilakukan berapa menit ??
                .build();

        JobScheduler scheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        int hasilkode = scheduler.schedule(info);
        if (hasilkode == JobScheduler.RESULT_SUCCESS){
            Log.i(TAG, "schedule berhasil ");
        }else {
            Log.i(TAG, "schedule tidak berhasil");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void cancelJob(View view){
        JobScheduler scheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        scheduler.cancel(123);
        Log.i(TAG,"Canceled Job");
    }

}
