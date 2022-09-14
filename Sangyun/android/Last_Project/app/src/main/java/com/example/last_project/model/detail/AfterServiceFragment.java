package com.example.last_project.model.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.last_project.R;
import com.example.last_project.WebviewActivity;


public class AfterServiceFragment extends Fragment {
    LinearLayout ln_as_call, ln_as_homepage;
    TextView tv_as_call, tv_as_homepage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_after_service, container, false);

        //전화 아이콘
        ln_as_call  = v.findViewById(R.id.ln_as_call);

        //전화번호 담당 tv
        tv_as_call = v.findViewById(R.id.tv_as_call);

        ln_as_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/"+tv_as_call.getText()));
                startActivity(intent);
            }
        });

        //홈페이지 주소
        tv_as_homepage = v.findViewById(R.id.tv_as_homepage);
        //홈페이지 아이콘
        ln_as_homepage = v.findViewById(R.id.ln_as_homepage);
        ln_as_homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), WebviewActivity.class);
                intent.putExtra("url", tv_as_homepage.getText() );
                startActivity(intent);
            }
        });

        return v;
    }
}