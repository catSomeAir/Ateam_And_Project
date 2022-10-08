package com.example.last_project.member.join;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.member.MemberVO;
import com.example.last_project.request.RequestEmptyActivity;
import com.google.gson.Gson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JoinActivity extends AppCompatActivity {

    EditText join_edt_email, join_edt_pw, join_edt_pw_check, join_edt_name, join_edt_nickname, join_edt_phone;
    Button join_btn_signup, join_btn_dialog1, join_btn_dialog2;
    ImageView join_imgv_back;
    TextView join_tv_pw_confirm, join_tv_pw_check_confirm, join_tv_email_confirm;
    Dialog join_dialog;
    String search_text = "";
    String search_div_text = "";
    boolean bool, bool_pw, bool_pw_chk, bool_email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        join_btn_signup = findViewById(R.id.join_btn_signup);
        join_edt_email = findViewById(R.id.join_edt_email);
        join_tv_email_confirm = findViewById(R.id.join_tv_email_confirm);
        join_edt_pw = findViewById(R.id.join_edt_pw);
        join_edt_pw_check = findViewById(R.id.join_edt_pw_check);
        join_edt_name = findViewById(R.id.join_edt_name);
        join_edt_nickname = findViewById(R.id.join_edt_nickname);
        join_edt_phone = findViewById(R.id.join_edt_phone);
        join_tv_pw_confirm = findViewById(R.id.join_tv_pw_confirm);
        join_tv_pw_check_confirm = findViewById(R.id.join_tv_pw_check_confirm);
        join_imgv_back = findViewById(R.id.join_imgv_back);

        join_imgv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        join_edt_email.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = join_edt_email.getText().toString();
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    join_tv_email_confirm.setText("올바른 이메일 형식이 아닙니다");
                    join_tv_email_confirm.setTextColor(Color.parseColor("red"));
                    bool = false;
//                    Toast.makeText(SignupActivity.this,"이메일 형식이 아닙니다",Toast.LENGTH_SHORT).show();
//                    dialog.dismiss();
                    return;
                } else {
                    join_tv_email_confirm.setText("사용가능한 이메일 형식입니다");
                    join_tv_email_confirm.setTextColor(Color.parseColor("#FF102BB6"));
                    bool = true;
                }


            }

            @Override
            public void afterTextChanged(Editable s) {
                if (bool == true) {
                    CommonConn conn = new CommonConn(JoinActivity.this, "email_check.me");
                    search_text = join_edt_email.getText().toString();
                    conn.addParams("email", join_edt_email.getText().toString());
                    conn.executeConn_no_dialog(new CommonConn.ConnCallback() {
                        @Override
                        public void onResult(boolean isResult, String data) {
                            if (isResult) {

                                if (data.equals("0")) {
                                    join_tv_email_confirm.setText("사용가능한 이메일니다");
                                    join_tv_email_confirm.setTextColor(Color.parseColor("#FF102BB6"));
                                    bool_email = true;

                                } else {
                                    join_tv_email_confirm.setText("중복된 이메일입니다 다시 입력해주세요");
                                    join_tv_email_confirm.setTextColor(Color.parseColor("red"));
                                    bool_email = false;

                                }

                            }

                        }

                    });
                }
            }
        });


        join_edt_pw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String pw = join_edt_pw.getText().toString();
                if (!Pattern.matches("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{8,20}$", pw)) {
                    join_tv_pw_confirm.setText("비밀번호 형식을 지켜주세요");
                    join_tv_pw_confirm.setTextColor(Color.parseColor("red"));
//                    Toast.makeText(JoinActivity.this,"비밀번호 형식을 지켜주세요.",Toast.LENGTH_SHORT).show();
//                    dialog.dismiss();
                    bool_pw = false;
                    return;
                } else {
                    join_tv_pw_confirm.setText("사용가능한 비밀번호입니다");
                    join_tv_pw_confirm.setTextColor(Color.parseColor("#FF102BB6"));
                    bool_pw = true;
                }

                if (join_edt_pw.getText().toString().equals(join_edt_pw_check.getText().toString())) {
                    join_tv_pw_check_confirm.setText("비밀번호가 일치합니다");
                    join_tv_pw_check_confirm.setTextColor(Color.parseColor("#FF102BB6"));
                    join_btn_signup.setEnabled(true); // 버튼 비활성화 기능
//                    getSupportFragmentManager().beginTransaction().replace(R.id.member_join_container, new Join_UserInfo_Fragment()).commit();
                    bool_pw_chk= true;
                } else {
                    join_tv_pw_check_confirm.setText("비밀번호가 일치하지않습니다");
                    join_tv_pw_check_confirm.setTextColor(Color.parseColor("red"));
                    bool_pw_chk= false;
                }
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        join_edt_pw_check.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                  입력하기 전 조치
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //입력할때 변화에 대한 조치
                //비밀번호 유효성
                String pw = join_edt_pw_check.getText().toString();
                if (!Pattern.matches("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{8,20}$", pw)) {
                    join_tv_pw_check_confirm.setText("비밀번호 형식을 지켜주세요");
                    join_tv_pw_check_confirm.setTextColor(Color.parseColor("red"));
                    join_btn_signup.setEnabled(false);
//                    Toast.makeText(JoinActivity.this,"비밀번호 형식을 지켜주세요.",Toast.LENGTH_SHORT).show();
//                    dialog.dismiss();
                    return;
                }
//                if(){
//
//                }


                if (join_edt_pw.getText().toString().equals(join_edt_pw_check.getText().toString())) {
                    join_tv_pw_check_confirm.setText("비밀번호가 일치합니다");
                    join_tv_pw_check_confirm.setTextColor(Color.parseColor("#FF102BB6"));
                    join_btn_signup.setEnabled(true); // 버튼 비활성화 기능
//                    getSupportFragmentManager().beginTransaction().replace(R.id.member_join_container, new Join_UserInfo_Fragment()).commit();
                    bool_pw_chk= true;
                } else {
                    join_tv_pw_check_confirm.setText("비밀번호가 일치하지않습니다");
                    join_tv_pw_check_confirm.setTextColor(Color.parseColor("red"));
                    bool_pw_chk= false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //입력이 끝난 후 조치
                //비밀번호 입력과 확인을 거친 후 일치 시 -> 회원 이름 및 연락처를 기입할 화면으로 전환 => 화면 통일로 보류함
                if (join_edt_pw.getText().toString().equals(join_edt_pw_check.getText().toString())) {

                    join_tv_pw_check_confirm.setText("비밀번호가 일치합니다.");
                    join_tv_pw_check_confirm.setTextColor(Color.parseColor("#FF102BB6"));
                    join_btn_signup.setEnabled(true); // 버튼 비활성화 기능
                    bool_pw_chk= true;
//                    getSupportFragmentManager().beginTransaction().replace(R.id.member_join_container, new Join_UserInfo_Fragment()).commit();
                } else {
                    join_tv_pw_check_confirm.setText("비밀번호가 일치하지않습니다.");
                    join_tv_pw_check_confirm.setTextColor(Color.parseColor("red"));
                    bool_pw_chk= false;
                }

            }
        });
        join_btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emptyEdittext()){
                    MemberVO vo = new MemberVO();
                    vo.setEmail(join_edt_email.getText() + "");
                    vo.setPw(join_edt_pw.getText() + "");
                    vo.setName(join_edt_name.getText() + "");
                    vo.setNickname(join_edt_nickname.getText() + "");
                    vo.setPhone(join_edt_phone.getText() + "");


                    CommonConn conn = new CommonConn(JoinActivity.this, "join.me");
                    conn.addParams("vo", new Gson().toJson(vo));
                    conn.executeConn(new CommonConn.ConnCallback() {
                        @Override
                        public void onResult(boolean isResult, String data) {
                            if (data != null) {
                                if (data.equals("1")) {
//                                Intent intent = new Intent(JoinActivity.this, MainActivity.class);
//                                startActivity(intent);
                                    setResult(1);
                                    finish();
                                }
                            }
                        }
                    });
                }



            }
        });


        join_dialog = new

                Dialog(JoinActivity.this);
        join_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        join_dialog.setContentView(R.layout.join_dialog);
        join_imgv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showJoinDialog();
            }
        });
    }

    public boolean emptyEdittext() {
        Intent intent = new Intent(JoinActivity.this, RequestEmptyActivity.class);
        if (join_edt_email.getText().toString().length() == 0) {
            intent.putExtra("text", "이메일이 입력되지 않았습니다");
            startActivity(intent);
            return false;
        } else if (join_edt_pw.getText().toString().length() == 0) {
            intent.putExtra("text", "비밀번호가 입력되지 않았습니다");
            startActivity(intent);
            return false;
        } else if (join_edt_pw_check.getText().toString().length() == 0) {
            intent.putExtra("text", "비밀번호가 확인되지 않았습니다");
            startActivity(intent);
            return false;
        } else if (join_edt_name.getText().toString().length() == 0) {
            intent.putExtra("text", "이름이 입력되지 않았습니다");
            startActivity(intent);
            return false;
        } else if (join_edt_nickname.getText().toString().length() == 0) {
            intent.putExtra("text", "닉네임이 입력되지 않았습니다");
            startActivity(intent);
            return false;
        } else if (join_edt_phone.getText().toString().length() == 0) {
            intent.putExtra("text", "연락처가 입력되지 않았습니다");
            startActivity(intent);
            return false;
        } else if( !bool){
            intent.putExtra("text", "올바르지 않은 이메일입니다");
            startActivity(intent);
            return false;
        } else if( !bool_email){
            intent.putExtra("text", "증복된 이메일입니다");
            startActivity(intent);
            return false;
        } else if( !bool_pw){
            intent.putExtra("text", "올바르지 않은 비밀번호형식입니다");
            startActivity(intent);
            return false;
        } else if( !bool_pw_chk){
            intent.putExtra("text", "비밀번호가 일치하지 않습니다");
            startActivity(intent);
            return false;
        } else if( !bool_email){
            intent.putExtra("text", "증복된 이메일입니다");
            startActivity(intent);
            return false;
        }

        return true;
    }

    public void showJoinDialog() {
        join_dialog.show();
        join_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        join_dialog.findViewById(R.id.join_btn_dialog1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                join_dialog.dismiss();//취소 버튼 터치 -> 기존 화면 유지

            }
        });

        join_dialog.findViewById(R.id.join_btn_dialog2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                join_dialog.dismiss();
                finish();//확인 버튼 터치 -> 이전 화면 이동
            }
        });

    }

    void check_validation(String email, String password) {
        // 비밀번호 유효성 검사식1 : 숫자, 특수문자가 포함되어야 한다.
        String val_symbol = "([0-9].*[!,@,#,^,&,*,(,)])|([!,@,#,^,&,*,(,)].*[0-9])";
        // 비밀번호 유효성 검사식2 : 영문자 대소문자가 적어도 하나씩은 포함되어야 한다.
        String val_alpha = "([a-z].*[A-Z])|([A-Z].*[a-z])";
        // 정규표현식 컴파일
        Pattern pattern_symbol = Pattern.compile(val_symbol);
        Pattern pattern_alpha = Pattern.compile(val_alpha);

        Matcher matcher_symbol = pattern_symbol.matcher(password);
        Matcher matcher_alpha = pattern_alpha.matcher(password);

        if (matcher_symbol.find() && matcher_alpha.find()) {
            // email과 password로 회원가입 진행
//            email_signIn(email, password);

        } else {
            Toast.makeText(this, "비밀번호로 부적절합니다", Toast.LENGTH_SHORT).show();
        }

    }
}