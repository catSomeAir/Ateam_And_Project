package com.example.last_project.main.tab;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.last_project.R;
import com.example.last_project.model.ModelDetailActivity;
import com.example.last_project.search.category_search.CategorySearchVO;

import java.util.ArrayList;

public class Main_Tab_Adapter extends RecyclerView.Adapter<Main_Tab_Adapter.ViewHolder> {
    LayoutInflater inflater;
    String override;
    Context context;
    ArrayList<CategorySearchVO> list ;

    public Main_Tab_Adapter(Context context, LayoutInflater inflater,  ArrayList<CategorySearchVO> list) {
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
        LinearLayout ln_recent;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_model_photo= v.findViewById(R.id.imgv_model_photo);
            tv_model_brand= v.findViewById(R.id.tv_model_brand);
            tv_model_name= v.findViewById(R.id.tv_model_name);
            tv_model_code= v.findViewById(R.id.tv_model_code);
            ln_recent= v.findViewById(R.id.ln_recent);

        }

        public void bind(@NonNull ViewHolder h, int i){
            h.tv_model_brand.setText(list.get(i).getBrand_name());
            h.tv_model_name.setText(list.get(i).getModel_name());
            h.tv_model_code.setText(list.get(i).getModel_code());

            Glide.with(context).load(list.get(i).getFilepath().replace("localhost","121.147.215.12:3302").replace("192.168.0.33","121.147.215.12:3302")).into(h.imgv_model_photo);

            h.ln_recent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ModelDetailActivity.class);
                    intent.putExtra("model_info", list.get(i));
                    context.startActivity(intent);
                }
            });

        }
    }

}
