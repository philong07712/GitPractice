package com.example.uinews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    boolean isDark = false;
    ConstraintLayout mainContainer;
    List<NewsItem> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        mainContainer = findViewById(R.id.main_container);

        getThemeStatePref();
        if (isDark)
        {
            mainContainer.setBackgroundColor(getResources().getColor(R.color.dark));
        }
        else
        {
            mainContainer.setBackgroundColor(getResources().getColor(R.color.white));
        }

        final RecyclerView rv_news = findViewById(R.id.rv_news);
        list = new ArrayList<>();
        list.add(new NewsItem(R.drawable.image_1, "Space", "Next-day delivery is a delivery service that allows you to have goods delivered the day after they're collected by the courier. ... Next-day delivery means that senders can have items delivered to their customers more quickly than with a standard 2 or 3-day service.", "July 6 1998"));
        list.add(new NewsItem(R.drawable.image_2, "Satellite", "Next-day delivery is a delivery service that allows you to have goods delivered the day after they're collected by the courier. ... Next-day delivery means that senders can have items delivered to their customers more quickly than with a standard 2 or 3-day service.", "July 6 1998"));
        list.add(new NewsItem(R.drawable.image_3, "Black Hole", "Next-day delivery is a delivery service that allows you to have goods delivered the day after they're collected by the courier. ... Next-day delivery means that senders can have items delivered to their customers more quickly than with a standard 2 or 3-day service.", "July 6 1998"));
        list.add(new NewsItem(R.drawable.image_4, "Space ship", "Next-day delivery is a delivery service that allows you to have goods delivered the day after they're collected by the courier. ... Next-day delivery means that senders can have items delivered to their customers more quickly than with a standard 2 or 3-day service.", "July 6 1998"));
        list.add(new NewsItem(R.drawable.image_1, "Space", "Next-day delivery is a delivery service that allows you to have goods delivered the day after they're collected by the courier. ... Next-day delivery means that senders can have items delivered to their customers more quickly than with a standard 2 or 3-day service.", "July 6 1998"));
        list.add(new NewsItem(R.drawable.image_2, "Satellite", "Next-day delivery is a delivery service that allows you to have goods delivered the day after they're collected by the courier. ... Next-day delivery means that senders can have items delivered to their customers more quickly than with a standard 2 or 3-day service.", "July 6 1998"));
        list.add(new NewsItem(R.drawable.image_3, "Black Hole", "Next-day delivery is a delivery service that allows you to have goods delivered the day after they're collected by the courier. ... Next-day delivery means that senders can have items delivered to their customers more quickly than with a standard 2 or 3-day service.", "July 6 1998"));
        list.add(new NewsItem(R.drawable.image_4, "Space ship", "Next-day delivery is a delivery service that allows you to have goods delivered the day after they're collected by the courier. ... Next-day delivery means that senders can have items delivered to their customers more quickly than with a standard 2 or 3-day service.", "July 6 1998"));
        list.add(new NewsItem(R.drawable.image_1, "Space", "Next-day delivery is a delivery service that allows you to have goods delivered the day after they're collected by the courier. ... Next-day delivery means that senders can have items delivered to their customers more quickly than with a standard 2 or 3-day service.", "July 6 1998"));
        list.add(new NewsItem(R.drawable.image_2, "Satellite", "Next-day delivery is a delivery service that allows you to have goods delivered the day after they're collected by the courier. ... Next-day delivery means that senders can have items delivered to their customers more quickly than with a standard 2 or 3-day service.", "July 6 1998"));
        list.add(new NewsItem(R.drawable.image_3, "Black Hole", "Next-day delivery is a delivery service that allows you to have goods delivered the day after they're collected by the courier. ... Next-day delivery means that senders can have items delivered to their customers more quickly than with a standard 2 or 3-day service.", "July 6 1998"));
        list.add(new NewsItem(R.drawable.image_4, "Space ship", "Next-day delivery is a delivery service that allows you to have goods delivered the day after they're collected by the courier. ... Next-day delivery means that senders can have items delivered to their customers more quickly than with a standard 2 or 3-day service.", "July 6 1998"));

        NewsAdapter adapter = new NewsAdapter(this, list, isDark);
        rv_news.setAdapter(adapter);
        rv_news.setLayoutManager(new LinearLayoutManager(this));

        // Init variable
        fab = findViewById(R.id.fab_switch_mode);

        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                isDark = !isDark;
                if (isDark)
                {
                    mainContainer.setBackgroundColor(getResources().getColor(R.color.dark));
                }
                else
                {
                    mainContainer.setBackgroundColor(getResources().getColor(R.color.white));
                }
                NewsAdapter newsAdapter = new NewsAdapter(getApplicationContext(), list, isDark);
                rv_news.setAdapter(newsAdapter);
                saveThemeStatePref(isDark);
            }
        });
    }
    private void saveThemeStatePref(Boolean isDark)
    {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("isDark", isDark);
        editor.apply();
    }
    private void getThemeStatePref()
    {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPrefs", MODE_PRIVATE);
        isDark = prefs.getBoolean("isDark", false);
    }
}
