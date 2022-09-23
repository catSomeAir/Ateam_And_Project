package com.example.last_project.search;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.category.CategoryActivity;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    LinearLayout ln_search_list;
    RecyclerView recv_search_relate;
    ImageView imgv_search_category, imgv_search_find;
    EditText edt_search;
    TextView tv_search_findtext;
    boolean search = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ln_search_list = findViewById(R.id.ln_search_list);

//        tv_cancel = findViewById(R.id.tv_cancel);
//        imgv_cancel = findViewById(R.id.imgv_cancel);


        //* 임시로 바코드 검색 데이터 넘어오는곳 : 추후 수정


        String barcord_search_name = getIntent().getStringExtra("barcord_search_name");


        imgv_search_category = findViewById(R.id.imgv_search_category);
        imgv_search_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, CategoryActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slideing_left_enter, R.anim.hold);
            }
        });
        //연관검색어
        recv_search_relate = findViewById(R.id.recv_search_relate);
        ArrayList<String> list = new ArrayList<>();
        list.add("# 연관검색");
        list.add("# 검색어");
        list.add("# 검색");
        list.add("# 어쩌고");
        list.add("# 저쩌고");

        SearchAdapter adapter = new SearchAdapter(getLayoutInflater(), list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recv_search_relate.setAdapter(adapter);
        recv_search_relate.setLayoutManager(manager);

        //검색 돋보기 이미지
        imgv_search_find = findViewById(R.id.imgv_search_find);
        imgv_search_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container_search, new SearchResultFragment()).commit();
                edt_search.setText("");
                edt_search.clearFocus();
                recv_search_relate.setVisibility(View.GONE);
                search = false; //검색시도해서 SearchResultFragment 가 출력된 상태일때
            }
        });

        //검색 EditText
        edt_search = findViewById(R.id.edt_search);
        edt_search.requestFocus();
        tv_search_findtext = findViewById(R.id.tv_search_findtext);
        edt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (edt_search.getText().length() == 0) {
                    ln_search_list.setVisibility(View.GONE);
                    if(search){     //검색시도 하기전임
                        recv_search_relate.setVisibility(View.VISIBLE);
                    }
                } else {
                    tv_search_findtext.setText(edt_search.getText().toString());
                    ln_search_list.setVisibility(View.VISIBLE);
                    recv_search_relate.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //엔터키
        edt_search.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER){
                    imgv_search_find.performClick();
                    edt_search.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edt_search.getWindowToken(), 0);
                }
                return true;
            }
        });

    }
}