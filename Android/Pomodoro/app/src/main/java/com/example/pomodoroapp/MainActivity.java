package com.example.pomodoroapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity Logcat";
    private final String START = "Start", PAUSE = "Pause", RESTART = "Restart";
    public final String MY_PREFER_NAME = "Data";
    public final String NUM_FINISH_NAME = "NumFinish: ";
    public final String NUM_TIME_NAME = "NumTime: ";
    SharedPreferences.Editor editor;
    SharedPreferences prefs;
    TextView tv_second, tv_minute;
    EditText et_input;
    Button bt_add;
    Boolean mIsTimeRunning = false;
    CountDownTimer mTimer;
    ProgressBar mProgressBar;
    long mInputMinute, mBreakMinute = 1, mnumFinish;
    AlertDialog dialog;
    Vibrator vibrator;
    MediaPlayer mpFinish;
    long[] pattern = {0, 500, 500, 500, 500};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        editor = getSharedPreferences(MY_PREFER_NAME, MODE_PRIVATE).edit();
        prefs = getSharedPreferences(MY_PREFER_NAME, MODE_PRIVATE);
        mnumFinish = prefs.getLong(NUM_FINISH_NAME, 0);
        mpFinish = MediaPlayer.create(getApplicationContext(), R.raw.finish);
        tv_second = (TextView) findViewById(R.id.textView_second);
        tv_minute = (TextView) findViewById(R.id.textView_minute);
        bt_add = findViewById(R.id.button_add);
        bt_add.setText(START);

        dialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("set Time")
                .setMessage("Choose your time to work")
                .setPositiveButton("SET", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                editor.putString(NUM_TIME_NAME, et_input.getText().toString());
                editor.apply();
            }
        })
                .create();
        View dialogView = MainActivity.this.getLayoutInflater().inflate(R.layout.dialog_add, null);
        et_input = (EditText) dialogView.findViewById(R.id.editText_inputTime);
        et_input.setText(prefs.getString(NUM_TIME_NAME, "1"));
        mInputMinute = Long.parseLong(et_input.getText().toString());
        dialog.setView(dialogView);
        bt_add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (bt_add.getText().toString().equals("Start"))
                {
                    if (mIsTimeRunning)
                    {
                        mTimer.cancel();
                    }
                    timerStart();
                }
                else if (bt_add.getText().toString().equals("Pause"))
                {
                    timerPause();
                }
                else
                {
                    timerRestart();
                }
            }
        });
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar_time);

        mProgressBar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                setTimer();
            }
        });

    }

    private void timerStart()
    {
        Toast.makeText(getApplicationContext(), Long.toString(mnumFinish), Toast.LENGTH_SHORT).show();
        mInputMinute = Long.parseLong(et_input.getText().toString());
        bt_add.setText(PAUSE);
        mTimer = new CountDownTimer(mInputMinute * 1000 * 60, 1000)
        {
            public void onTick(long millisUntilFinished)
            {
                String text_minutes = "";
                long minutes = millisUntilFinished / 1000 / 60;
                String text_seconds = ":";
                long seconds = millisUntilFinished / 1000 % 60;
                if (seconds < 10)
                {
                    text_seconds += "0";
                }
                if (minutes < 10)
                {
                    text_minutes += "0";
                }
                text_minutes += Long.toString(minutes);
                text_seconds += Long.toString(seconds);
                tv_minute.setText(text_minutes);
                tv_second.setText(text_seconds);
                double percentD = (double) (mInputMinute * 1000 * 60 - millisUntilFinished) / (mInputMinute * 1000 * 60) * 10000;
                int percent = (int) percentD;
                mProgressBar.setProgress(percent);
            }
            @Override
            public void onFinish() {
                mProgressBar.setProgress(mProgressBar.getMax());
                bt_add.setText(START);
                mIsTimeRunning = true;
                setBreak();
                vibrator.vibrate(pattern, -1);
                mnumFinish++;
                editor.putLong(NUM_FINISH_NAME, mnumFinish);
                editor.apply();
                mpFinish.start();
            }
        }.start();
        mIsTimeRunning = true;
    }
    private void timerRestart()
    {
        if (!mIsTimeRunning)
        {
            mTimer.start();
            mIsTimeRunning = true;
        }
        bt_add.setText(START);
    }
    private void timerPause()
    {
        if (mIsTimeRunning)
        {
            mTimer.cancel();
            mIsTimeRunning = false;
        }
        bt_add.setText(RESTART);

    }
    private void setTimer()
    {
        dialog.show();
    }

    private void setBreak()
    {
        bt_add.setText(PAUSE);
        mTimer = new CountDownTimer(mBreakMinute * 1000 * 60, 1000)
        {
            public void onTick(long millisUntilFinished)
            {
                String text_minutes = "";
                Long minutes = millisUntilFinished / 1000 / 60;
                String text_seconds = ":";
                long seconds = millisUntilFinished / 1000 % 60;
                if (seconds < 10)
                {
                    text_seconds += "0";
                }
                if (minutes < 10)
                {
                    text_minutes += "0";
                }
                text_minutes += Long.toString(minutes);
                text_seconds += Long.toString(seconds);
                tv_minute.setText(text_minutes);
                tv_second.setText(text_seconds);
                double percentD = (double) (mBreakMinute * 1000 * 60 - millisUntilFinished) / (mBreakMinute * 1000 * 60) * 10000;
                int percent = (int) percentD;
                mProgressBar.setProgress(percent);
            }
            @Override
            public void onFinish() {
                timerStart();
                vibrator.vibrate(pattern, -1);
                mpFinish.start();

            }
        }.start();
    }
}
