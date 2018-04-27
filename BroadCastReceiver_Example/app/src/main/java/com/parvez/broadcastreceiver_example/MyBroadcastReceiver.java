package com.parvez.broadcastreceiver_example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.widget.Toast;

/**
 * Created by J2EE-33 on 4/15/2018.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    MediaPlayer mp;
    Context context;
    AudioManager myAudioManager;
    @Override
    public void onReceive(Context context, Intent intent) {
        mp=MediaPlayer.create(context,R.raw.alrm);
        mp.start();


       // makePhoneSilent();
       // Toast.makeText(context, "Silent....", Toast.LENGTH_SHORT).show();

    }

    private void makePhoneSilent() {
        myAudioManager=(AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        myAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    }

}
