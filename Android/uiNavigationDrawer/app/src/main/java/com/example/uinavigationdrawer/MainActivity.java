package com.example.uinavigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.EventLog;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer = findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, drawer, R.string.Open, R.string.Close);
        drawer.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nv);
        setupDrawerContainer(navigationView);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (mToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void selectItemDrawer(MenuItem menuItem)
    {
        Fragment myFragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId())
        {
            case R.id.db:
                fragmentClass = DashBoardFragment.class;
                break;
            case R.id.activities:
                fragmentClass = ActivityFragment.class;
                break;
            case R.id.setting:
                fragmentClass = SettingFragment.class;
                break;
            case R.id.logout:
                fragmentClass = LogoutFragment.class;
                break;
            case R.id.search:
                fragmentClass = SearchFragment.class;
                break;
            default:
                fragmentClass = EventFragment.class;
        }
        try {
            myFragment = (Fragment) fragmentClass.newInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, myFragment).commit();
        menuItem.setChecked(true);
        drawer.closeDrawers();
        setTitle(menuItem.getTitle());
    }

    private void setupDrawerContainer(NavigationView navigationView)
    {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItemDrawer(item);
                return true;
            }
        });
    }
}
