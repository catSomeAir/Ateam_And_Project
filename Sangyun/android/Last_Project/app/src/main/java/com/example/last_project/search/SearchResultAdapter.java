package com.example.last_project.search;

import static android.content.Context.INPUT_METHOD_SERVICE;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder> {
    LayoutInflater inflater;
    Context context;
    SearchResultFragment searchResultFragment;
    public SearchResultAdapter(LayoutInflater inflater, Context context) {
        this.context = context;
        this.inflater = inflater;
    }

    public SearchResultAdapter(LayoutInflater inflater, SearchResultFragment searchResultFragment) {
        this.inflater = inflater;
        this.searchResultFragment = searchResultFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_search_result, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout ln_search_result;
        ImageView imgv_search_result;
        TextView tv_search_result_l_catg, tv_search_result_m_catg, tv_search_result_s_catg, tv_search_result_model_name, tv_search_result_model_code, tv_search_result_brand;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_search_result = v.findViewById(R.id.imgv_search_result);
            tv_search_result_l_catg = v.findViewById(R.id.tv_search_result_l_catg);
            tv_search_result_m_catg = v.findViewById(R.id.tv_search_result_m_catg);
            tv_search_result_s_catg = v.findViewById(R.id.tv_search_result_s_catg);
            tv_search_result_model_name = v.findViewById(R.id.tv_search_result_model_name);
            tv_search_result_model_code = v.findViewById(R.id.tv_search_result_model_code);
            tv_search_result_brand = v.findViewById(R.id.tv_search_result_brand);
            ln_search_result = v.findViewById(R.id.ln_search_result);
        }

        public void bind(@NonNull ViewHolder h, int i){
            InputMethodManager imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow( searchResultFragment.getActivity().findViewById(R.id.edt_search).getWindowToken(), 0);
        }
    }

}
