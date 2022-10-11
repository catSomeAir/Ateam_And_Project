package com.example.last_project.news;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;

public class NewsSpinerActivity extends AppCompatActivity {

    View view_news_spinner_background;
    LinearLayout ln_news_spinner_all, ln_news_spinner_reply, ln_news_spinner_request, ln_news_spinner_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);


        WindowManager.LayoutParams param = getWindow().getAttributes();
        param.width = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().setStatusBarColor(Color.parseColor("#00000000"));
        getWindow().setAttributes(param);
        getWindow().getAttributes().gravity = Gravity.BOTTOM;

        setContentView(R.layout.activity_news_spiner);

        view_news_spinner_background = findViewById(R.id.view_news_spinner_background);
        view_news_spinner_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,R.anim.slideing_up_exit);
            }
        });

        ln_news_spinner_all = findViewById(R.id.ln_news_spinner_all);
        ln_news_spinner_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(1);
                finish();
                overridePendingTransition(0,R.anim.slideing_up_exit);

            }
        });
        ln_news_spinner_reply = findViewById(R.id.ln_news_spinner_reply);
        ln_news_spinner_reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(2);
                finish();
                overridePendingTransition(0,R.anim.slideing_up_exit);

            }
        });
        ln_news_spinner_request = findViewById(R.id.ln_news_spinner_request);
        ln_news_spinner_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(3);
                finish();
                overridePendingTransition(0,R.anim.slideing_up_exit);

            }
        });
        ln_news_spinner_cancel = findViewById(R.id.ln_news_spinner_cancel);

        ln_news_spinner_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,R.anim.slideing_up_exit);
            }
        });





    }


    //뒤로가기 버튼 눌렀을 경우 엑티비티 종료시 에니메이션 막기
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            finish();
            overridePendingTransition(0, R.anim.slideing_up_exit);
        }
        return true;
    }
}