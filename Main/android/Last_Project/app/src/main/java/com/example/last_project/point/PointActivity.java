package com.example.last_project.point;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;
import com.example.last_project.common.CommonMethod;
import com.example.last_project.common.CommonVal;

public class PointActivity extends AppCompatActivity {
    TextView tv_point_enable;
    ImageView imgv_point_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);
        tv_point_enable = findViewById(R.id.tv_point_enable);
        imgv_point_back = findViewById(R.id.imgv_point_back);

        if(CommonVal.userInfo.getPoint()!=null){
            tv_point_enable.setText(CommonMethod.makeStringComma(CommonVal.userInfo.getPoint()) );
        }

        imgv_point_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0, 0);
            }
        });
    }
}