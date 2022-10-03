package com.example.last_project;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CommonAlertActivity extends AppCompatActivity {
    LinearLayout ln_no, ln_yes;
    TextView tv_target, tv_explain1, tv_explain2, tv_yes;
    View view_center_line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);



        WindowManager.LayoutParams param = getWindow().getAttributes();
        param.width = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().setStatusBarColor(Color.parseColor("#020E20"));
        getWindow().setAttributes(param);
        getWindow().getAttributes().gravity = Gravity.BOTTOM;
        setContentView(R.layout.activity_common_alert);
        
        //넘어오는 곳 지정
        String page = getIntent().getStringExtra("page");
        
        //설명멘트
        tv_target = findViewById(R.id.tv_target);
        tv_explain1 = findViewById(R.id.tv_explain1);
        tv_explain2 = findViewById(R.id.tv_explain2);
        tv_yes = findViewById(R.id.tv_yes);

        //중앙선
        view_center_line = findViewById(R.id.view_center_line);

        ln_yes = findViewById(R.id.ln_yes);
        ln_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(page.equals("WriteSpaceActivity_success")||page.equals("WriteSpaceActivity_comment")){
                    setResult(1);//종료해라
                }
                finish();
                overridePendingTransition(0, 0);
            }
        });
        ln_no = findViewById(R.id.ln_no);
        ln_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0, 0);
            }
        });

       

        if(page.equals("WriteSpaceActivity")){
            tv_target.setText("글목록");
            tv_explain1.setText("을 선택해주세요");
            tv_explain2.setVisibility(View.INVISIBLE);
            view_center_line.setVisibility(View.GONE);
            ln_no.setVisibility(View.GONE);
            tv_yes.setText("확인");
        }
        if(page.equals("WriteSpaceActivity_empty")){
            tv_target.setText("내용");
            tv_explain1.setText("을 입력해주세요");
            tv_explain2.setVisibility(View.INVISIBLE);

            view_center_line.setVisibility(View.GONE);
            ln_no.setVisibility(View.GONE);
            tv_yes.setText("확인");
        }
        //글쓰기 댓글쓰기
        if(page.equals("WriteSpaceActivity_success")||page.equals("WriteSpaceActivity_comment")){
            tv_target.setText("등록되었습니다");
            tv_explain1.setText("을 입력해주세요");
            tv_explain1.setVisibility(View.GONE);

            tv_explain2.setVisibility(View.INVISIBLE);

            view_center_line.setVisibility(View.GONE);
            ln_no.setVisibility(View.GONE);
            tv_yes.setText("확인");
        }



    }
}