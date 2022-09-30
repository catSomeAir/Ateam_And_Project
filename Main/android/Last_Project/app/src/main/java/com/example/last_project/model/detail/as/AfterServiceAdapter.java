package com.example.last_project.model.detail.as;

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

public class AfterServiceAdapter extends RecyclerView.Adapter<AfterServiceAdapter.ViewHolder>{

    LayoutInflater inflater;    //* list 필드에 추가해야함
    Context context;
    //* list 생성자 추가 수정해야함!!
    public AfterServiceAdapter(LayoutInflater inflater, Context context) {
        this.inflater = inflater;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_search_as, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder,position);
    }

    @Override
    public int getItemCount() {
        return 10;  //list로 수정해야함
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_as_name, tv_as_category, tv_as_open, tv_as_close_time, tv_as_distance, tv_as_address;
        LinearLayout ln_as_link;
        public ViewHolder(@NonNull View v) {
            super(v);
            tv_as_name = v.findViewById(R.id.tv_as_name);
            tv_as_category = v.findViewById(R.id.tv_as_category);
            tv_as_open = v.findViewById(R.id.tv_as_open);
            tv_as_close_time = v.findViewById(R.id.tv_as_close_time);
            tv_as_distance = v.findViewById(R.id.tv_as_distance);
            tv_as_address = v.findViewById(R.id.tv_as_address);
            ln_as_link = v.findViewById(R.id.ln_as_link);
        }

        public void bind(@NonNull ViewHolder h, int i){
            h.ln_as_link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, AfterServiceActivity.class  );
                    context.startActivity(intent);
                }
            });
        }
    }
}
