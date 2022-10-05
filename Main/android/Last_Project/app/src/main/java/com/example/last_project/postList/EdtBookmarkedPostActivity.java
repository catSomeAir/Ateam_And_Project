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
import com.example.last_project.postList.adapter.EdtBookmarkedPostAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class EdtBookmarkedPostActivity extends AppCompatActivity {
    RecyclerView rv_edt_bookmarked_post;
    ImageView imgv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edt_bookmarked_post);
        rv_edt_bookmarked_post = findViewById(R.id.rv_edt_bookmarked_post);
        imgv_back =findViewById(R.id.imgv_back);

        CommonConn conn = new CommonConn(EdtBookmarkedPostActivity.this,"bookmarkedpost");
        conn.addParams("email", CommonVal.userInfo.getEmail());
        conn.executeConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                Log.d("result", "onResult: "+isResult);
                ArrayList<BookmarkedPostVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<BookmarkedPostVO>>(){}.getType());
                EdtBookmarkedPostAdapter adapter = new EdtBookmarkedPostAdapter(getLayoutInflater(),list,getApplicationContext());
                RecyclerView.LayoutManager manager = new LinearLayoutManager(EdtBookmarkedPostActivity.this,RecyclerView.VERTICAL, false);
                rv_edt_bookmarked_post.setAdapter(adapter);
                rv_edt_bookmarked_post.setLayoutManager(manager);
            }
        });

        //뒤로 가기 버튼 누르면 뒤로감
        imgv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}