package com.example.last_project.search;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.last_project.R;
import com.example.last_project.common.CommonVal;
import com.example.last_project.request.RequestManualActivity;


public class NotFoundFragment extends Fragment {
    TextView tv_not_found;
    LinearLayout ln_not_found_request;
    String search_text;

    public NotFoundFragment(String search_text) {
        this.search_text = search_text;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_not_found, container, false);

        //검색했지만 찾을 수 없던 사용자가 입력한 검색어
        tv_not_found = v.findViewById(R.id.tv_not_found);
        tv_not_found.setText("'"+search_text+"' 에 대한 검샐결과가 없습니다.");
        //해당문자 색 바꾸기
        String content = tv_not_found.getText().toString();
        SpannableString spannableString = new SpannableString(content);

        String word = search_text;  //유저가 검색한 검색어 여기다 넣기
//        int start = content.indexOf(word);
//        int end = start + word.length();
        int start = content.indexOf(word);
        int end = start + word.length();
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0C2843")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new RelativeSizeSpan(1.05f), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_not_found.setText(spannableString);



        //검색결과 없을 시 설명서 요청 : 요청은 확인여부 메일로 전송
        ln_not_found_request = v.findViewById(R.id.ln_not_found_request);
        ln_not_found_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CommonVal.userInfo != null){

                Intent intent = new Intent(getContext(), RequestManualActivity.class);
                startActivity(intent);
                getActivity().finish();
                }else {
                    Intent intent = new Intent(getContext(), NotFoundAlertActivity.class);
                    getActivity().overridePendingTransition(0, 0);
                    startActivity(intent);

                }

            }
        });
        return v;
    }
}