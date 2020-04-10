package com.example.haircippers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Vibrator vibrator;
    private boolean isVibrate;
    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        isVibrate = false;
        mp = MediaPlayer.create(this, R.raw.hair_clipper_sound);
        findViewById(R.id.button_run).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                if (isVibrate == true)
                {
                    cancelVibrator();
                }
                else
                {
                    runVibrator();
                }
            }
        });
    }
    private void runVibrator()
    {
        // Vibrator
        int numAmtitude = 1000;
        long[] pattern = {numAmtitude - 100, numAmtitude};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            vibrator.vibrate(pattern, 1);
        }
        else
        {
            vibrator.vibrate(500);
        }
        isVibrate = true;
        mp.start();
    }
    private void cancelVibrator()
    {
        vibrator.cancel();
        isVibrate = false;
        mp.pause();
    }
    public void onPause()
    {
        cancelVibrator();
        super.onPause();
    }
}
