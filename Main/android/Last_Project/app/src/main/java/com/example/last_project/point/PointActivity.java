package com.example.last_project.point;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;
import com.example.last_project.common.CommonVal;

public class PointActivity extends AppCompatActivity {
    TextView tv_point_enable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);
        tv_point_enable = findViewById(R.id.tv_point_enable);

        if(CommonVal.userInfo.getPoint()!=null){
            tv_point_enable.setText(CommonVal.userInfo.getPoint());
        }

    }
}