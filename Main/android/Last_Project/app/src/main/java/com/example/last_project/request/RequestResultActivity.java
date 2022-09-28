package com.example.last_project.request;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;

public class RequestResultActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_request_confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_result);
        btn_request_confirm = findViewById(R.id.btn_request_confirm);
        btn_request_confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_request_confirm){
            setResult(3);
            overridePendingTransition(0, 0);
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            setResult(3);
            overridePendingTransition(0, 0);
            finish();
        }
        return true;
    }
}