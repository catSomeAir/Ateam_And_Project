package com.example.last_project.category.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    LayoutInflater inflater;
    Context context;
    ArrayList<CategoryVO> l_list;
    ArrayList<CategoryVO> m_list;

    //    public CategoryAdapter(LayoutInflater inflater, Context context, ArrayList<CategoryVO> l_list, ArrayList<CategoryVO> m_list) {
//        this.inflater = inflater;
//        this.context = context;
//        this.l_list = l_list;
//        this.m_list = m_list;
//    }
    public CategoryAdapter(LayoutInflater inflater, Context context, ArrayList<CategoryVO> l_list) {
        this.inflater = inflater;
        this.context = context;
        this.l_list = l_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_category, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return l_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_l_name;
        LinearLayout ln_recv_category;
        RecyclerView recv_m_category;

        public ViewHolder(@NonNull View v) {
            super(v);
            tv_l_name = v.findViewById(R.id.tv_l_name);
            ln_recv_category = v.findViewById(R.id.ln_recv_category);       //대분류 LinearLayout
            recv_m_category = v.findViewById(R.id.recv_m_category);         //중분류 RecyclerView
        }

        public void bind(@NonNull ViewHolder h, int i) {

            h.tv_l_name.setText(l_list.get(i).getL_name());
//            h.ln_recv_category.setTag(i);
//            h.recv_m_category.setTag(i+m_list.size());

//            ln_recv_category.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    h.recv_m_category.setVisibility(View.GONE);
//                    CommonConn conn = new CommonConn(context, "mlist.ct");
//                    conn.addParams("l_code", l_list.get(i).getL_code());
//                    conn.executeConn(new CommonConn.ConnCallback() {
//                        @Override
//                        public void onResult(boolean isResult, String data) {
//                            m_list = new Gson().fromJson(data, new TypeToken<ArrayList<CategoryVO>>() {
//                            }.getType());
//                            Category_in_Adapter adapter = new Category_in_Adapter(inflater, context, m_list);
//                            RecyclerView.LayoutManager manager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
//                            h.recv_m_category.setLayoutManager(manager);
//                            h.recv_m_category.setAdapter(adapter);
//                            h.recv_m_category.setVisibility(View.VISIBLE);
//                        }
//                    });
//
//
//                }
//            });

        }
    }
}
