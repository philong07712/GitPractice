package com.example.uicardbook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context mContext;
    List<Book> list;

    public RecyclerViewAdapter(Context mContext, List<Book> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cardview_item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.img_book.setImageResource(list.get(position).getCover());
        holder.title.setText(list.get(position).getTitle());
        holder.container.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, book_detail.class);
                intent.putExtra("image", list.get(position).getCover());
                intent.putExtra("description", list.get(position).getDescription());
                intent.putExtra("title", list.get(position).getTitle());
                intent.putExtra("category", list.get(position).getCategory());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        ImageView img_book;
        CardView container;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.card_book_title);
            img_book = (ImageView) itemView.findViewById(R.id.img_card_book);
            container = (CardView) itemView.findViewById(R.id.card_container);
        }
    }
}
