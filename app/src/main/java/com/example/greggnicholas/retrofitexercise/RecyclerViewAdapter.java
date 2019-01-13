package com.example.greggnicholas.retrofitexercise;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    //    private String[] data;
    private List<String> dogViewList;
    private LayoutInflater layoutInflater;

    public RecyclerViewAdapter(Context applicationContext, List<String> dogViewList) {
        this.dogViewList = dogViewList;
        this.layoutInflater = layoutInflater.from(applicationContext);
    }



    //connects your method to the data of your view holder


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = layoutInflater.inflate(R.layout.cardview_layout, viewGroup, false);
        return new RecyclerViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int position) {
        String current = dogViewList.get(position);
        Picasso.get()
                .load(current)
                .into(recyclerViewHolder.houndView);
    }


    @Override
    //returns the size of the Linked List
    public int getItemCount() {
        return dogViewList.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private ImageView houndView;
        private RecyclerViewAdapter adapter;

        public RecyclerViewHolder(@NonNull View itemView, RecyclerViewAdapter adapter) {
            super(itemView);
            houndView = itemView.findViewById(R.id.hound_view);
            this.adapter = adapter;


        }


    }

}
