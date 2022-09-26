package com.example.last_project.main.manysearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;

public class ManySearchAdapter extends RecyclerView.Adapter<ManySearchAdapter.ViewHolder> {
    LayoutInflater inflater;

    public ManySearchAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
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
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv_main_manysearch;
        TextView tv_main_manysearch_brand, tv_main_manysearch_model_name, tv_main_manysearch_model_code;

        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_main_manysearch = v.findViewById(R.id.imgv_main_manysearch);
            tv_main_manysearch_brand = v.findViewById(R.id.tv_main_manysearch_brand);
            tv_main_manysearch_model_name = v.findViewById(R.id.tv_main_manysearch_model_name);
            tv_main_manysearch_model_code = v.findViewById(R.id.tv_main_manysearch_model_code);

        }

        public void bind(@NonNull ViewHolder h, int i) {

        }
    }
}
