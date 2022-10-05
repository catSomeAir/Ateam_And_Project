package com.example.last_project.postList;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.common.CommonVal;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.postList.adapter.DownloadedManualAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class DownloadedManualActivity extends AppCompatActivity {
    RecyclerView rv_downloaded_manual;
    ImageView imgv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloaded_manual);
        rv_downloaded_manual = findViewById(R.id.rv_downloaded_manual);
        imgv_back = findViewById(R.id.imgv_back);

        CommonConn conn = new CommonConn(DownloadedManualActivity.this,"downloads");
        conn.addParams("email", CommonVal.userInfo.getEmail());
        conn.executeConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                Log.d("result", "onResult: "+isResult);
                ArrayList<BookmarkedPostVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<BookmarkedPostVO>>(){}.getType());
                DownloadedManualAdapter adapter = new DownloadedManualAdapter(getLayoutInflater(),list);
                RecyclerView.LayoutManager manager = new LinearLayoutManager(DownloadedManualActivity.this,RecyclerView.VERTICAL, false);
                rv_downloaded_manual.setAdapter(adapter);
                rv_downloaded_manual.setLayoutManager(manager);
            }
        });

        //뒤로가기버튼 누르면 뒤로감
        imgv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}