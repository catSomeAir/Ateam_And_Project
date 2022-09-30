package com.example.last_project.model;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;
import com.example.last_project.model.detail.ManualFragment;
import com.example.last_project.model.detail.as.AfterServiceFragment;
import com.example.last_project.model.detail.writng.WritingFragment;
import com.example.last_project.search.category_search.CategorySearchVO;
import com.google.android.material.tabs.TabLayout;

public class ModelDetailActivity extends AppCompatActivity  {
    ImageView imgv_back;
//    LinearLayout ln_model_detail_writing;
    TabLayout tabs;

    TextView tv_detail_cancel;
    CategorySearchVO model_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_detail);

        //카테고리 버튼 선택시 카테고리 엑티비티 뜨도록 설정
//        imgv_detail_category = findViewById(R.id.imgv_detail_category);
//        imgv_detail_category.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ModelDetailActivity.this, CategoryActivity.class);
//                startActivity(intent);
//                overridePendingTransition(R.anim.slideing_left_enter, R.anim.hold);
//            }
//        });
        imgv_back = findViewById(R.id.imgv_back);

        imgv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        tabs =findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("제품설명서").setTag(1));
        tabs.addTab(tabs.newTab().setText("상품의견").setTag(2));
        tabs.addTab(tabs.newTab().setText("A/S센터").setTag(3));
        tabs.getTabAt(0).select();

        //검색리스트에서 클릭해서 넘어온 모델정보
        model_info = (CategorySearchVO) getIntent().getSerializableExtra("model_info");



        //처음은 바로 설명서 Fragment띄우기
        getSupportFragmentManager().beginTransaction().replace(R.id.container_model_detail, new ManualFragment(ModelDetailActivity.this, model_info)).commit();

        //탭레이아웃 선택 이벤트
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if(tab.getPosition()==0){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_model_detail, new ManualFragment(ModelDetailActivity.this, model_info)).commit();
                }else if(tab.getPosition()==1){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_model_detail, new WritingFragment(model_info.getModel_code())).commit();
                }else if(tab.getPosition()==2){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_model_detail, new AfterServiceFragment()).commit();

                    //* 수정해야함
//                        getSupportFragmentManager().beginTransaction().replace(R.id.container_model_detail, new UnrelatedASFragment()).commit();//* 임시로 AS센터 없는 경우 확인하기 위해 만들어둠

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


//        //검색------------
//        //검색창 옆 취소
//        tv_detail_cancel = findViewById(R.id.tv_detail_cancel);
////        //검색창 옆 취소아이콘
//        imgv_detail_cancel = findViewById(R.id.imgv_detail_cancel);
////        //검색창
//        edt_search = findViewById(R.id.edt_search);
////
//        //검색창 포커스 있을때 취소 글씨 보기
//        edt_search.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if(hasFocus){
//                    tv_detail_cancel.setVisibility(View.VISIBLE);
//                }else{
//                    tv_detail_cancel.setVisibility(View.GONE);
//                }
//            }
//        });
//
//
//        tv_detail_cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edt_search.setText("");
//                edt_search.clearFocus();
//                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
//                imm.hideSoftInputFromWindow(edt_search.getWindowToken(), 0);
//            }
//        });
//
//
//
//        edt_search.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                //검색창 글 입력된경우 취소이미지 보이기
//                if(edt_search.getText().length() > 0){
//                    imgv_detail_cancel.setVisibility(View.VISIBLE);
//                }else{
//                    imgv_detail_cancel.setVisibility(View.GONE);
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
//        imgv_detail_cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edt_search.setText("");
//            }
//        });

//        CommonMethod.edittext_change(edt_search, tv_detail_cancel, imgv_detail_cancel, ModelDetailActivity.this);
//        tv_detail_cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edt_search.setText("");
//                edt_search.clearFocus();
//                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
//                imm.hideSoftInputFromWindow(edt_search.getWindowToken(), 0);
//            }
//        });
//        ln_model_detail_writing = findViewById(R.id.ln_model_detail_writing );
//        ln_model_detail_writing.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ModelDetailActivity.this, WritingActivity.class  );
//                startActivity(intent);
//            }
//        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        if(tabs.getSelectedTabPosition() == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container_model_detail, new WritingFragment(model_info.getModel_code())).commit();

        }

    }
}