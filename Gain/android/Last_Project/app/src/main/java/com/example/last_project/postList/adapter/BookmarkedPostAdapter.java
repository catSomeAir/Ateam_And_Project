package com.example.last_project.postList.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;

import java.util.ArrayList;

public class BookmarkedPostAdapter extends RecyclerView.Adapter<BookmarkedPostAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<String> list;

    public BookmarkedPostAdapter(LayoutInflater inflater, ArrayList<String> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_bookmarked_post, parent, false));
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
        TextView tv_bookmarked_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_bookmarked_name = itemView.findViewById(R.id.tv_bookmarked_name);
        }
        public void bind(@NonNull ViewHolder h,int i){
            h.tv_bookmarked_name.setText(list.get(i)+"");
        }
    }

}
