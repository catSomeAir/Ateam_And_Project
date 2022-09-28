package com.example.last_project.main.tab;

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
import com.example.last_project.main.manysearch.ManySearchVO;

import java.util.ArrayList;

public class Main_Tab_Adapter extends RecyclerView.Adapter<Main_Tab_Adapter.ViewHolder> {
    LayoutInflater inflater;
    String override;
    Context context;
    ArrayList<ManySearchVO> list ;
    public Main_Tab_Adapter(Context context, LayoutInflater inflater,  ArrayList<ManySearchVO> list) {
        this.inflater = inflater;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_main_mymanual_and_recent, parent, false));
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
        ImageView imgv_model_photo;
        TextView tv_model_brand, tv_model_name, tv_model_code;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_model_photo= v.findViewById(R.id.imgv_model_photo);
            tv_model_brand= v.findViewById(R.id.tv_model_brand);
            tv_model_name= v.findViewById(R.id.tv_model_name);
            tv_model_code= v.findViewById(R.id.tv_model_code);

        }

        public void bind(@NonNull ViewHolder h, int i){
            h.tv_model_brand.setText(list.get(i).getBrand_name());
            h.tv_model_name.setText(list.get(i).getModel_name());
            h.tv_model_code.setText(list.get(i).getModel_code());

            Glide.with(context).load(list.get(i).getFilepath().replace("localhost","192.168.0.33")).into(h.imgv_model_photo);
        }
    }

}
