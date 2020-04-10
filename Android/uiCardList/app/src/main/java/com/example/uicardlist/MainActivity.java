package com.example.uicardlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        RecyclerView recyclerView = findViewById(R.id.rv_list);
        List<item> list = new ArrayList<item>();
        list.add(new item(R.mipmap.forest, 3000, R.mipmap.akachi, "Forest"));
        list.add(new item(R.mipmap.cat, 14000, R.mipmap.analise, "Cat"));
        list.add(new item(R.mipmap.coffee, 2000, R.mipmap.atlas, "Coffee"));
        list.add(new item(R.mipmap.fire, 9000, R.mipmap.elia, "Fire"));
        list.add(new item(R.mipmap.mountain, 4000, R.mipmap.pelle, "Mountain"));
        list.add(new item(R.mipmap.waterfall, 1000, R.mipmap.thibaut, "Waterfall"));

        adapter adapter = new adapter(this, list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
