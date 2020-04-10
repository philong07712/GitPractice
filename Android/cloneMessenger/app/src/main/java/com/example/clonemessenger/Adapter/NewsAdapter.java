package com.example.clonemessenger.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.clonemessenger.Model.User;
import com.example.clonemessenger.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    List<User> list;
    Context mContext;

    public NewsAdapter(List<User> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.news_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_name.setText(list.get(position).getName());
        holder.img.setImageResource(list.get(position).getImg());
        holder.img_online.setVisibility(getVisibility(position));
        holder.news_read.setImageResource(list.get(position).getReadImg());
    }

    private int getVisibility(int position)
    {
        if (list.get(position).isOnline())
        {
            return View.VISIBLE;
        }
        else
        {
            return View.GONE;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView tv_name;
        CheckBox img_online;
        ImageView news_read;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.chat_img);
            tv_name = (TextView) itemView.findViewById(R.id.news_name);
            img_online = (CheckBox) itemView.findViewById(R.id.chat_online);
            news_read = (ImageView) itemView.findViewById(R.id.news_read);
        }
    }
}
