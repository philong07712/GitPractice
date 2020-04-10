package com.example.uinews;

import android.app.Application;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    Context mContext;
    List<NewsItem> list;
    Boolean isDark = false;

    public NewsAdapter(Context mContext, List<NewsItem> list, Boolean isDark) {
        this.mContext = mContext;
        this.list = list;
        this.isDark = isDark;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        // apply animation to image
        holder.img_news.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation));
        // apply animation to container
        holder.container.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.scale_animation));
        holder.tv_date.setText(list.get(position).getNews_date());
        holder.tv_des.setText(list.get(position).getNews_des());
        holder.tv_title.setText(list.get(position).getNews_title());
        holder.img_news.setImageResource(list.get(position).getNews_image());

    }

    class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title, tv_date, tv_des;
        ImageView img_news;
        ConstraintLayout container;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.news_title);
            tv_des = (TextView) itemView.findViewById(R.id.news_description);
            tv_date = (TextView) itemView.findViewById(R.id.news_date);
            img_news = (ImageView) itemView.findViewById(R.id.news_img);
            container = itemView.findViewById(R.id.news_container);

            if (isDark)
            {
                setDarkContainer();
            }
        }
        private void setDarkContainer()
        {
            // set Dark container to different color
            container.setBackgroundResource(R.drawable.card_bg_dark);
        }
    }
}
