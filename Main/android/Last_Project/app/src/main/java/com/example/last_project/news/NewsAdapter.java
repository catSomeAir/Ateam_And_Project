package com.example.last_project.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
    LayoutInflater inflater;
    Context context;
    ArrayList<NewsVO> list;

    public NewsAdapter(LayoutInflater inflater, Context context, ArrayList<NewsVO> list) {
        this.inflater = inflater;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_news, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_board_type, tv_board_content, tv_board_detail, tv_board_writedate;
        LinearLayout ln_news_content;
        public ViewHolder(@NonNull View v) {
            super(v);
            tv_board_type = v.findViewById(R.id.tv_board_type);
            tv_board_content = v.findViewById(R.id.tv_board_content);
            tv_board_detail = v.findViewById(R.id.tv_board_detail);
            tv_board_writedate = v.findViewById(R.id.tv_board_writedate);
            ln_news_content = v.findViewById(R.id.ln_news_content);
        }

        public void bind(@NonNull ViewHolder h, int i){
            if(list.get(i).getReply_vo()!=null){
                h.tv_board_type.setText("댓글");
                h.tv_board_content.setText(list.get(i).getReply_vo().getEmail()+"님이 댓글이 달았습니다.");
                h.tv_board_detail.setText(list.get(i).getReply_vo().getContent());
            }
        }
    }
}
