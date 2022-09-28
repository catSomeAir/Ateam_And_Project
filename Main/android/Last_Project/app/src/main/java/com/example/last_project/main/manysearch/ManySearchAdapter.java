package com.example.last_project.main.manysearch;

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

public class ManySearchAdapter extends RecyclerView.Adapter<ManySearchAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<ManySearchVO> list;
    Context context;
    public ManySearchAdapter(LayoutInflater inflater,ArrayList<ManySearchVO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_main_manysearch, parent, false));
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
        ImageView imgv_main_manysearch;
        TextView tv_main_manysearch_brand, tv_main_manysearch_model_name, tv_main_manysearch_model_code, tv_manysearch_rank;

        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_main_manysearch = v.findViewById(R.id.imgv_main_manysearch);
            tv_main_manysearch_brand = v.findViewById(R.id.tv_main_manysearch_brand);
            tv_main_manysearch_model_name = v.findViewById(R.id.tv_main_manysearch_model_name);
            tv_main_manysearch_model_code = v.findViewById(R.id.tv_main_manysearch_model_code);
            tv_manysearch_rank = v.findViewById(R.id.tv_manysearch_rank);

        }

        public void bind(@NonNull ViewHolder h, int i) {
            h.tv_main_manysearch_model_code.setText(list.get(i).getModel_code());
            h.tv_main_manysearch_brand.setText(list.get(i).getBrand_name());
            h.tv_main_manysearch_model_name.setText(list.get(i).getModel_name());
            Glide.with(context).load(list.get(i).getFilepath().replace("localhost","192.168.0.33")).into(h.imgv_main_manysearch);
            h.tv_manysearch_rank.setText(i+1+"");
        }
    }
}
