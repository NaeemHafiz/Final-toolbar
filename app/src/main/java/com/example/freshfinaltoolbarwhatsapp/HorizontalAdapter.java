package com.example.freshfinaltoolbarwhatsapp;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

    private String[] items;


    public HorizontalAdapter(String[] items) {
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_horizontalrecyclerview, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.textView.setText(items[i]);

    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private Typeface typeface;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            typeface = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/GreatVibes-Regular.otf");
            textView = itemView.findViewById(R.id.textview);
            textView.setTypeface(typeface);

        }
    }
}
