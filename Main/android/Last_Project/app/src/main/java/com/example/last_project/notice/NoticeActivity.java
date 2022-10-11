package com.example.last_project.notice;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.conn.CommonConn;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class NoticeActivity extends AppCompatActivity {
    RecyclerView recv_notice;
    ArrayList<NoticeVO> list;
    //TextView title;
    ImageView imgv_notice_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        recv_notice = findViewById(R.id.recv_notice);
        imgv_notice_back = findViewById(R.id.imgv_notice_back);
        //title = findViewById(R.id.tv_notice_title);
        //content = findViewById(R.id.tv_notice_content);

        imgv_notice_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,0);
            }
        });

        CommonConn conn = new CommonConn(NoticeActivity.this, "notice");
        conn.executeConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                if (isResult) {
                    list = new Gson().fromJson(data, new TypeToken<ArrayList<NoticeVO>>() {
                    }.getType());

                    NoticeAdapter adapter = new NoticeAdapter(getLayoutInflater(), list);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(NoticeActivity.this, RecyclerView.VERTICAL, false);
                    recv_notice.setAdapter(adapter);
                    recv_notice.setLayoutManager(manager);
                }
            }
        });


    }
}
