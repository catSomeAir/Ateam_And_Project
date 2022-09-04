package com.example.last_project.category;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.category.recyclerview.CategoryAdapter;
import com.example.last_project.category.recyclerview.CategoryVO;
import com.example.last_project.conn.CommonConn;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recv_l_category;
    ArrayList<CategoryVO> l_list = new ArrayList<>();
    ArrayList<CategoryVO> m_list = new ArrayList<>();
    CategoryAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        //카테고리 대분류 리사이클러뷰
        recv_l_category = findViewById(R.id.recv_l_category);


        CommonConn conn = new CommonConn(CategoryActivity.this, "llist.ct");
        conn.executeConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                if(isResult){
                    l_list = new Gson().fromJson(data, new TypeToken<ArrayList<CategoryVO>>(){}.getType());
                    adapter = new CategoryAdapter(getLayoutInflater(),CategoryActivity.this,  l_list);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(CategoryActivity.this, RecyclerView.VERTICAL, false);
                    recv_l_category.setLayoutManager(manager);
                    recv_l_category.setAdapter(adapter);
                }
            }
        });

//        CommonConn conn1 = new CommonConn(CategoryActivity.this, "mlist.ct");
//        conn1.executeConn(new CommonConn.ConnCallback() {
//            @Override
//            public void onResult(boolean isResult, String data) {
//                if(isResult){
//                    m_list = new Gson().fromJson(data, new TypeToken<ArrayList<CategoryVO>>(){}.getType());
////                    adapter = new CategoryAdapter(getLayoutInflater(),CategoryActivity.this, l_list, m_list);
//
//                }
//            }
//        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,R.anim.slideing_right_exit);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.tv_l_name){
            for(int i = 0 ; i < 20; i ++){
//                    if(v.getTag().equals(i)){
//
//                    }
////
////                }
            }
        }
    }
}