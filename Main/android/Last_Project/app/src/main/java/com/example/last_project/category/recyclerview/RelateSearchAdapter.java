package com.example.last_project.category.recyclerview;

import static android.content.Context.INPUT_METHOD_SERVICE;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.common.CommonMethod;
import com.example.last_project.search.SearchResultFragment;

import java.util.ArrayList;

public class RelateSearchAdapter extends RecyclerView.Adapter<RelateSearchAdapter.ViewHolder> {
    LayoutInflater inflater;
    Context context;
    ArrayList<String> list;
    String[] list1;
    String search_text;
    FragmentManager manager;
    Activity activity;

    public RelateSearchAdapter(LayoutInflater inflater, Context context, ArrayList<String> list) {
        this.inflater = inflater;
        this.context = context;
        this.list = list;
    }

    public RelateSearchAdapter(LayoutInflater inflater, Context context, String[] list1, String search_text, FragmentManager manager, Activity activity) {
        this.inflater = inflater;
        this.context = context;
        this.list1 = list1;
        this.search_text = search_text;
        this.manager = manager;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_relate_search, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return list1.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_relate_text;
        LinearLayout ln_relate;

        public ViewHolder(@NonNull View v) {
            super(v);
            tv_relate_text = v.findViewById(R.id.tv_relate_text);
            ln_relate = v.findViewById(R.id.ln_relate);
        }

        public void bind(@NonNull ViewHolder h, int i) {
            h.tv_relate_text.setText(list1[i]);
            CommonMethod.change_text(list1[i], search_text, h.tv_relate_text);
            h.ln_relate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LinearLayout ln_search_list = activity.findViewById(R.id.ln_search_list);
                    RecyclerView recv_search_relate = activity.findViewById(R.id.recv_search_relate);
                    EditText edt_search = activity.findViewById(R.id.edt_search);
                    TextView tv_cancel = activity.findViewById(R.id.tv_cancel);
                    ImageView imgv_cancel = activity.findViewById(R.id.imgv_cancel);
                    tv_cancel.setVisibility(View.GONE);
                    imgv_cancel.setVisibility(View.GONE);
                    edt_search.clearFocus();
                    edt_search.setText("");
                    ln_search_list.setVisibility(View.GONE);
                    manager.beginTransaction().replace(R.id.container_search, new SearchResultFragment(list1[i],CommonMethod.text_div(list1[i]), "text")).commit();
                    recv_search_relate.setVisibility(View.GONE);

//                    CommonMethod.edittext_change(edt_search, tv_cancel, imgv_cancel, context);
                    InputMethodManager imm = (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edt_search.getWindowToken(), 0);

                }

            });
        }
    }
}
