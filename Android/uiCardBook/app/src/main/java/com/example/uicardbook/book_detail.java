package com.example.uicardbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class book_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        // init view
        ImageView img = (ImageView) findViewById(R.id.img_book_detail);
        TextView tv_title = (TextView) findViewById(R.id.title_book_detail);
        TextView tv_des = (TextView) findViewById(R.id.des_book_detail);
        TextView tv_category = (TextView) findViewById(R.id.category_book_detail);


        Intent intent = getIntent();
        img.setImageResource(intent.getIntExtra("image", 0));
        tv_des.setText(intent.getStringExtra("description"));
        tv_title.setText(intent.getStringExtra("title"));
        tv_category.setText(intent.getStringExtra("category"));
    }
}
