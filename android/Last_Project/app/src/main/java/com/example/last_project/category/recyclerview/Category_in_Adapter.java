package com.example.last_project.category.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;

import java.util.ArrayList;

public class Category_in_Adapter extends RecyclerView.Adapter<Category_in_Adapter.ViewHolder> {

    LayoutInflater inflater;
    Context context;
    ArrayList<CategoryVO>  m_list;

    public Category_in_Adapter(LayoutInflater inflater, Context context, ArrayList<CategoryVO> m_list ) {
        this.inflater = inflater;
        this.context = context;
        this.m_list = m_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_in_category, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return m_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_m_name;


        public ViewHolder(@NonNull View v) {
            super(v);
            tv_m_name = v.findViewById(R.id.tv_m_name);

        }

        public void bind(@NonNull ViewHolder h, int i) {

                h.tv_m_name.setText(m_list.get(i).getM_name());

        }
    }
}
