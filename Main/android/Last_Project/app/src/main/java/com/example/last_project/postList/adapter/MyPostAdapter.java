package com.example.last_project.postList.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.model.ModelDetailActivity;
import com.example.last_project.model.detail.writng.BoardVO;
import com.example.last_project.postList.myPostFragment;
import com.example.last_project.search.category_search.CategorySearchVO;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MyPostAdapter extends RecyclerView.Adapter<MyPostAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<BoardVO> list;
    Context context;
    myPostFragment fragment;


    public MyPostAdapter(LayoutInflater inflater, ArrayList<BoardVO> list, Context context, myPostFragment fragment) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
        this.fragment = fragment;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item__mypost__recv, parent, false));
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
        TextView title, date, req_or_opinion;
        LinearLayout changeactivity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            req_or_opinion = itemView.findViewById(R.id.req_or_opinion);
            changeactivity = itemView.findViewById(R.id.changeactivity);
        }

        public void bind(@NonNull ViewHolder h, int i) {
            h.title.setText(list.get(i).getContent());
            h.date.setText(list.get(i).getWritedate() + "");
            h.req_or_opinion.setText(list.get(i).getCmt_code().equals("o") ? "의견" : "질문");

            h.changeactivity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    CommonConn conn = new CommonConn(context, "model_code_list");
                    conn.addParams("model_code", list.get(i).getModel_code());
                    conn.executeConn(new CommonConn.ConnCallback() {
                        @Override
                        public void onResult(boolean isResult, String data) {
                            if (isResult) {
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
