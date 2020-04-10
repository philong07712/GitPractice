package com.example.uislider;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.zip.Inflater;

public class SliderAdapter extends PagerAdapter {
    Context mContext;
    LayoutInflater inflater;

    public int[] list_image = {
                R.drawable.image_1,
                R.drawable.image_2,
                R.drawable.image_3,
                R.drawable.image_4
    };

    public String[] title = {
            "COSMONAUT",
            "SATELITE",
            "GALAXY",
            "ROCKET"
    };

    public String[] descriptions = {
            "Description 1",
            "Description 2",
            "Description 3",
            "Description 4"
    };

    public int[] backgroundColors = {
            Color.rgb(55, 55, 55),
            Color.rgb(239, 85, 85),
            Color.rgb(110, 49, 89),
            Color.rgb(1, 188, 212)
    };

    public SliderAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return list_image.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (ConstraintLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide, container, false);
        ConstraintLayout layoutSlide = (ConstraintLayout) view.findViewById(R.id.cons_layout);
        TextView tv_Title = (TextView) view.findViewById(R.id.slide_title);
        TextView tv_des = (TextView) view.findViewById(R.id.slide_des);
        ImageView image = (ImageView) view.findViewById(R.id.slideImage);
        layoutSlide.setBackgroundColor(backgroundColors[position]);
        tv_Title.setText(title[position]);
        tv_des.setText(descriptions[position]);
        image.setImageResource(list_image[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
