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
import com.example.last_project.category.recyclerview.RelateSearchAdapter;
import com.example.last_project.common.CommonMethod;
import com.example.last_project.conn.CommonConn;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    LinearLayout ln_search_list;
    RecyclerView recv_search_relate, recv_search_input_relate;
    ImageView imgv_search_category, imgv_search_find, imgv_cancel;
    EditText edt_search;
    TextView tv_search_findtext, tv_cancel;
    boolean search = true;

    String search_text ="";
    String search_div_text ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ln_search_list = findViewById(R.id.ln_search_list);
        tv_cancel = findViewById(R.id.tv_cancel);
        imgv_cancel = findViewById(R.id.imgv_cancel);

        //* 임시로 바코드 검색 데이터 넘어오는곳 : 추후 수정
        imgv_search_category = findViewById(R.id.imgv_search_category);
        imgv_search_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, CategoryActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slideing_left_enter, R.anim.hold);
            }
        });

        //DB연관된 검색어 뜨도록 하는곳
        recv_search_relate = findViewById(R.id.recv_search_relate);


        ArrayList<String> list = new ArrayList<>();
        //연관검색어
        list.add("# 냉장고");
        list.add("# TV");
        list.add("# 세탁기");
        list.add("# BESPOKE");
        list.add("# 스탠드");

        SearchAdapter adapter = new SearchAdapter(getLayoutInflater(),  SearchActivity.this , list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recv_search_relate.setAdapter(adapter);
        recv_search_relate.setLayoutManager(manager);


        //검색 돋보기 이미지
        imgv_search_find = findViewById(R.id.imgv_search_find);
        imgv_search_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                //CommonVal 에 현재 검색한 검색어 search_text로 사용 할 예정
//                CommonVal.search_text = edt_search.getText().toString();

                //DB에서 조회해서 데이터 검색결과 유무로 Framgment를 SearchResultFragment(검색결과 있는경우) , NotFoundFragment(없는경우)

                //검색데이터가 있는경우 임시( 비스포크라고 쳤을 경우로 테스트중 )


                getSupportFragmentManager().beginTransaction().replace(R.id.container_search, new SearchResultFragment(edt_search.getText() + "", search_div_text, "text")).commit();


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

        //검색어와 연관된 DB저장된 데이터 뿌리는 리사이클러뷰
        recv_search_input_relate = findViewById(R.id.recv_search_input_relate);


        edt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CommonConn conn = new CommonConn(SearchActivity.this, "search.re"); //입력한 검색어와 최대한 비슷한 정보
                search_text = edt_search.getText().toString();
                search_div_text = CommonMethod.text_div(search_text);
                conn.addParams("search_text", search_div_text);
                conn.executeConn_no_dialog(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {
                        if (isResult) {
                            String[] list = new Gson().fromJson(data, new TypeToken<String[]>() {
                            }.getType());
                            if (list != null) {

                                RelateSearchAdapter adapter = new RelateSearchAdapter(getLayoutInflater(), SearchActivity.this, list, search_text, getSupportFragmentManager(), SearchActivity.this);
                                RecyclerView.LayoutManager manager = new LinearLayoutManager(SearchActivity.this, RecyclerView.VERTICAL, false);
                                recv_search_input_relate.setLayoutManager(manager);
                                recv_search_input_relate.setAdapter(adapter);
                            }

                        }
                    }
                });
                if (edt_search.getText().length() == 0) {
                    ln_search_list.setVisibility(View.GONE);
                    if (search) {     //검색시도 하기전임
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
//                Log.d("키코드", "onKey: " + KeyEvent.KEYCODE_ENTER);
//                Log.d("키코드", "onKey: " + edt_search.getText().toString());
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    edt_search.setText(edt_search.getText().toString().replace("\n", ""));
                    imgv_search_find.performClick();
                    edt_search.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edt_search.getWindowToken(), 0);


                }
                return false;
            }
        });

        //취소 글씨선택, x 아이콘으로 Edittext 텍스트 지우기
        CommonMethod.edittext_change(edt_search, tv_cancel, imgv_cancel, SearchActivity.this);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_search.setText("");
                edt_search.clearFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(edt_search.getWindowToken(), 0);
                recv_search_relate.setVisibility(View.GONE);

            }
        });


        //카테고리 중분류 선택해서 들어옴
        String m_category = getIntent().getStringExtra("m_category");
        if(m_category !=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container_search, new SearchResultFragment(m_category)).commit();
            recv_search_relate.setVisibility(View.GONE);
        }



        //* 임시로 바코드 검색 데이터 넘어오는곳 : 추후 수정
        String barcode_search_name = getIntent().getStringExtra("barcode_search_name");
        if (barcode_search_name != null) {
            if (barcode_search_name == "") {
                barcode_search_name = "해당하는 제품정보";
            }


            getSupportFragmentManager().beginTransaction().replace(R.id.container_search, new SearchResultFragment(barcode_search_name, CommonMethod.text_div(barcode_search_name),"barcode")).commit();
            recv_search_relate.setVisibility(View.GONE);
            search = false;
//            Bundle bundle = new Bundle();
//            bundle.putString("barcode_search_name",barcode_search_name);
//            SearchResultFragment fragment = new SearchResultFragment();
//            fragment.setArguments(bundle);
        }


//        //취소 글씨선택, x 아이콘으로 Edittext 텍스트 지우기
//        CommonMethod.edittext_change(edt_search, tv_cancel, imgv_cancel, SearchActivity.this);
//        tv_cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                edt_search.setText("");
//                edt_search.clearFocus();
//                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
//                imm.hideSoftInputFromWindow(edt_search.getWindowToken(), 0);
//            }
//        });


    }



}