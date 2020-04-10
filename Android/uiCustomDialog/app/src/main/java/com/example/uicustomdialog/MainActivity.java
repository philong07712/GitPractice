package com.example.uicustomdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDialog = new Dialog(this);
        Button btnClick = findViewById(R.id.button_clickMe);
        btnClick.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                ShowPopup(v);
            }
        });

    }

    public void ShowPopup(View v)
    {
        TextView txtClose, txtName, txtAddress, txtFollow, txtPost, txtCity;
        Button btnFollow;
        myDialog.setContentView(R.layout.custompopup);
        btnFollow = (Button) myDialog.findViewById(R.id.btn_follow);
        txtClose = (TextView) myDialog.findViewById(R.id.textView_quit);
        txtClose.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        txtName = (TextView) myDialog.findViewById(R.id.textView_name);
        txtAddress = (TextView) myDialog.findViewById(R.id.textView_address);
        txtPost = (TextView) myDialog.findViewById(R.id.textView_postNum);
        txtFollow = (TextView) myDialog.findViewById(R.id.textView_followNum);
        txtCity = (TextView) myDialog.findViewById(R.id.textView_cityNum);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
}
