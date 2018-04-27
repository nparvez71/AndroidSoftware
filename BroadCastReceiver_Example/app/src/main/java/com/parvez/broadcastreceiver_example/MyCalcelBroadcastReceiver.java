package com.parvez.broadcastreceiver_example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.widget.Toast;

/**
 * Created by J2EE-33 on 4/15/2018.
 */

public class MyCalcelBroadcastReceiver extends BroadcastReceiver {
    Context context;
    AudioManager myAudioManager;
    @Override
    public void onReceive(Context context, Intent intent) {
        makePhoneNormal();
        Toast.makeText(context, "Normall", Toast.LENGTH_SHORT).show();
    }

    private void makePhoneNormal() {
        myAudioManager=(AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
        myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
    }
}
