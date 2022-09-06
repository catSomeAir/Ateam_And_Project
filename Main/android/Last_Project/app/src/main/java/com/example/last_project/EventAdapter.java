package com.example.last_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    LayoutInflater inflater;
    Integer[] event_imgs;

    public EventAdapter(LayoutInflater inflater, Integer[] event_imgs) {
        this.inflater = inflater;
        this.event_imgs = event_imgs;
    }

    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView =inflater.inflate(R.layout.item_event_recv,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.ViewHolder holder, int position) {
        holder.bind(holder,position);
    }

    @Override
    public int getItemCount() {
        return event_imgs.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView event_img;

        public ViewHolder(@NonNull View v){
            super(v);
            event_img =v.findViewById(R.id.item_event_recv);
        }
        public void bind(ViewHolder h,int i){
            h.event_img.setImageResource(event_imgs[i]);
        }
    }
}
