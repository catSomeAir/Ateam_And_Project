package com.example.last_project.common;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CommonMethod {


    //EditText내용 있는지 없는지
    //로그인 액티비티
    //회원가입 액티비티 등에서 EditText 입력값을 파라메터로 활용할 경우들에서 모두 사용

    public static boolean isCheckEditText(EditText edt){
        try {   //try-catch 는 EditText의 findViewById 입력안해서 null 뜨는 경우 예외처리
            if (edt.getText().toString() == null || edt.getText().toString().trim().length() < 1) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;    //객체가 null 아니고 공백제거시 1보다 작지 않을때
    }


    public static void edittext_change(EditText edt_search, TextView tv_cancel, ImageView imgv_cancel, Context context){
//        tv_detail_cancel = findViewById(R.id.tv_detail_cancel);
//        //검색창 옆 취소아이콘
//        imgv_detail_cancel = findViewById(R.id.imgv_detail_cancel);
//        //검색창
//        edt_search = findViewById(R.id.edt_search);

        //검색창 포커스 있을때 취소 글씨 보기
        edt_search.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    tv_cancel.setVisibility(View.VISIBLE);
                }else{
                    tv_cancel.setVisibility(View.GONE);
                }
            }
        });






        edt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //검색창 글 입력된경우 취소이미지 보이기
                if(edt_search.getText().length() > 0){
                    imgv_cancel.setVisibility(View.VISIBLE);
                }else{
                    imgv_cancel.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        imgv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_search.setText("");
            }
        });
    }
}
