package com.example.last_project.postList.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.postList.RequestedPostDTO;

import java.util.ArrayList;

public class RequestedPostAdapter extends RecyclerView.Adapter<RequestedPostAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<RequestedPostDTO> list;

    public RequestedPostAdapter(LayoutInflater inflater, ArrayList<RequestedPostDTO> list) {
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
        TextView model_name,model_code,brand_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            model_name = itemView.findViewById(R.id.tv_model_name);
            model_code = itemView.findViewById(R.id.tv_model_code);
            brand_name = itemView.findViewById(R.id.tv_brand_name);
        }

        public void bind(@NonNull ViewHolder holder, int i) {
            holder.model_name.setText(list.get(i).getModel_name()+"");
            holder.model_code.setText(list.get(i).getModel_code()+"");
            holder.brand_name.setText(list.get(i).getBrand_name()+"");
        }
    }
}
