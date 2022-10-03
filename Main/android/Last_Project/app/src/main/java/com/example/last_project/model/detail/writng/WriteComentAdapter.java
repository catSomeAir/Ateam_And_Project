package com.example.last_project.model.detail.writng;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.last_project.R;

import java.util.ArrayList;

public class WriteComentAdapter extends RecyclerView.Adapter<WriteComentAdapter.ViewHolder> {
    LayoutInflater inflater;
    Context context;
    ArrayList<ReplyVO> list;

    public WriteComentAdapter(LayoutInflater inflater, Context context, ArrayList<ReplyVO> list) {
        this.inflater = inflater;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_write_board_reply, parent, false));
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
        ImageView imgv_reply_profile;
        TextView tv_reply_name, tv_reply_writedate, tv_reply_content;

        public ViewHolder(@NonNull View v) {
            super(v);

            imgv_reply_profile = v.findViewById(R.id.imgv_reply_profile);
            tv_reply_name = v.findViewById(R.id.tv_reply_name);
            tv_reply_writedate = v.findViewById(R.id.tv_reply_writedate);
            tv_reply_content = v.findViewById(R.id.tv_reply_content);

        }

        public void bind(@NonNull ViewHolder h, int i) {
            Glide.with(context).load(list.get(i).getFilepath().replace("localhost", "192.168.0.33")).into(h.imgv_reply_profile);
            h.tv_reply_name.setText(list.get(i).getEmail());
            h.tv_reply_writedate.setText(list.get(i).getWritedate());
            h.tv_reply_content.setText(list.get(i).getContent());
        }
    }
}
