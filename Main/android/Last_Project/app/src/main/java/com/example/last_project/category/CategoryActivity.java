package com.example.last_project.category;

<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.bumptech.glide.Glide;
import com.example.last_project.R;
import com.example.last_project.common.CommonVal;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.member.LoginActivity;
import com.example.last_project.member.MemberVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener {
    NestedScrollView scv_category;  //스크롤뷰
    LinearLayout[] ln_l_list, ln_m_list;    //분류 레이아웃
    Integer[] l_list_id, m_list_id; //분류 id
    LinearLayout ln_category_login, ln_category_not_login;  //로그인 상태창
    Button btn_category_login; //로그인버튼

    //로그인 시 프로필 정보
    ImageView imgv_category_profile;    //프로필이미지
    TextView tv_category_nickname, tv_category_count, tv_category_comment_count;    //닉네임, 쓴글 수 , 쓴 댓글수

=======
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.category.recyclerview.CategoryAdapter;
import com.example.last_project.category.recyclerview.CategoryVO;
import com.example.last_project.conn.CommonConn;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recv_l_category;
    ArrayList<CategoryVO> l_list = new ArrayList<>();
    ArrayList<CategoryVO> m_list = new ArrayList<>();
    CategoryAdapter adapter ;
>>>>>>> 1a48d713eaf7e24bb931b82edd57d7eff58f0b4a
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

<<<<<<< HEAD
        //분류 선언, 아이디지정
        l_list_id = new Integer[]{R.id.ln_l_list1, R.id.ln_l_list2, R.id.ln_l_list3, R.id.ln_l_list4, R.id.ln_l_list5, R.id.ln_l_list6, R.id.ln_l_list7, R.id.ln_l_list8};
        m_list_id = new Integer[]{R.id.ln_m_list1, R.id.ln_m_list2, R.id.ln_m_list3, R.id.ln_m_list4, R.id.ln_m_list5, R.id.ln_m_list6, R.id.ln_m_list7, R.id.ln_m_list8};
        ln_l_list = new LinearLayout[]{findViewById(R.id.ln_l_list1), findViewById(R.id.ln_l_list2), findViewById(R.id.ln_l_list3), findViewById(R.id.ln_l_list4), findViewById(R.id.ln_l_list5), findViewById(R.id.ln_l_list6), findViewById(R.id.ln_l_list7), findViewById(R.id.ln_l_list8)};
        ln_m_list = new LinearLayout[]{findViewById(R.id.ln_m_list1), findViewById(R.id.ln_m_list2), findViewById(R.id.ln_m_list3), findViewById(R.id.ln_m_list4), findViewById(R.id.ln_m_list5), findViewById(R.id.ln_m_list6), findViewById(R.id.ln_m_list7), findViewById(R.id.ln_m_list8)};
        for (int i = 0; i < l_list_id.length; i++) {
            ln_l_list[i].setOnClickListener(this);
        }


        //스크롤뷰
        scv_category = findViewById(R.id.scv_category);

        //로그인 / 로그아웃 화면
        ln_category_login = findViewById(R.id.ln_category_login);
        ln_category_not_login = findViewById(R.id.ln_category_not_login);
        if (CommonVal.userInfo == null) {
            ln_category_login.setVisibility(View.GONE);
            ln_category_not_login.setVisibility(View.VISIBLE);
        } else {
            ln_category_login.setVisibility(View.VISIBLE);
            ln_category_not_login.setVisibility(View.GONE);
        }
        //로그인버튼
        btn_category_login = findViewById(R.id.btn_category_login);
        btn_category_login.setOnClickListener(this);

        //프로필 정보
        imgv_category_profile = findViewById(R.id.imgv_category_profile);
        tv_category_nickname = findViewById(R.id.tv_category_nickname);
        tv_category_count = findViewById(R.id.tv_category_count);
        tv_category_comment_count = findViewById(R.id.tv_category_comment_count);

        if (CommonVal.userInfo != null) {
            MemberVO vo = CommonVal.userInfo;
            if (vo.getProfile_img() != null) {
                //피카소 글라이드 비교해봐야할듯
//            Picasso.get().load(CommonVal.userInfo.getProfile_img()).into(imgv_category_profile);
                Glide.with(CategoryActivity.this).load(vo.getProfile_img()).into(imgv_category_profile);
            }
            tv_category_nickname.setText(vo.getNickname());
            CommonConn conn = new CommonConn(CategoryActivity.this, "count.ct");
            conn.addParams("email", vo.getEmail());
            conn.executeConn(new CommonConn.ConnCallback() {
                @Override
                public void onResult(boolean isResult, String data) {
                    if (isResult) {
                        HashMap<String, String> map = new Gson().fromJson(data, new TypeToken<HashMap<String, String>>() {
                        }.getType());
                        tv_category_count.setText(map.get("board_count"));
                        tv_category_comment_count.setText(map.get("reply_count"));
                    }
                }
            });
        }

        //쓴글 수 , 댓글 수 -> 이후 생명주기 고려해서 넣기

    }

    //뒤로가기 누르면 애니메이션 효과
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.slideing_right_exit);
    }


    //클릭이벤트
    @Override
    public void onClick(View v) {

        //카테고리에서 로그인버튼 누름
        if (v.getId() == R.id.btn_category_login) {
            Intent intent = new Intent(CategoryActivity.this, LoginActivity.class);
            startActivity(intent);
            onBackPressed();
        }

        //대분류 클릭시 - 중분류 레이아웃 보이도록, 스크롤뷰 위치 이동
        for (int i = 0; i < l_list_id.length; i++) {
            if (v.getId() == l_list_id[i]) {
                for (int j = 0; j < l_list_id.length; j++) {
                    ln_m_list[j].setVisibility(View.GONE);
                }
                ln_m_list[i].setVisibility(View.VISIBLE);
                Log.d("TAG", "onClick: " + scv_category.getHeight() + ln_m_list[i].getHeight());
                if (i == 0) {
                    scv_category.smoothScrollTo(0, 1000, 500);

                } else if (i == 1) {
                    scv_category.smoothScrollTo(0, 1100, 500);
                } else if (i == 2) {
                    scv_category.smoothScrollTo(0, 1200, 500);
                } else if (i == 3) {
                    scv_category.smoothScrollTo(0, 1320, 500);
                } else if (i == 4) {
                    scv_category.smoothScrollTo(0, 1500, 500);
                } else if (i == 5) {
                    scv_category.smoothScrollTo(0, 1600, 500);
                } else if (i == 6) {
                    scv_category.smoothScrollTo(0, 1780, 500);
                } else if (i == 7) {
                    scv_category.smoothScrollTo(0, 1900, 500);
                }
            }

        }


=======
        //카테고리 대분류 리사이클러뷰
        recv_l_category = findViewById(R.id.recv_l_category);


        CommonConn conn = new CommonConn(CategoryActivity.this, "llist.ct");
        conn.executeConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                if(isResult){
                    l_list = new Gson().fromJson(data, new TypeToken<ArrayList<CategoryVO>>(){}.getType());
                    adapter = new CategoryAdapter(getLayoutInflater(),CategoryActivity.this,  l_list);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(CategoryActivity.this, RecyclerView.VERTICAL, false);
                    recv_l_category.setLayoutManager(manager);
                    recv_l_category.setAdapter(adapter);
                }
            }
        });

//        CommonConn conn1 = new CommonConn(CategoryActivity.this, "mlist.ct");
//        conn1.executeConn(new CommonConn.ConnCallback() {
//            @Override
//            public void onResult(boolean isResult, String data) {
//                if(isResult){
//                    m_list = new Gson().fromJson(data, new TypeToken<ArrayList<CategoryVO>>(){}.getType());
////                    adapter = new CategoryAdapter(getLayoutInflater(),CategoryActivity.this, l_list, m_list);
//
//                }
//            }
//        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,R.anim.slideing_right_exit);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.tv_l_name){
            for(int i = 0 ; i < 20; i ++){
//                    if(v.getTag().equals(i)){
//
//                    }
////
////                }
            }
        }
>>>>>>> 1a48d713eaf7e24bb931b82edd57d7eff58f0b4a
    }
}