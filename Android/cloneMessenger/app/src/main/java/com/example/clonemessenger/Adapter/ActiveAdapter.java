package com.example.clonemessenger.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clonemessenger.Model.User;
import com.example.clonemessenger.R;

import java.util.List;

public class ActiveAdapter extends RecyclerView.Adapter<ActiveAdapter.ViewHolder> {
    Context mContext;
    List<User> list;

    public ActiveAdapter(Context mContext, List<User> users) {
        this.mContext = mContext;
        this.list = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.active_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.active_img.setImageResource(list.get(position).getImg());
        holder.active_online.setVisibility(getVisibility(position));
        holder.active_name.setText(list.get(position).getFullName());
    }

    @Override
    public int getItemCount() {
        return list.size();
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
    class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView active_img;
        CheckBox active_online;
        TextView active_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            active_img = (ImageView) itemView.findViewById(R.id.active_img);
            active_online = (CheckBox) itemView.findViewById(R.id.active_online);
            active_name = (TextView) itemView.findViewById(R.id.active_name);
        }
    }
}
