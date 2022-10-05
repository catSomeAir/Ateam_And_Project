package com.example.last_project.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class CommonMethod {


    //EditText내용 있는지 없는지
    //로그인 액티비티
    //회원가입 액티비티 등에서 EditText 입력값을 파라메터로 활용할 경우들에서 모두 사용

    public static boolean isCheckEditText(EditText edt) {
        try {   //try-catch 는 EditText의 findViewById 입력안해서 null 뜨는 경우 예외처리
            if (edt.getText().toString() == null || edt.getText().toString().trim().length() < 1) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;    //객체가 null 아니고 공백제거시 1보다 작지 않을때
    }


    public static void edittext_change(EditText edt_search, TextView tv_cancel, ImageView imgv_cancel, Context context) {
//        tv_detail_cancel = findViewById(R.id.tv_detail_cancel);
//        //검색창 옆 취소아이콘
//        imgv_detail_cancel = findViewById(R.id.imgv_detail_cancel);
//        //검색창
//        edt_search = findViewById(R.id.edt_search);

        //검색창 포커스 있을때 취소 글씨 보기
        edt_search.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    tv_cancel.setVisibility(View.VISIBLE);
                } else {
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
                if (edt_search.getText().length() > 0) {
                    imgv_cancel.setVisibility(View.VISIBLE);
                } else {
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

    public static String text_div(String text) {
        String[] CHO = {"ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ", "ㅃ",
                "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};

        String[] JOONG = {"ㅏ", "ㅐ", "ㅑ", "ㅒ", "ㅓ", "ㅔ", "ㅕ", "ㅖ", "ㅗ", "ㅘ",
                "ㅙ", "ㅚ", "ㅛ", "ㅜ", "ㅝ", "ㅞ", "ㅟ", "ㅠ", "ㅡ", "ㅢ", "ㅣ"};

        String[] JONG = {"", "ㄱ", "ㄲ", "ㄳ", "ㄴ", "ㄵ", "ㄶ", "ㄷ", "ㄹ", "ㄺ", "ㄻ", "ㄼ",
                "ㄽ", "ㄾ", "ㄿ", "ㅀ", "ㅁ", "ㅂ", "ㅄ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char uniVal = text.charAt(i);

            // 한글일 경우만 시작해야 하기 때문에 0xAC00부터 아래의 로직을 실행한다
            if (uniVal >= 0xAC00) {
                System.out.print(uniVal + "=>");
                uniVal = (char) (uniVal - 0xAC00);

                char cho = (char) (uniVal / 28 / 21);
                char joong = (char) ((uniVal) / 28 % 21);
                char jong = (char) (uniVal % 28);    // 종성의 첫번째는 채움이기 때문에

                result = (CHO[cho] + JOONG[joong] + JONG[jong]);
            } else {
                result =  String.valueOf(uniVal);
            }
        }
        return result;
    }

    public static void change_text(String content, String search_text, TextView textView){
        //해당문자 색 바꾸기

        SpannableString spannableString = new SpannableString(content);
        try {
            String word = search_text;  //유저가 검색한 검색어 여기다 넣기
    //        int start = content.indexOf(word);
    //        int end = start + word.length();
            int start = content.indexOf(word);
            int end = start + word.length();
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0C2843")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(new StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(new RelativeSizeSpan(1.05f), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
            textView.setText(spannableString);

        }catch (Exception e){

        }
    }

    //공유자원에 ArrayList 형식 넣어두고 사용하기
    public static void setStringArrayPref(Context context, String key, ArrayList<String> values) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        JSONArray a = new JSONArray();
        for (int i = 0; i < values.size(); i++) {
            a.put(values.get(i));
        }
        if (!values.isEmpty()) {
            editor.putString(key, a.toString());
        } else {
            editor.putString(key, null);
        }
        editor.apply();
    }

    public static ArrayList<String> getStringArrayPref(Context context, String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String json = prefs.getString(key, null);
        ArrayList<String> urls = new ArrayList<String>();
        if (json != null) {
            try {
                JSONArray a = new JSONArray(json);
                for (int i = 0; i < a.length(); i++) {
                    String url = a.optString(i);
                    urls.add(url);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return urls;
    }

}
