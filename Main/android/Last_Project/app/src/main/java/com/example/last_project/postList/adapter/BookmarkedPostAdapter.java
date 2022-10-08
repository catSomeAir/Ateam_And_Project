package com.example.last_project.postList.adapter;

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
import com.example.last_project.conn.CommonConn;
import com.example.last_project.model.ModelDetailActivity;
import com.example.last_project.postList.BookmarkedPostVO;
import com.example.last_project.search.category_search.CategorySearchVO;
import com.google.gson.Gson;

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
        LinearLayout ln_bookmark;
        ImageView imgv_bookmarkedpost;
        TextView tv_bookmarked_name,tv_bookmarked_model_code,tv_bookmarked_brand_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_bookmarked_name = itemView.findViewById(R.id.tv_bookmarked_name);
            imgv_bookmarkedpost= itemView.findViewById(R.id.imgv_bookmarkedpost);
            tv_bookmarked_model_code =itemView.findViewById(R.id.tv_bookmarked_model_code);
            tv_bookmarked_brand_name =itemView.findViewById(R.id.tv_bookmarked_brand_name);
            ln_bookmark =itemView.findViewById(R.id.ln_bookmark);
        }
        public void bind(@NonNull ViewHolder h,int i){
            Glide.with(context).load(list.get(i).getFilepath().replace("localhost","121.147.215.12:3302").replace("192.168.0.33","121.147.215.12:3302")).into(h.imgv_bookmarkedpost);
            h.tv_bookmarked_name.setText(list.get(i).getModel_name()+"");
            h.tv_bookmarked_model_code.setText(list.get(i).getModel_code()+"");
            h.tv_bookmarked_brand_name.setText(list.get(i).getBrand_name()+"");

            //제품 상세페이지로 이동시키기
            h.ln_bookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CommonConn conn = new CommonConn(context, "model_code_list");
                    conn.addParams("model_code",list.get(i).getModel_code());
                    conn.executeConn(new CommonConn.ConnCallback() {
                        @Override
                        public void onResult(boolean isResult, String data) {
                            if(isResult){
                                CategorySearchVO vo = new Gson().fromJson(data, CategorySearchVO.class);
                                Intent intent = new Intent(context, ModelDetailActivity.class);
                                intent.putExtra("model_info", vo);
                                context.startActivity(intent);
                            }

                        }
                    });
                }
            });
        }
    }

}
