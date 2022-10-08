package com.example.last_project.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.common.CommonVal;
import com.example.last_project.request.RequestManualActivity;
import com.example.last_project.search.category_search.CategorySearchVO;

import java.util.ArrayList;

public class SearchResultExistFragment extends Fragment {
    RecyclerView recv_search_result;
    ArrayList<CategorySearchVO> list;
    LinearLayout ln_search_not_found_request;

    public SearchResultExistFragment(ArrayList<CategorySearchVO> list) {
        this.list = list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_search_result_exist, container, false);
        recv_search_result = v.findViewById(R.id.recv_search_result);

        SearchResultAdapter adapter = new SearchResultAdapter(getLayoutInflater(), SearchResultExistFragment.this, list, getContext());// 나중에 list보내줘야함
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recv_search_result.setLayoutManager(manager);
        recv_search_result.setAdapter(adapter);

        ln_search_not_found_request = v.findViewById(R.id.ln_search_not_found_request);
        ln_search_not_found_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CommonVal.userInfo != null){

                    Intent intent = new Intent(getContext(), RequestManualActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }else {
                    Intent intent = new Intent(getContext(), NotFoundAlertActivity.class);
                    getActivity().overridePendingTransition(0, 0);
                    startActivity(intent);

                }
            }
        });
        return v;
    }
}