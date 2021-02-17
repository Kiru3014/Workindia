package com.workindia.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.workindia.R;
import com.workindia.model.ListData;
import com.workindia.model.ListItem;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private final ListData listdata;
    Context context;

    public MyListAdapter(@Nullable ListData listData, Context context) {
        this.listdata = listData;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        final ListItem myListData = this.listdata.getItems().get(position);
        holder.textViewTitle.setText(myListData.getTitle());
        holder.textViewPrice.setText(myListData.getPrice());
        holder.textViewDelivery.setText(myListData.getDelivery());
        Glide.with(context).load(myListData.getImageurl()).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return this.listdata.getItems().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textViewTitle, textViewPrice, textViewDelivery;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.textViewTitle = (TextView) itemView.findViewById(R.id.tv_title);
            this.textViewPrice = (TextView) itemView.findViewById(R.id.tv_price);
            this.textViewDelivery = (TextView) itemView.findViewById(R.id.tv_delivery);
        }
    }
}
