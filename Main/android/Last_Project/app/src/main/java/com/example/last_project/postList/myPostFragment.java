package com.example.last_project.postList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.postList.adapter.MyPostAdapter;

import java.util.ArrayList;

public class myPostFragment extends Fragment {
    RecyclerView mypost_recv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_my_post, container, false);
        mypost_recv = v.findViewById(R.id.mypost_recv);

        ArrayList<PostDTO> list = new ArrayList<PostDTO>();
        list.add(new PostDTO("내가 쓴글1","2022.9.19"));
        list.add(new PostDTO("내가 쓴글2","2022.9.19"));
        list.add(new PostDTO("내가 쓴글3","2022.9.19"));
        list.add(new PostDTO("내가 쓴글4","2022.9.19"));
        MyPostAdapter adapter = new MyPostAdapter(getLayoutInflater(),list,getContext(),myPostFragment.this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL, false);
        mypost_recv.setAdapter(adapter);
        mypost_recv.setLayoutManager(manager);
        return v;
    }
}