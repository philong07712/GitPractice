package com.example.clonemessenger.Fragment;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.clonemessenger.Adapter.ViewPagerAdapter;
import com.example.clonemessenger.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class FragmentEveryone extends Fragment {
    View v;
    TabLayout topNav;
    ViewPager viewPager;
    ViewPagerAdapter pagerAdapter;
    public FragmentEveryone() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.everyone_fragment, container, false);
        topNav = (TabLayout) v.findViewById(R.id.nav_currently);
        viewPager = (ViewPager) v.findViewById(R.id.layout_card_board);
        pagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        setupViewPager(viewPager);
        topNav.setupWithViewPager(viewPager);
        setupTabLayout();
        topNav.setOnTabSelectedListener(selector);
        return v;
    }

    private void setupViewPager(ViewPager pager)
    {
        pagerAdapter.addFragment(new FragmentBoard(), "Stories");
        pagerAdapter.addFragment(new FragmentActive(), "Active (40)");
        pager.setAdapter(pagerAdapter);
    }

    private void setupTabLayout()
    {
        View tabOne = LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        TextView title = (TextView) tabOne.findViewById(R.id.tab_title);
        title.setText(pagerAdapter.getPageTitle(0));
        tabOne.setBackgroundResource(R.drawable.tab_selected_style);
        topNav.getTabAt(0).setCustomView(tabOne);
        // setTab two
        View tabTwo = LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        title = (TextView) tabTwo.findViewById(R.id.tab_title);
        title.setText(pagerAdapter.getPageTitle(1));
        topNav.getTabAt(1).setCustomView(tabTwo);

    }
    // set the state for selected item
    TabLayout.OnTabSelectedListener selector = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            tab.getCustomView().setBackgroundResource(R.drawable.tab_selected_style);
            TextView title = (TextView) tab.getCustomView().findViewById(R.id.tab_title);
            title.setTextColor(getResources().getColor(R.color.black));
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            tab.getCustomView().setBackgroundResource(0);
            TextView title = (TextView) tab.getCustomView().findViewById(R.id.tab_title);
            title.setTextColor(getResources().getColor(R.color.darkGray));
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };
}
