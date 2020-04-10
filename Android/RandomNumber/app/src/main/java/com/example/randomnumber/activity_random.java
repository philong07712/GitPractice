package com.example.randomnumber;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class activity_random extends AppCompatActivity {
    int num;
    TextView textView_random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        // get TextView random
        textView_random = (TextView) findViewById(R.id.textview_random);
        Bundle extra = getIntent().getExtras();
        num = Integer.parseInt(extra.getString("random_Max_number"));
        int randomNumber = getRandom(num);
        // Show the random number
        textView_random.setText(Integer.toString(randomNumber));

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        printMessage();
    }
    private int getRandom(int maxNum)
    {
        Random random = new Random();
        int ranNum = random.nextInt(maxNum + 1);
        return ranNum;
    }

    private void printMessage()
    {
        String str = "This is the random number from 0 to " + num;
        TextView message = (TextView) findViewById(R.id.textview_header);
        message.setText(str);
    }

}
