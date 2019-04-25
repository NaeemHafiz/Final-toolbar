package com.example.freshfinaltoolbarwhatsapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class HakayatAdapter extends RecyclerView.Adapter<HakayatAdapter.MyViewHolder> {
    private List<ChildHakayatCategory> hakayatcategorylist;

    public HakayatAdapter(List<ChildHakayatCategory> hakayatcategorylist) {
        this.hakayatcategorylist = hakayatcategorylist;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_hakayat, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        final ChildHakayatCategory hakayatcategory = hakayatcategorylist.get(i);
        myViewHolder.hakayat.setText(hakayatcategory.getName());

    }

    @Override
    public int getItemCount() {
        if (hakayatcategorylist != null)
            return hakayatcategorylist.size();
        else
            return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView hakayat;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            hakayat = itemView.findViewById(R.id.hakayat1);
        }
    }

    public void updateData(List<ChildHakayatCategory> hakayatcategorylist) {
        this.hakayatcategorylist = hakayatcategorylist;
        notifyDataSetChanged();
    }

}
