package com.example.last_project.main.manysearch;

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
import com.example.last_project.common.CommonMethod;
import com.example.last_project.common.CommonVal;
import com.example.last_project.model.ModelDetailActivity;
import com.example.last_project.search.category_search.CategorySearchVO;

import java.util.ArrayList;

public class ManySearchAdapter extends RecyclerView.Adapter<ManySearchAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<CategorySearchVO> list;
    Context context;
    public ManySearchAdapter(LayoutInflater inflater,ArrayList<CategorySearchVO> list, Context context) {
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
        LinearLayout ln_manysearch;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_main_manysearch = v.findViewById(R.id.imgv_main_manysearch);
            tv_main_manysearch_brand = v.findViewById(R.id.tv_main_manysearch_brand);
            tv_main_manysearch_model_name = v.findViewById(R.id.tv_main_manysearch_model_name);
            tv_main_manysearch_model_code = v.findViewById(R.id.tv_main_manysearch_model_code);
            tv_manysearch_rank = v.findViewById(R.id.tv_manysearch_rank);
            ln_manysearch = v.findViewById(R.id.ln_manysearch);

        }

        public void bind(@NonNull ViewHolder h, int i) {
            h.tv_main_manysearch_model_code.setText(list.get(i).getModel_code());
            h.tv_main_manysearch_brand.setText(list.get(i).getBrand_name());
            h.tv_main_manysearch_model_name.setText(list.get(i).getModel_name());
            Glide.with(context).load(list.get(i).getFilepath().replace("localhost","121.147.215.12:3302").replace("192.168.0.33","121.147.215.12:3302")).into(h.imgv_main_manysearch);
            h.tv_manysearch_rank.setText(i+1+"");

            h.ln_manysearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ModelDetailActivity.class);
                    intent.putExtra("model_info", list.get(i));
                    if (CommonVal.recent_list != null) {

                        if (CommonVal.recent_list.size() <= 10) {
                            CommonVal.recent_list.add(list.get(i).getModel_code());
                            CommonMethod.setStringArrayPref(context, "recent_list", CommonVal.recent_list);
                        } else {
                            CommonVal.recent_list.remove(0);
                            CommonVal.recent_list.add(list.get(i).getModel_code());
                            CommonMethod.setStringArrayPref(context, "recent_list", CommonVal.recent_list);
                        }
                    } else {
                        CommonVal.recent_list.add(list.get(i).getModel_code());
                        CommonMethod.setStringArrayPref(context, "recent_list", CommonVal.recent_list);
                    }
                    context.startActivity(intent);
                }
            });
        }
    }
}
