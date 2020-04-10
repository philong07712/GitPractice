package com.example.uigridrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        RecyclerView rv_list = (RecyclerView) findViewById(R.id.rv_list);
        List<item> list = new ArrayList<>();
        StaggerAdapter adapter = new StaggerAdapter(this, list);
        rv_list.setAdapter(adapter);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rv_list.setLayoutManager(manager);
        list.add(new item(R.drawable.clothes));
        list.add(new item(R.drawable.clothestwo));
        list.add(new item(R.drawable.gameui));
        list.add(new item(R.drawable.illustration));
        list.add(new item(R.drawable.illustrationtwo));
        list.add(new item(R.drawable.paint));
        list.add(new item(R.drawable.paint2));
        list.add(new item(R.drawable.wallpaper));
        list.add(new item(R.drawable.clothes));
        list.add(new item(R.drawable.clothestwo));
        list.add(new item(R.drawable.gameui));
        list.add(new item(R.drawable.illustration));
        list.add(new item(R.drawable.illustrationtwo));
        list.add(new item(R.drawable.paint));
        list.add(new item(R.drawable.paint2));
        list.add(new item(R.drawable.wallpaper));
        list.add(new item(R.drawable.clothes));
        list.add(new item(R.drawable.clothestwo));
        list.add(new item(R.drawable.gameui));
        list.add(new item(R.drawable.illustration));
        list.add(new item(R.drawable.illustrationtwo));
        list.add(new item(R.drawable.paint));
        list.add(new item(R.drawable.paint2));
        list.add(new item(R.drawable.wallpaper));
        for (int i = 0; i < 5; i++)
        {
            list.add(new item(R.drawable.clothes));
            list.add(new item(R.drawable.clothestwo));
            list.add(new item(R.drawable.gameui));
            list.add(new item(R.drawable.illustration));
            list.add(new item(R.drawable.illustrationtwo));
            list.add(new item(R.drawable.paint));
            list.add(new item(R.drawable.paint2));
            list.add(new item(R.drawable.wallpaper));
        }
    }
}
