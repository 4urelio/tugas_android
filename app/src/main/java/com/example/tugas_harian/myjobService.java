package com.example.tugas_harian;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class myjobService extends JobService {
    private static final String TAG = myjobService.class.getSimpleName();
    private Boolean jobCanceled = false;
    Context context;

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.i(TAG, "jalan woi");
        context = getApplicationContext();
        doBackground(params);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.i(TAG, "stop woi");
        jobCanceled = true;
        return true;
    }

    private void doBackground(final JobParameters parameters){
        //simulasi proses berjalan secara asynchronus

        new Thread(new Runnable() {
            //anonymous object
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                   Log.i(TAG, "run: " + i);
                    final int finalI = i;
                    Handler mHandler = new Handler(getMainLooper());
                    //simulasi proses yang berjalan selama 3 detik
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Log.i(TAG, "Handler running "+finalI);
                            Toast.makeText(getApplicationContext(), "", finalI);
                        }
                    });
                    if (jobCanceled){
                        return;
                    }
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e){
                        Log.e(TAG, "Error",e.getCause());
                    }
                }
               Log.i(TAG, "job selesai");
            }
        }).start();

    }
}
