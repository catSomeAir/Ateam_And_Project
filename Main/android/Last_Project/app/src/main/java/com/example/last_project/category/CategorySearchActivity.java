package com.example.last_project.category;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.search.category_search.CategorySearchResultAdapter;
import com.example.last_project.search.category_search.CategorySearchVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class CategorySearchActivity extends AppCompatActivity {

    RecyclerView recv_category_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_search);

        recv_category_search = findViewById(R.id.recv_category_search);

        //카테고리 선택해서 검색되도록하기
        String m_category = getIntent().getStringExtra("m_category");
        CommonConn conn = new CommonConn(CategorySearchActivity.this, "list.mo");
        conn.addParams("m_name",m_category);
        conn.executeConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                if(isResult){
                    ArrayList<CategorySearchVO> list = new Gson().fromJson(data,
                            new TypeToken<ArrayList<CategorySearchVO>>() {
                            }.getType());

                    CategorySearchResultAdapter adapter = new CategorySearchResultAdapter(getLayoutInflater(),list, CategorySearchActivity.this);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(CategorySearchActivity.this, RecyclerView.VERTICAL, false);
                    recv_category_search.setLayoutManager(manager);
                    recv_category_search.setAdapter(adapter);
                }
            }
        });



    }
}