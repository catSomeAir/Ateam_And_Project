package com.example.last_project.common;

import android.widget.EditText;

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

}
