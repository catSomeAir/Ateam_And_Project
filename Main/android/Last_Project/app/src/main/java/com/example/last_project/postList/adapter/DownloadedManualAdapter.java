package com.example.last_project.postList.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.postList.BookmarkedPostVO;

import java.util.ArrayList;

public class DownloadedManualAdapter extends RecyclerView.Adapter<DownloadedManualAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<BookmarkedPostVO> list;

    public DownloadedManualAdapter(LayoutInflater inflater, ArrayList<BookmarkedPostVO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public DownloadedManualAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_downloaded_manual, parent, false));
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
        TextView tv_name,tv_model_code,tv_brand_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.tv_name);
            tv_model_code = itemView.findViewById(R.id.tv_model_code);
            tv_brand_name = itemView.findViewById(R.id.tv_brand_name);
        }
        public void bind(@NonNull ViewHolder h, int i){
            h.tv_name.setText(list.get(i).getModel_name()+"");
            h.tv_model_code.setText(list.get(i).getModel_code()+"");
            h.tv_brand_name.setText(list.get(i).getBrand_name()+"");
        }
    }
}
