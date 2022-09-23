package com.example.last_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.category.CategoryActivity;
import com.example.last_project.main.manysearch.ManySearchAdapter;
import com.example.last_project.main.tab.Main_Tab_HomeFragment;
import com.example.last_project.search.SearchActivity;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ImageView imgv_main_category;
    TabLayout tabs;
    LinearLayout ln_main_search;
    RecyclerView recv_main_manysearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //val <=  var
        //interface
        //메인 탭레이아웃--------------------------------------------------------------------
        tabs =findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("홈").setTag(1));
        tabs.addTab(tabs.newTab().setText("나의설명서").setTag(2));
        tabs.addTab(tabs.newTab().setText("최근").setTag(3));
        tabs.getTabAt(0).select();

        getSupportFragmentManager().beginTransaction().replace(R.id.container_main, new Main_Tab_HomeFragment()).commit();

        //탭레이아웃 선택 이벤트
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //-------------------------------------------------------------------------------------

        //카테고리 버튼 선택
        imgv_main_category = findViewById(R.id.imgv_main_category);
        imgv_main_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slideing_left_enter, R.anim.hold);
            }
        });

        //검색란 터치
        ln_main_search = findViewById(R.id.ln_main_search);
        ln_main_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        //많이 검색한목록
        recv_main_manysearch = findViewById(R.id.recv_main_manysearch);
        ManySearchAdapter adapter = new ManySearchAdapter(getLayoutInflater());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL , false);
        recv_main_manysearch.setLayoutManager(manager);
        recv_main_manysearch.setAdapter(adapter);


    }


}









