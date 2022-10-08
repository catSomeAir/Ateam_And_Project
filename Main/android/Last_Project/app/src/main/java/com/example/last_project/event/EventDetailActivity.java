package com.example.last_project.event;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;

public class EventDetailActivity extends AppCompatActivity {
    ImageView imgv_event_detail, imgv_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
         /*메인에서 이벤트 배너 누르면 나오는 상세 페이지*/
        String index = getIntent().getStringExtra("index");
        imgv_event_detail = findViewById(R.id.imgv_event_detail);
        imgv_back = findViewById(R.id.imgv_back);
        imgv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if(index!=null){
            if(index.equals("0")){
                imgv_event_detail.setImageResource(R.drawable.main_tab_banner_detailpage);
            }else if(index.equals("1")){
                imgv_event_detail.setImageResource(R.drawable.eventbannerdetail);

            }
        }
    }
}