package com.example.uicardlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder> {
    Context mContext;
    List<item> list;

    public adapter(Context myContext, List<item> list) {
        this.mContext = myContext;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mCover.setImageResource(list.get(position).getCover());
        holder.mProfile.setImageResource(list.get(position).getProfile());
        String nbFollower = Integer.toString(list.get(position).getNb_follower());
        holder.tv_nb_follower.setText(nbFollower);
        holder.tv_name.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView mCover;
        ImageView mProfile;
        TextView tv_nb_follower;
        TextView tv_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mCover = (ImageView) itemView.findViewById(R.id.cover_image);
            mProfile = (ImageView) itemView.findViewById(R.id.profile_image);
            tv_name = (TextView) itemView.findViewById(R.id.card_title);
            tv_nb_follower = (TextView) itemView.findViewById(R.id.card_nb_follower);
        }
    }
}
