package com.example.last_project.postList;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.postList.adapter.RequestedPostAdapter;

import java.util.ArrayList;

public class RequestedPostActivity extends AppCompatActivity {
    RecyclerView requested_post_recv;
    ArrayList<RequestedPostDTO> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requested_post);
        requested_post_recv =findViewById(R.id.requested_post_recv);
        list = new ArrayList<RequestedPostDTO>();
        for (int i = 0; i < 10; i++) {
            list.add(new RequestedPostDTO("냉장고", "qwwewewew12334", "삼성"));
        }

        RequestedPostAdapter adapter = new RequestedPostAdapter(getLayoutInflater(),list);
        RecyclerView.LayoutManager manager= new LinearLayoutManager(RequestedPostActivity.this, RecyclerView.VERTICAL,false);
        requested_post_recv.setAdapter(adapter);
        requested_post_recv.setLayoutManager(manager);
    }
}