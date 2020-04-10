package com.example.uitablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.WindowManager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        viewPager = (ViewPager) findViewById(R.id.viewPager_id);
        tabLayout = (TabLayout) findViewById(R.id.tabId);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.addFragment(new FragmentExplore(), "Explore");
        adapter.addFragment(new FragmentQuiz(), "Quiz");
        adapter.addFragment(new FragmentStore(), "Store");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
