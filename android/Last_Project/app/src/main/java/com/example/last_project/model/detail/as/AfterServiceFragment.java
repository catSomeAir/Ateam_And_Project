package com.example.last_project.model.detail.as;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;

public class AfterServiceFragment extends Fragment{
    RecyclerView recv_as;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_after_service, container, false);
        recv_as = v.findViewById(R.id.recv_as);

        //* 맵에서 받아온 거리순 AS센터 리스트 추가해야함


        AfterServiceAdapter adapter = new AfterServiceAdapter(getLayoutInflater(), getContext());   //list 추가해야함
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recv_as.setAdapter(adapter);
        recv_as.setLayoutManager(manager);
        return v;
    }


}