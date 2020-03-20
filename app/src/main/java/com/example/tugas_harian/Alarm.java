package com.example.tugas_harian;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;


public class Alarm {

    private Context context;

    public Alarm(Context context) {
        this.context = context;
    }

    //aktivasi saat app terbuka
    @SuppressLint(value = "ShortAlarm")
    public void setAlarm(){
        Intent intent = new Intent(context, BuatBroadcastReciever.class);
        PendingIntent send = PendingIntent.getBroadcast(context, 1, intent, 0);
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (am != null) {
            long triggerAfter = 3000;
            long tringgerEvery = 3000;
            am.setRepeating(AlarmManager.RTC_WAKEUP, triggerAfter,tringgerEvery, send);
        }
    }

    public void cancelAlarm(){
        Intent intent = new Intent(context, BuatBroadcastReciever.class);
        PendingIntent send = PendingIntent.getBroadcast(context, 1, intent, 0);
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (am != null) {
            am.cancel(send);
        }
    }
}
