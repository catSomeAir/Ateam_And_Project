package com.example.last_project.member;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;
import com.example.last_project.common.CommonMethod;
import com.example.last_project.common.CommonVal;
import com.example.last_project.conn.CommonConn;
import com.google.gson.Gson;

public class Login_in_Activity extends AppCompatActivity {
    EditText login_edt_id, login_edt_pw;
    Button btn_login_local;
    CheckBox chkbox_login_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_in);
        overridePendingTransition(0,R.anim.slideing_right_exit);
        //로그인, 비번 edittext
        login_edt_id = findViewById(R.id.login_edt_id);
        login_edt_pw = findViewById(R.id.login_edt_pw);

        //자동로그인 체크박스
        chkbox_login_in = findViewById(R.id.chkbox_login_in);

        SharedPreferences preferences = getSharedPreferences("login",MODE_PRIVATE);
        String email = preferences.getString("email", "none");
        String pw = preferences.getString("pw", "none");

        if(!email.equals("none")&&!pw.equals("none")){
            chkbox_login_in.setChecked(true);
            login_edt_id.setText(email);
            login_edt_pw.setText(pw);
            login();

        }

        //로그인 버튼 클릭 : 로그인시도
        btn_login_local = findViewById(R.id.btn_login_local);

        btn_login_local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CommonMethod.isCheckEditText(login_edt_id) && CommonMethod.isCheckEditText(login_edt_pw)) {
                    login();
                }
                else {
                    Toast.makeText(Login_in_Activity.this, "아이디와 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    public void login(){
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
                        if(chkbox_login_in.isChecked()){
                            saveLoginInfo();
                        }
                        setResult(1);   //종료하면 LoginActivity 로 가는데 1을 들고가면 여기서 로그인해서 나간거
                        finish();

                    }
                }else {
                    Toast.makeText(Login_in_Activity.this ,"로그인실패", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //자동로그인 메소드
    public void saveLoginInfo() {
        SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();   // Editer 객체를 리턴하는 메소드
        editor.putString("email", CommonVal.userInfo.getEmail());
        editor.putString("pw", CommonVal.userInfo.getPw());
        editor.putString("social_code","0");
        editor.apply();
    }
}