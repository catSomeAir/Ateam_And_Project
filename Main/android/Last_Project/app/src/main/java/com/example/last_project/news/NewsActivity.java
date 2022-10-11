package com.example.last_project.news;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;
import com.example.last_project.common.CommonVal;

public class NewsActivity extends AppCompatActivity {
ImageView imgv_news_x;
LinearLayout ln_news_category;
TextView tv_news_category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        imgv_news_x = findViewById(R.id.imgv_news_x);
        tv_news_category = findViewById(R.id.tv_news_category);

        //스피너 역할
        ln_news_category = findViewById(R.id.ln_news_category);

        imgv_news_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,0);
            }
        });





        ln_news_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsActivity.this, NewsSpinerActivity.class);
                overridePendingTransition(R.anim.slideing_down_enter, 0);
                startActivityForResult(intent, 0);
            }
        });

        //새로운 알림이 있을때
        if(CommonVal.alarm_list.size()!=0){
            getSupportFragmentManager().beginTransaction().replace(R.id.container_news, new NewsExistFragment()).commit();
        }else{
            //새로운 알림이 없을 때
            getSupportFragmentManager().beginTransaction().replace(R.id.container_news, new NewsNotExistFragment()).commit();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){ // 전체
            tv_news_category.setText("전체");
        }else if(resultCode == 2){//글
            tv_news_category.setText("댓글");

        }else if(resultCode == 3){//요청설명서 처리
            tv_news_category.setText("요청사항");

        }
    }
}