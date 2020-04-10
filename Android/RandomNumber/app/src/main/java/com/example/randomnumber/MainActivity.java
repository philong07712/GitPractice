package com.example.randomnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView showCountTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCountTextView = findViewById(R.id.num_text);
        findViewById(R.id.toast_button).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Toast myToast = Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
        findViewById(R.id.count_button).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                countMe(view);
            }
        });
        nextButtonClicked();
    }
    private void countMe(View view)
    {
        String text = showCountTextView.getText().toString();
        int num = Integer.parseInt(text);
        num++;
        showCountTextView.setText(Integer.toString(num));
//        Toast myToast = Toast.makeText(getApplicationContext(), Integer.toString(num), Toast.LENGTH_SHORT);
//        myToast.show();
    }

    private void nextButtonClicked()
    {
        findViewById(R.id.random_button).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                navToRandomPage(view);
            }
        });
    }

    private void navToRandomPage(View view)
    {
        Intent intent = new Intent(this, activity_random.class);
        intent.putExtra("random_Max_number", showCountTextView.getText().toString());
        startActivity(intent);
    }
}
