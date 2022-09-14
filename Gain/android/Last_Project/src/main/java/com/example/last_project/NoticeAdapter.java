package com.example.last_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<NoticeDTO> list;

    public NoticeAdapter(LayoutInflater inflater, ArrayList<NoticeDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public NoticeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_notice_recv,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder,position);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,content,date;

        public ViewHolder(@NonNull View v){
            super(v);
            this.title=v.findViewById(R.id.tv_notice_title);
            this.content =v.findViewById(R.id.tv_notice_content);
            this.date =v.findViewById(R.id.tv_notice_date);
        }
        public void bind(ViewHolder h,int i){
            h.title.setText(list.get(i).getTitle());
            h.content.setText(list.get(i).getContent());
            h.date.setText(list.get(i).getDate());
        }
    }
}