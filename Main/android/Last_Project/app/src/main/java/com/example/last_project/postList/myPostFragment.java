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
import com.example.last_project.postList.adapter.MyPostAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class myPostFragment extends Fragment {
    RecyclerView mypost_recv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_my_post, container, false);
        mypost_recv = v.findViewById(R.id.mypost_recv);

        ArrayList<MyPostVO> list = new ArrayList<MyPostVO>();

        CommonConn conn = new CommonConn(getContext(),"mypostlist");
        conn.addParams("email", CommonVal.userInfo.getEmail());
        conn.executeConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                Log.d("result", "onResult: "+isResult);
                ArrayList<MyPostVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<MyPostVO>>(){}.getType());
                MyPostAdapter adapter = new MyPostAdapter(getLayoutInflater(),list,getContext(),myPostFragment.this);
                RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL, false);
                mypost_recv.setAdapter(adapter);
                mypost_recv.setLayoutManager(manager);
            }
        });

        return v;
    }
}