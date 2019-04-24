package com.example.son.test1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class ItemViewHolder extends RecyclerView.ViewHolder {
    TextView tvID;
    TextView tvName;
    TextView tvPrice;
    ImageView imgDelete;

    public ItemViewHolder(View itemView) {
        super(itemView);
        tvID=itemView.findViewById(R.id.tvID);
        tvName=itemView.findViewById(R.id.tvName);
        tvPrice=itemView.findViewById(R.id.tvPrice);
        imgDelete=itemView.findViewById(R.id.imgDelete);
    }
}
