package com.example.last_project.postList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.postList.adapter.MyReplyAdapter;

import java.util.ArrayList;


public class myReplyFragment extends Fragment {
    RecyclerView myreply_recv;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 리사이클러뷰에다가 가짜리스트 보이게 시도중..
        //나중에는 DB에서 가져올 예정

        View v= inflater.inflate(R.layout.fragment_my_reply, container, false);
        myreply_recv= v.findViewById(R.id.myreply_recv);
        ArrayList<ReplyDTO> list = new ArrayList<ReplyDTO>();
        list.add(new ReplyDTO("가짜답글","2022.9.18"));
        list.add(new ReplyDTO("하이루","2022.9.19"));
        MyReplyAdapter adapter = new MyReplyAdapter(getLayoutInflater(), list,getContext(),myReplyFragment.this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        myreply_recv.setAdapter(adapter);
        myreply_recv.setLayoutManager(manager);
        return v;
    }
}