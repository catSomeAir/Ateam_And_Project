package com.example.last_project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoticeActivity extends AppCompatActivity {
    RecyclerView recv_notice;
    ArrayList<NoticeDTO> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        recv_notice = findViewById(R.id.recv_notice);

        list = new ArrayList<>();

            list.add(new NoticeDTO("제목","내용","날짜"));


        NoticeAdapter adapter = new NoticeAdapter(getLayoutInflater(),list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recv_notice.setAdapter(adapter);
        recv_notice.setLayoutManager(manager);
    }
}