package com.example.last_project.request;

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

public class RequestCancelActivity extends AppCompatActivity {

    LinearLayout ln_request_cancel_no, ln_request_cancel_yes;
    final int DELETE_WORD = 1;
    final int CANCEL = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);


        WindowManager.LayoutParams param = getWindow().getAttributes();
        param.width = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().setStatusBarColor(Color.parseColor("#020E20"));
        getWindow().setAttributes(param);
        getWindow().getAttributes().gravity = Gravity.BOTTOM;
        setContentView(R.layout.activity_reqeuest_cancel);

        ln_request_cancel_yes  = findViewById(R.id.ln_request_cancel_yes);
        ln_request_cancel_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(DELETE_WORD);
                finish();
                overridePendingTransition(0, 0);
            }
        });

        //아니오 버튼 눌렀을 때
        ln_request_cancel_no  = findViewById(R.id.ln_request_cancel_no);
        ln_request_cancel_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                setResult(CANCEL);
                overridePendingTransition(0, 0);
            }
        });
    }

    //뒤로가기 버튼 눌렀을 경우 엑티비티 종료시 에니메이션 막기
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            finish();
            overridePendingTransition(0, 0);
        }
        return true;
    }
}