package com.example.last_project.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.common.CommonMethod;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<String> list;
    FragmentActivity context;


    public SearchAdapter(LayoutInflater inflater, FragmentActivity context, ArrayList<String> list) {
        this.inflater = inflater;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(inflater.inflate(R.layout.item_serach_relate, parent, false));
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
        TextView tv_search_relate;
        LinearLayout ln_search_relate;

        public ViewHolder(@NonNull View v) {
            super(v);
            tv_search_relate = v.findViewById(R.id.tv_search_relate);
            ln_search_relate = v.findViewById(R.id.ln_search_relate);

        }

        public void bind(@NonNull ViewHolder h, int i) {

            h.tv_search_relate.setText(list.get(i));
            h.ln_search_relate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.findViewById(R.id.recv_search_relate).setVisibility(View.GONE);
                    String replace = list.get(i).replace("# ","");
                    context.getSupportFragmentManager().beginTransaction().replace(R.id.container_search, new SearchResultFragment(replace, CommonMethod.text_div(replace), "text")).commit();
                }
            });
        }
    }
}
