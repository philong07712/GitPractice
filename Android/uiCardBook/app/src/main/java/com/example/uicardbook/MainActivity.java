package com.example.uicardbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        rv_list = findViewById(R.id.rv_list);
        List<Book> list = new ArrayList<>();
        list.add(new Book("He died with", "description", "category", R.drawable.hediedwith));
        list.add(new Book("Where you go", "description", "category", R.drawable.mariasemples));
        list.add(new Book("Privacy", "description", "category", R.drawable.privacy));
        list.add(new Book("The martian", "description", "category", R.drawable.themartian));
        list.add(new Book("The vegetarian", "description", "category", R.drawable.thevigitarian));
        list.add(new Book("The wild Robot", "description", "category", R.drawable.thewildrobot));
        list.add(new Book("He died with", "description", "category", R.drawable.hediedwith));
        list.add(new Book("Where you go", "description", "category", R.drawable.mariasemples));
        list.add(new Book("Privacy", "description", "category", R.drawable.privacy));
        list.add(new Book("The martian", "description", "category", R.drawable.themartian));
        list.add(new Book("The vegetarian", "description", "category", R.drawable.thevigitarian));
        list.add(new Book("The wild Robot", "description", "category", R.drawable.thewildrobot));
        list.add(new Book("He died with", "description", "category", R.drawable.hediedwith));
        list.add(new Book("Where you go", "description", "category", R.drawable.mariasemples));
        list.add(new Book("Privacy", "description", "category", R.drawable.privacy));
        list.add(new Book("The martian", "description", "category", R.drawable.themartian));
        list.add(new Book("The vegetarian", "description", "category", R.drawable.thevigitarian));
        list.add(new Book("The wild Robot", "description", "category", R.drawable.thewildrobot));
        list.add(new Book("He died with", "description", "category", R.drawable.hediedwith));
        list.add(new Book("Where you go", "description", "category", R.drawable.mariasemples));
        list.add(new Book("Privacy", "description", "category", R.drawable.privacy));
        list.add(new Book("The martian", "description", "category", R.drawable.themartian));
        list.add(new Book("The vegetarian", "description", "category", R.drawable.thevigitarian));
        list.add(new Book("The wild Robot", "description", "category", R.drawable.thewildrobot));
        list.add(new Book("He died with", "description", "category", R.drawable.hediedwith));
        list.add(new Book("Where you go", "description", "category", R.drawable.mariasemples));
        list.add(new Book("Privacy", "description", "category", R.drawable.privacy));
        list.add(new Book("The martian", "description", "category", R.drawable.themartian));
        list.add(new Book("The vegetarian", "description", "category", R.drawable.thevigitarian));
        list.add(new Book("The wild Robot", "description", "category", R.drawable.thewildrobot));


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, list);
        rv_list.setAdapter(adapter);
        rv_list.setLayoutManager(new GridLayoutManager(this, 3));
    }
}
