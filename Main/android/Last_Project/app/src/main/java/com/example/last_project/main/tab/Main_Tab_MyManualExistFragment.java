package com.example.last_project.main.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.search.category_search.CategorySearchVO;

import java.util.ArrayList;

public class Main_Tab_MyManualExistFragment extends Fragment {
    RecyclerView recv_main_mymanual;
    ArrayList<CategorySearchVO> list;

    public Main_Tab_MyManualExistFragment(ArrayList<CategorySearchVO> list) {
        this.list = list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main__tab__my_manual_exist, container, false);
        recv_main_mymanual = v.findViewById(R.id.recv_main_mymanual);
        Main_Tab_Adapter adapter = new Main_Tab_Adapter(getContext(), getLayoutInflater(),list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL  , false);
        recv_main_mymanual.setAdapter(adapter);
        recv_main_mymanual.setLayoutManager(manager);
        return v;
    }
}