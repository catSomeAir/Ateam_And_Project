package com.example.last_project.postList.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.postList.RequestedPostVO;

import java.util.ArrayList;

public class RequestedPostAdapter extends RecyclerView.Adapter<RequestedPostAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<RequestedPostVO> list;

    public RequestedPostAdapter(LayoutInflater inflater, ArrayList<RequestedPostVO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_requested_post,parent,false));
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
        TextView tv_category,tv_title,tv_content,tv_writedate,tv_commit;

        public ViewHolder(@NonNull View v) {
            super(v);
            tv_category =v.findViewById(R.id.tv_category);
            tv_title =v.findViewById(R.id.tv_title);
            tv_content =v.findViewById(R.id.tv_content);
            tv_writedate =v.findViewById(R.id.tv_writedate);
            tv_commit =v.findViewById(R.id.tv_commit);
        }

        public void bind(@NonNull ViewHolder h, int i) {
            h.tv_category.setText(list.get(i).getL_catg()+"");
            h.tv_title.setText(list.get(i).getReq_title()+"");
            h.tv_content.setText(list.get(i).getReq_content()+"");
            h.tv_writedate.setText(list.get(i).getReq_writedate()+"");
            h.tv_commit.setText(list.get(i).getCommit()=="N"? "미완료" : "완료");
        }
    }
}
