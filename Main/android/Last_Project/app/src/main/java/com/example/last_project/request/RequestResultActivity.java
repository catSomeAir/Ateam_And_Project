package com.example.last_project.request;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;

public class RequestResultActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imgv_request_back ;
    Button btn_request_confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_result);
        imgv_request_back = findViewById(R.id.imgv_request_back);
        btn_request_confirm = findViewById(R.id.btn_request_confirm);
        imgv_request_back.setOnClickListener(this);
        btn_request_confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_request_confirm){
            setResult(1);
            finish();
        }else if(v.getId() == R.id.imgv_request_back){
            setResult(1);
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            finish();
            overridePendingTransition(0, 0);
        }
        return true;
    }
}