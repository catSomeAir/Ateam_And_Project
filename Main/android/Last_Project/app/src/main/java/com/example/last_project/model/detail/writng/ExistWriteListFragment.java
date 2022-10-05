package com.example.last_project.model.detail.writng;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;

import java.util.ArrayList;


public class ExistWriteListFragment extends Fragment {
    RecyclerView recv_write;
    String model_code;
    ArrayList<BoardVO> list;

    public ExistWriteListFragment(String model_code ,ArrayList<BoardVO> list) {
        this.model_code = model_code;
        this.list = list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_exist_write_list, container, false);
        //쓴글 띄우기
        recv_write = v.findViewById(R.id.recv_write);

        // 해당모델의 글 조회
        WriteAdapter adapter = new WriteAdapter(getLayoutInflater(), getContext(), list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recv_write.setLayoutManager(manager);
        recv_write.setAdapter(adapter);

        return v;
    }
}