package com.example.last_project.event;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    LayoutInflater inflater;
    Integer[] event_imgs;
    Context context;

    public EventAdapter(LayoutInflater inflater, Integer[] event_imgs, Context context) {
        this.inflater = inflater;
        this.event_imgs = event_imgs;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_event_recv, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return event_imgs.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView event_img;

        public ViewHolder(@NonNull View v) {
            super(v);
            event_img = v.findViewById(R.id.item_event_recv);
        }

        public void bind(ViewHolder h, int i) {
            h.event_img.setImageResource(event_imgs[i]);
            h.event_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i == 0) {
                        Intent intent = new Intent(context, EventDetailActivity.class);
                        intent.putExtra("index", "0");
                        context.startActivity(intent);


                    }

                }
            });
        }
    }
}
