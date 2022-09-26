package com.example.last_project.member.join;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;

public class JoinActivity extends AppCompatActivity {

    EditText join_edt_email, join_edt_pw, join_edt_pw_check;
    Button join_btn_next;
    ImageView imgv_profile;
    TextView join_tv_pw_confirm, join_tv_pw_check_confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        getSupportFragmentManager().beginTransaction().replace(R.id.member_join_container, new Join_main_Fragment()).commit();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//키보드 위 레이아웃 크기 변화를 위해 추가

        join_btn_next = findViewById(R.id.join_btn_next);
        join_edt_email = findViewById(R.id.join_edt_email);
        join_edt_pw = findViewById(R.id.join_edt_pw);
        join_edt_pw_check = findViewById(R.id.join_edt_pw_check);
        join_tv_pw_confirm = findViewById(R.id.join_tv_pw_confirm);
        join_tv_pw_check_confirm = findViewById(R.id.join_tv_pw_check_confirm);
        join_btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(true) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.member_join_container, new Join_Password_Fragment()).commit();


                }
//                if( join_edt_email.getText() != null ){
//                }else {
//                    //이메일 입력양식 체크후 메세지 띄울 예정 - HAI
//
//                }
//
//                if(join_edt_pw.getText() != null) {
//
//
//                }


            }
        });
//        join_edt_pw.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
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