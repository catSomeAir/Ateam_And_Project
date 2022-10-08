package com.example.last_project.search;

import static android.content.Context.INPUT_METHOD_SERVICE;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
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

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder> {
    LayoutInflater inflater;
    Context context;
    SearchResultExistFragment searchResultExistFragment;
    ArrayList<CategorySearchVO> list;

    public SearchResultAdapter(LayoutInflater inflater, Context context) {
        this.context = context;
        this.inflater = inflater;
    }

    public SearchResultAdapter(LayoutInflater inflater, SearchResultExistFragment searchResultExistFragment, ArrayList<CategorySearchVO> list, Context context) {
        this.inflater = inflater;
        this.searchResultExistFragment = searchResultExistFragment;
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
        TextView tv_search_result_category_name, tv_search_result_model_name, tv_search_result_model_code, tv_search_result_brand;

        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_search_result = v.findViewById(R.id.imgv_search_result);
            tv_search_result_category_name = v.findViewById(R.id.tv_search_result_category_name);
            tv_search_result_model_name = v.findViewById(R.id.tv_search_result_model_name);
            tv_search_result_model_code = v.findViewById(R.id.tv_search_result_model_code);
            tv_search_result_brand = v.findViewById(R.id.tv_search_result_brand);
            ln_search_result = v.findViewById(R.id.ln_search_result);
        }

        public void bind(@NonNull ViewHolder h, int i) {
            InputMethodManager imm = (InputMethodManager) searchResultExistFragment.getActivity().getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(searchResultExistFragment.getActivity().findViewById(R.id.edt_search).getWindowToken(), 0);

            Glide.with(searchResultExistFragment.getActivity()).load(list.get(i).getFilepath().replace("localhost", "121.147.215.12:3302").replace("192.168.0.33","121.147.215.12:3302")).into(h.imgv_search_result);
            h.tv_search_result_model_name.setText(list.get(i).getModel_name());
            h.tv_search_result_model_code.setText(list.get(i).getModel_code());
            h.tv_search_result_brand.setText(list.get(i).getBrand_name());
            h.tv_search_result_category_name.setText(list.get(i).getCategory_name());

            h.ln_search_result.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
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


                    Intent intent = new Intent(context, ModelDetailActivity.class);
                    //* 해당 제품에 대한 정보를 같이 넘겨줘야함
                    CategorySearchVO model_info = list.get(i);
                    intent.putExtra("model_info", model_info);
                    context.startActivity(intent);
                }
            });
        }


    }

}
