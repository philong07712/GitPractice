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

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    List<User> list;
    Context mContext;

    public ChatAdapter(List<User> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.chat_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_name.setText(list.get(position).getFullName());
        holder.tv_content.setText(list.get(position).getFullName() + ": Mock content");
        holder.img.setImageResource(list.get(position).getImg());
        holder.online_btn.setVisibility(getVisibility(position));
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
        TextView tv_name, tv_content;
        ImageView img;
        CheckBox online_btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.chat_title);
            tv_content = (TextView) itemView.findViewById(R.id.chat_content);
            img = (ImageView) itemView.findViewById(R.id.chat_img);
            online_btn = (CheckBox) itemView.findViewById(R.id.chat_online);
        }
    }
}
