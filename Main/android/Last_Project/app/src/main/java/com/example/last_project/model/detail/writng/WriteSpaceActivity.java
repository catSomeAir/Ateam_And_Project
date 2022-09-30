package com.example.last_project.model.detail.writng;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.last_project.CommonAlertActivity;
import com.example.last_project.R;
import com.example.last_project.common.CommonVal;
import com.example.last_project.conn.CommonConn;
import com.google.gson.Gson;

public class WriteSpaceActivity extends AppCompatActivity {
    EditText edt_writing;
    RadioGroup radiogroup_writting;
    RadioButton radio_all, radio_opinion, radio_qna;
    LinearLayout ln_write_commit; //등록버튼
    View space_background;
    ImageView imgv_profile;
    String model_code, radio_type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_space);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        edt_writing = findViewById(R.id.edt_writing);

        //해당 모델코드
        model_code = getIntent().getStringExtra("model_code");

        space_background = findViewById(R.id.space_background);
        //백그라운드 터치시 종료시키기
        space_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.hideSoftInputFromWindow(edt_writing.getWindowToken(), 0);
                finish();
            }
        });

        imgv_profile = findViewById(R.id.imgv_profile);
        //프로필 이미지 등록
        if(CommonVal.userInfo.getFilepath() != null){
            Glide.with(WriteSpaceActivity.this).load(CommonVal.userInfo.getFilepath()).into(imgv_profile);
//            Glide.with(getContext()).load(model_info.getFilepath().replace("localhost","192.168.0.33")).into(imgv_manual_photo);
        }

        ln_write_commit = findViewById(R.id.ln_write_commit);


        edt_writing.requestFocus();
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        edt_writing.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(edt_writing.getText().length() == 0){
                    ln_write_commit.setVisibility(View.GONE);
                }else{
                    ln_write_commit.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //버튼
        radiogroup_writting = findViewById(R.id.radiogroup_writting);
        radio_all = findViewById(R.id.radio_all);
        radio_opinion = findViewById(R.id.radio_opinion);
        radio_qna = findViewById(R.id.radio_qna);
        radiogroup_writting.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (group.getCheckedRadioButtonId() == R.id.radio_all) {

                } else if (group.getCheckedRadioButtonId() == R.id.radio_opinion) {

                } else if (group.getCheckedRadioButtonId() == R.id.radio_qna) {

                }
            }
        });

        //글 등록
        ln_write_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radiogroup_writting.getCheckedRadioButtonId() == R.id.radio_all){
                    Intent intent = new Intent(WriteSpaceActivity.this, CommonAlertActivity.class);
                    intent.putExtra("page", "WriteSpaceActivity");
                    startActivity(intent);
                    return;
                }
                if(edt_writing.getText().toString().length() == 0){
                    Intent intent = new Intent(WriteSpaceActivity.this, CommonAlertActivity.class);
                    intent.putExtra("page", "WriteSpaceActivity_empty");
                    startActivity(intent);
                    return;
                }
                BoardVO vo = new BoardVO();
                vo.setEmail(CommonVal.userInfo.getEmail());
                vo.setContent(edt_writing.getText().toString());
                if(radiogroup_writting.getCheckedRadioButtonId()==R.id.radio_opinion){
                    vo.setCmt_code("o");

                }else if(radiogroup_writting.getCheckedRadioButtonId()==R.id.radio_qna){
                    vo.setCmt_code("q");
                }
                vo.setModel_code(model_code);
                CommonConn conn = new CommonConn(WriteSpaceActivity.this, "board_list");
                conn.addParams("vo", new Gson().toJson(vo));
                conn.executeConn(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {
                        if(isResult){
                            Log.d("빵구", "onResult: "+data);
                            if(data.equals("1")){
                                Intent intent = new Intent(WriteSpaceActivity.this, CommonAlertActivity.class);
                                intent.putExtra("page", "WriteSpaceActivity_success");
                                startActivity(intent);
                            }
                        }
                    }
                });


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1){  //해당엑티비티종료
            finish();

        }
    }
}