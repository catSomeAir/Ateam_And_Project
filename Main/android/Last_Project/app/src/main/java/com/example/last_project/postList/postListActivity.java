package com.example.last_project.postList;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;
import com.google.android.material.tabs.TabLayout;

public class postListActivity extends AppCompatActivity {
    FrameLayout container;
    String selected ="";
    ImageView imgv_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);
        container = findViewById(R.id.container_post_list);
        imgv_back = findViewById(R.id.imgv_back);


        Intent intent = getIntent();
        selected = intent.getStringExtra("1");
        TabLayout tabLayout = findViewById(R.id.tabs) ;
        if(selected != null){
            if(selected.equals("0")){
                tabLayout.selectTab(tabLayout.getTabAt(0));
            }else if(selected.equals("1")){
                tabLayout.selectTab(tabLayout.getTabAt(1));
            }
        }


        getSupportFragmentManager().beginTransaction().replace(R.id.container_post_list, new myPostFragment()).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if (tab.getPosition() == 0) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_post_list, new myPostFragment()).commit();
                    //내가 쓴 댓글 나오게
                } else if (tab.getPosition() == 1) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_post_list, new myReplyFragment()).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }


        });

        imgv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,0);
            }
        });


    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            finish();
            overridePendingTransition(0, R.anim.slideing_up_exit);
        }
        return true;
    }
}