package com.example.last_project.postList.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.postList.ReplyDTO;

import java.util.ArrayList;

public class MyReplyAdapter extends RecyclerView.Adapter<MyReplyAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<ReplyDTO> list;

    public MyReplyAdapter(LayoutInflater inflater, ArrayList<ReplyDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item__myreply__recv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder,position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title =itemView.findViewById(R.id.reply);
            date =itemView.findViewById(R.id.date);
        }
        public void bind(@NonNull ViewHolder h, int i) {
            h.title.setText(list.get(i).getTitle()+"");
            h.date.setText(list.get(i).getDate()+"");
        }
    }
}
