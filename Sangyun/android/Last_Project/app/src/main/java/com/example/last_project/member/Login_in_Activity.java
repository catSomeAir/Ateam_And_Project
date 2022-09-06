package com.example.last_project.member;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;
import com.example.last_project.common.CommonVal;
import com.example.last_project.conn.CommonConn;
import com.google.gson.Gson;

public class Login_in_Activity extends AppCompatActivity {
    EditText login_edt_id, login_edt_pw;
    Button btn_login_local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_in);
        overridePendingTransition(0,R.anim.slideing_right_exit);
        //로그인, 비번 edittext
        login_edt_id = findViewById(R.id.login_edt_id);
        login_edt_pw = findViewById(R.id.login_edt_pw);


        //로그인 버튼 클릭 : 로그인시도
        btn_login_local = findViewById(R.id.btn_login_local);

        btn_login_local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonConn conn = new CommonConn(Login_in_Activity.this , "login.me");
                conn.addParams("email", login_edt_id.getText().toString());
                conn.addParams("pw", login_edt_pw.getText().toString());
                conn.executeConn(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {
                        if(isResult){
                            if(data == null){
                                Toast.makeText(Login_in_Activity.this, "회원정보가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(Login_in_Activity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                                CommonVal.userInfo = new Gson().fromJson(data, MemberVO.class);
                                setResult(1);   //종료하면 LoginActivity 로 가는데 1을 들고가면 여기서 로그인해서 나간거
                                finish();
//                            {
//                            }.getType());
                            }
                        }else {
                            Toast.makeText(Login_in_Activity.this ,"로그인실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}