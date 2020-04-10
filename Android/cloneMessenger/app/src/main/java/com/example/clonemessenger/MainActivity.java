package com.example.clonemessenger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.clonemessenger.Fragment.FragmentChat;
import com.example.clonemessenger.Fragment.FragmentEveryone;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        bottomNav = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(mOnItemSelect);
        loadFragment(new FragmentChat());
    }

    BottomNavigationView.OnNavigationItemSelectedListener mOnItemSelect = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId())
            {
                case R.id.nav_chat:
                    fragment = new FragmentChat();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_everyone:
                    fragment = new FragmentEveryone();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.FrameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
