package com.example.last_project.postList.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.postList.MyReplyVO;
import com.example.last_project.postList.myReplyFragment;

import java.util.ArrayList;

public class MyReplyAdapter extends RecyclerView.Adapter<MyReplyAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<MyReplyVO> list;
    Context context;
    myReplyFragment fragment;

    public MyReplyAdapter(LayoutInflater inflater, ArrayList<MyReplyVO> list, Context context, myReplyFragment fragment) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item__myreply__recv,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
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

            //h.date.setText(list.get(i).getDate()+"");
        }
    }
}
