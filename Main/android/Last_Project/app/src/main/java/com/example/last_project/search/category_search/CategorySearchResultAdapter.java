package com.example.last_project.search.category_search;

import android.content.Context;
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

import java.util.ArrayList;

public class CategorySearchResultAdapter extends RecyclerView.Adapter<CategorySearchResultAdapter.ViewHolder> {
    LayoutInflater inflater;
    Context context;
    ArrayList<CategorySearchVO> list;

    public CategorySearchResultAdapter(LayoutInflater inflater, Context context) {
        this.context = context;
        this.inflater = inflater;
    }

    public CategorySearchResultAdapter(LayoutInflater inflater,  ArrayList<CategorySearchVO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_search_result, parent, false));
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
        LinearLayout ln_search_result;
        ImageView imgv_search_result;
        TextView tv_search_result_l_catg, tv_search_result_m_catg, tv_search_result_s_catg,tv_search_result_category_name, tv_search_result_model_name, tv_search_result_model_code, tv_search_result_brand;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_search_result = v.findViewById(R.id.imgv_search_result);
            tv_search_result_category_name = v.findViewById(R.id.tv_search_result_category_name);
//            tv_search_result_m_catg = v.findViewById(R.id.tv_search_result_m_catg);
//            tv_search_result_s_catg = v.findViewById(R.id.tv_search_result_s_catg);
            tv_search_result_model_name = v.findViewById(R.id.tv_search_result_model_name);
            tv_search_result_model_code = v.findViewById(R.id.tv_search_result_model_code);
            tv_search_result_brand = v.findViewById(R.id.tv_search_result_brand);
            ln_search_result = v.findViewById(R.id.ln_search_result);
        }

        public void bind(@NonNull ViewHolder h, int i){
//            InputMethodManager imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow( searchResultFragment.getActivity().findViewById(R.id.edt_search).getWindowToken(), 0);

            Glide.with(context).load(list.get(i).getFilepath().replace("localhost","121.147.215.12:3302").replace("192.168.0.33","121.147.215.12:3302")).into(h.imgv_search_result);
            h.tv_search_result_model_name.setText(list.get(i).getModel_name());
            h.tv_search_result_model_code.setText(list.get(i).getModel_code());
            h.tv_search_result_brand.setText(list.get(i).getBrand_name());
            h.tv_search_result_category_name.setText(list.get(i).getCategory_name());

        }
    }

}
