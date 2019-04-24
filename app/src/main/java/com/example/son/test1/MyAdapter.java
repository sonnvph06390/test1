package com.example.son.test1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    Context context;
    List<Oto> otos;

    public MyAdapter(Context context, List<Oto> otos) {
        this.context = context;
        this.otos = otos;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.itemoto,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.tvID.setText(otos.get(position).getId());
        holder.tvName.setText(otos.get(position).getName());
        holder.tvPrice.setText(otos.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return otos.size();
    }
}
