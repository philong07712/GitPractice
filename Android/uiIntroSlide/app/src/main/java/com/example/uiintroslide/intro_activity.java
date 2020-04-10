package com.example.uiintroslide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.PropertyPermission;

public class intro_activity extends AppCompatActivity {

    TabLayout tabIndicator;
    Button btn_next;
    Button btn_start;
    int position;
    final List<ScreenItem> list = new ArrayList<>();
    SharedPreferences prefs;
    Animation btn_animation;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_activity);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        // Init with the view
        // Check if the intro opened
        prefs = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        if (restorePrefsData())
        {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
        final ViewPager screenPager = findViewById(R.id.screen_viewpager);
        btn_next = (Button) findViewById(R.id.intro_next);
        tabIndicator = findViewById(R.id.Indicator);
        btn_start = (Button) findViewById(R.id.intro_start);
        btn_start.setVisibility(View.INVISIBLE);
        btn_animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_animation);
        list.add(new ScreenItem(R.drawable.img1, "Fast Food", "Common menu items at fast food outlets include fish and chips, sandwiches, pitas, hamburgers, fried chicken, french fries, onion rings, chicken nuggets, tacos, pizza, hot dogs, and ice cream, though many fast food restaurants offer \"slower\" foods like chili, mashed potatoes, and salads.\n"));
        list.add(new ScreenItem(R.drawable.img2, "Fast Delivery", "Next-day delivery is a delivery service that allows you to have goods delivered the day after they're collected by the courier. ... Next-day delivery means that senders can have items delivered to their customers more quickly than with a standard 2 or 3-day service."));
        list.add(new ScreenItem(R.drawable.img3, "Bank", "A bank is a financial institution licensed to receive deposits and make loans. Banks may also provide financial services such as wealth management, currency exchange, and safe deposit boxes. ... In most countries, banks are regulated by the national government or central bank."));
        IntroViewpagerAdapter adapter = new IntroViewpagerAdapter(this, list);
        screenPager.setAdapter(adapter);
        tabIndicator.setupWithViewPager(screenPager);

        // Set onClick for btn_next
        btn_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                position = screenPager.getCurrentItem();
                if (position < list.size())
                {
                    position++;
                    screenPager.setCurrentItem(position);
                }
                if (position == list.size() - 1)
                {
                    // Hide the next and tab layout, show the start button
                    LoadLastScreen();
                }
            }
        });

        // Set tabLayout
        tabIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == list.size() - 1)
                {
                    LoadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        btn_start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                savePrefsData();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void LoadLastScreen()
    {
        tabIndicator.setVisibility(View.INVISIBLE);
        btn_next.setVisibility(View.INVISIBLE);
        btn_start.setVisibility(View.VISIBLE);
        btn_start.setAnimation(btn_animation);
    }
    private boolean restorePrefsData()
    {
        Boolean isIntro = prefs.getBoolean("IsIntroOpen", false);
        return false;
    }
    private void savePrefsData()
    {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("IsIntroOpen", true);
        editor.apply();
    }
}
