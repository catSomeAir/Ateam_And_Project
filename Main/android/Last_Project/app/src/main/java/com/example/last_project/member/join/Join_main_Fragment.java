package com.example.last_project.member.join;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.last_project.R;
import com.example.last_project.member.MemberVO;

public class Join_main_Fragment extends Fragment {
    Button join_btn_next;
    EditText join_edt_email;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_join_main_, container, false);


        join_btn_next = v.findViewById(R.id.join_btn_next);
        join_edt_email = v.findViewById(R.id.join_edt_email);

        join_btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MemberVO vo = new MemberVO();
                vo.setEmail(join_edt_email.getText().toString());
//                CommonConn conn = new CommonConn(Join_main_Fragment.this, "join_email.me");

            }
        });

        return v;
    }
}
//                Bundle bundle = new Bundle();//값 전달할 bundle 생성
//                bundle.putString("email", join_edt_email.getText().toString()); //bundle에 입력된 email 저장
