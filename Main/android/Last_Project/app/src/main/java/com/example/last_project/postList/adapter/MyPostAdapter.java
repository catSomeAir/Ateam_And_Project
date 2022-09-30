package com.example.last_project.postList.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.postList.MyPostDetailActivity;
import com.example.last_project.postList.MyPostVO;
import com.example.last_project.postList.myPostFragment;

import java.util.ArrayList;

public class MyPostAdapter extends RecyclerView.Adapter<MyPostAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<MyPostVO> list;
    Context context;
    myPostFragment fragment;


    public MyPostAdapter(LayoutInflater inflater, ArrayList<MyPostVO> list, Context context, myPostFragment fragment) {
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
        TextView title,date,req_or_opinion;
        LinearLayout changeactivity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            req_or_opinion =itemView.findViewById(R.id.req_or_opinion);
            changeactivity =itemView.findViewById(R.id.changeactivity);
        }

        public void bind(@NonNull ViewHolder h, int i){
            h.title.setText(list.get(i).getTitle()+"");
            h.date.setText(list.get(i).getWritedate()+"");
            h.req_or_opinion.setText(list.get(i).getCmt_code().equals("O")? "의견" :"질문");

            h.changeactivity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   Intent intent = new Intent(context,MyPostDetailActivity.class);
                    intent.putExtra("vo", String.valueOf(list.get(i)));
                    context.startActivity(intent);
                }
            });

        }
    }
}