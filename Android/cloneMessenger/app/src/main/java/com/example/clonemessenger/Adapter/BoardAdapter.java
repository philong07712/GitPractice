package com.example.clonemessenger.Adapter;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clonemessenger.Model.BoardItem;
import com.example.clonemessenger.R;

import java.util.List;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {
    Context mContext;
    List<BoardItem> list;

    public BoardAdapter(Context mContext, List<BoardItem> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.board_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.board_img.setImageResource(list.get(position).getUserImage());
        holder.board_avatar.setImageResource(list.get(position).getImg());
        holder.board_news.setImageResource(R.drawable.style_news_trans_true);
        holder.board_name.setText(list.get(position).getFullName());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView board_img;
        ImageView board_avatar;
        ImageView board_news;
        TextView board_name;
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            board_img = (ImageView) itemView.findViewById(R.id.board_img);
            board_img.setClipToOutline(true);
            board_avatar = (ImageView) itemView.findViewById(R.id.board_avatar);
            board_news = (ImageView) itemView.findViewById(R.id.board_news);
            board_name = (TextView) itemView.findViewById(R.id.board_name);
        }
    }
}
