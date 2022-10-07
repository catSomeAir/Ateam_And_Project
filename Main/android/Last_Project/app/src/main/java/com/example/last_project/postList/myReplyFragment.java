package com.example.last_project.postList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.common.CommonVal;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.model.detail.writng.ReplyVO;
import com.example.last_project.postList.adapter.MyReplyAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class myReplyFragment extends Fragment {
    RecyclerView myreply_recv;

    ArrayList<ReplyVO> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_my_reply, container, false);
        myreply_recv= v.findViewById(R.id.myreply_recv);

        CommonConn conn = new CommonConn(getContext(),"board_my_reply_list");
        conn.addParams("email", CommonVal.userInfo.getEmail());
        conn.executeConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                Log.d("result", "onResult: "+isResult);
                list = new Gson().fromJson(data, new TypeToken<ArrayList<ReplyVO>>(){}.getType());
                MyReplyAdapter adapter = new MyReplyAdapter(getLayoutInflater(), list,myReplyFragment.this,getContext());
                RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                myreply_recv.setAdapter(adapter);
                myreply_recv.setLayoutManager(manager);
            }
        });

        return v;
    }
}