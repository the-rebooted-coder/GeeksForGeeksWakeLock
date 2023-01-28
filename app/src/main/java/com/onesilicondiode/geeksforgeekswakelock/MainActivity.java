package com.onesilicondiode.geeksforgeekswakelock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        acquireWakeLock();
    }

    public class GfgIntentWakeLatch extends IntentService {
        // Acquiring a Notification ID
        public static final int NOTIF_ID = 101;
        private NotificationManager notificationManager;
        // Addressing notification builder
        NotificationCompat.Builder gfgBuilder;
        public GfgIntentWakeLatch() {
            super("GfgIntentWakeLatch");
        }

        @Override protected void onHandleIntent(Intent intent) {
            // Creating extra in Intent
            // Geeks for Geeks
            Bundle extras = intent.getExtras();
        }
    }

    private void acquireWakeLock() {
        //This code holds the CPU
        PowerManager gfgPowerDraw = (PowerManager)getSystemService(POWER_SERVICE);
        PowerManager.WakeLock gfgPowerLatch = gfgPowerDraw.newWakeLock(
                PowerManager.PARTIAL_WAKE_LOCK,
                "GfGApp::AchieveWakeLock");
        gfgPowerLatch.acquire(20*60*1000L /*20 minutes*/);
    }
}