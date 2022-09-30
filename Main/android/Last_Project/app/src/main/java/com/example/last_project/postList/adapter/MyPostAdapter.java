package com.example.last_project.postList.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.postList.PostDTO;
import com.example.last_project.postList.myPostFragment;

import java.util.ArrayList;

public class MyPostAdapter extends RecyclerView.Adapter<MyPostAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<PostDTO> list;
    Context context;
    myPostFragment fragment;

    public MyPostAdapter(LayoutInflater inflater, ArrayList<PostDTO> list, Context context, myPostFragment fragment) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
        this.fragment = fragment;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item__mypost__recv,parent,false);
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
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
        }

        public void bind(@NonNull ViewHolder h, int i){
            h.title.setText(list.get(i).getTitle()+"");
            h.date.setText(list.get(i).getDate()+"");
        }
    }
}
