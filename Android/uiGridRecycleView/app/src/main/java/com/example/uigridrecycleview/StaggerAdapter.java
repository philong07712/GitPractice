package com.example.uigridrecycleview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StaggerAdapter extends RecyclerView.Adapter<StaggerAdapter.ImageViewHolder> {
    Context mContext;
    List<item> list;

    public StaggerAdapter(Context mContext, List<item> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.item_img.setImageResource(list.get(position).getImg());
        holder.item_img.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim_item));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder
    {
        ImageView item_img;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            item_img = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
