package com.example.last_project.member.join;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.member.MemberVO;
import com.google.gson.Gson;

public class JoinActivity extends AppCompatActivity {

    EditText join_edt_email, join_edt_pw, join_edt_pw_check, join_edt_name, join_edt_nickname;
    Button join_btn_signup;
    ImageView imgv_profile;
    TextView join_tv_pw_confirm, join_tv_pw_check_confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
//        getSupportFragmentManager().beginTransaction().replace(R.id.member_join_container, new Join_main_Fragment()).commit();
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//키보드 위 레이아웃 크기 변화를 위해 추가

        join_btn_signup = findViewById(R.id.join_btn_signup);
        join_edt_email = findViewById(R.id.join_edt_email);
        join_edt_pw = findViewById(R.id.join_edt_pw);
        join_edt_pw_check = findViewById(R.id.join_edt_pw_check);
        join_edt_name = findViewById(R.id.join_edt_name);
        join_edt_nickname = findViewById(R.id.join_edt_nickname);
        join_tv_pw_confirm = findViewById(R.id.join_tv_pw_confirm);
        join_tv_pw_check_confirm = findViewById(R.id.join_tv_pw_check_confirm);
        join_btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MemberVO vo = new MemberVO();
//                vo.setEmail(join_edt_email.getText()+"");
//                vo.setPw(join_edt_pw.getText()+"");
//                vo.setName(join_edt_name.getText()+"");
//                vo.setNickname(join_edt_nickname.getText()+"");

                vo.setEmail("email");
                vo.setPw("pw");
                vo.setName("name");
                vo.setNickname("nickname");


                CommonConn conn = new CommonConn(JoinActivity.this, "join.me");
                conn.addParams("vo", new Gson().toJson(vo));
                conn.executeConn(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {
                        Log.d("성공?", "onResult: "+isResult);
                    }
                });


            }
        });
//        join_edt_pw.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                  //입력하기 전 조치
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
                  //입력할때 변화에 대한 조치
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
                  //입력이 끝난 후 조치
//                //비밀번호 입력과 확인을 거친 후 일치 시 -> 회원 이름 및 연락처를 기입할 화면으로 전환
//                if(join_edt_pw.getText().toString().equals(join_edt_pw_check.getText().toString())){
//                    join_tv_pw_check_confirm.setText("비밀번호가 일치합니다.");
//                    join_tv_pw_check_confirm.setTextColor(Integer.parseInt("red"));
//                    join_btn_next.setEnabled(true); // 버튼 비활성화 기능
//                    getSupportFragmentManager().beginTransaction().replace(R.id.member_join_container, new Join_UserInfo_Fragment()).commit();
//                }
//
//            }
//        });



    }
}