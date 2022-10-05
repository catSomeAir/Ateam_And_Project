package com.example.last_project.postList.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.postList.BookmarkedPostVO;

import java.util.ArrayList;

public class BookmarkedPostAdapter extends RecyclerView.Adapter<BookmarkedPostAdapter.ViewHolder>{
    LayoutInflater inflater;
    Context context;
    ArrayList<BookmarkedPostVO> list;

    public BookmarkedPostAdapter(LayoutInflater inflater, ArrayList<BookmarkedPostVO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_bookmarked_post, parent, false));
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
        ImageView imgv_bookmarkedpost;
        TextView tv_bookmarked_name,tv_bookmarked_model_code,tv_bookmarked_brand_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_bookmarked_name = itemView.findViewById(R.id.tv_bookmarked_name);
            imgv_bookmarkedpost= itemView.findViewById(R.id.imgv_bookmarkedpost);
            tv_bookmarked_model_code =itemView.findViewById(R.id.tv_bookmarked_model_code);
            tv_bookmarked_brand_name =itemView.findViewById(R.id.tv_bookmarked_brand_name);
        }
        public void bind(@NonNull ViewHolder h,int i){
           // Glide.with(context).load(list.get(i).getFilepath().replace("localhost","121.147.215.12:3302")).into(h.imgv_bookmarkedpost);
            h.tv_bookmarked_name.setText(list.get(i).getModel_name()+"");
            h.tv_bookmarked_model_code.setText(list.get(i).getModel_code()+"");
            h.tv_bookmarked_brand_name.setText(list.get(i).getBrand_name()+"");
        }
    }

}
