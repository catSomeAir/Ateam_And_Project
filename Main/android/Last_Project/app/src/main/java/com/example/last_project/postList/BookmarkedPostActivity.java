package com.example.last_project.postList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.common.CommonVal;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.postList.adapter.BookmarkedPostAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class BookmarkedPostActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView bookmarked_post_recv;
    ImageView imgv_back;
    Button btn_edt_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarked_post);
        bookmarked_post_recv =findViewById(R.id.bookmarked_post_recv);
        btn_edt_list =findViewById(R.id.btn_edt_list);
        imgv_back = findViewById(R.id.imgv_back);

         CommonConn conn = new CommonConn(BookmarkedPostActivity.this,"bookmarkedpost");
         conn.addParams("email", CommonVal.userInfo.getEmail());
            conn.executeConn(new CommonConn.ConnCallback() {
                @Override
                public void onResult(boolean isResult, String data) {
                    Log.d("result", "onResult: "+isResult);
                    ArrayList<BookmarkedPostVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<BookmarkedPostVO>>(){}.getType());
                    BookmarkedPostAdapter adapter = new BookmarkedPostAdapter(getLayoutInflater(),list,getApplicationContext());
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(BookmarkedPostActivity.this,RecyclerView.VERTICAL, false);
                    bookmarked_post_recv.setAdapter(adapter);
                    bookmarked_post_recv.setLayoutManager(manager);
                }
            });


        btn_edt_list.setOnClickListener(this);
        imgv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(BookmarkedPostActivity.this, EdtBookmarkedPostActivity.class);
        startActivity(intent);
    }
}