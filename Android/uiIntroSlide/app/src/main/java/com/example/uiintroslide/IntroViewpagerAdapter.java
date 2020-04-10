package com.example.uiintroslide;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class IntroViewpagerAdapter extends PagerAdapter {

    Context mContext;
    List<ScreenItem> list;

    public IntroViewpagerAdapter(Context mContext, List<ScreenItem> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_screen, container, false);
        TextView tv_title = (TextView) view.findViewById(R.id.intro_title);
        TextView tv_des = (TextView) view.findViewById(R.id.intro_desciption);
        ImageView img_intro = (ImageView) view.findViewById(R.id.intro_image);

        tv_title.setText(list.get(position).getIntro_title());
        tv_des.setText(list.get(position).getIntro_des());
        img_intro.setImageResource(list.get(position).getIntro_img());
        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
