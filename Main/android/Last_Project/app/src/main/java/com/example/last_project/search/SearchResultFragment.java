package com.example.last_project.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.last_project.R;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.search.category_search.CategorySearchVO;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class SearchResultFragment extends Fragment {
    TabLayout tabs;
//    LinearLayout ln_search_exist;
//    RecyclerView recv_search_result;


    String search_text;
    String search_div_text;
//    LinearLayout ln_test; // 리사이클러뷰 대신 임시로 -> 검색결과 클릭시 상세페이지로 이동시키기

    //카테고리로 검색시
    String m_category;

    //바코드로 검색시에
    String[] barcord_div_name;
    String barcord_search_name;

    //검색 타입 : 검색어(text), 바코드(barcord), 카테고리(category)
    String search_type = "";

    public SearchResultFragment(String m_category) {
        this.m_category = m_category;

    }
    public SearchResultFragment(String search_text,String search_div_text) {
        this.search_text = search_text;
        this.search_div_text = search_div_text;
    }

    public SearchResultFragment(String barcord_search_name, String[] barcord_div_name) {
        this.barcord_search_name = barcord_search_name;
        this.barcord_div_name = barcord_div_name;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_search_result, container, false);

        //검색 탭레이아웃--------------------------------------------------------------------
        tabs =v.findViewById(R.id.tabs);
        if(!search_type.equals("barcord")){
            tabs.setVisibility(View.VISIBLE);
        }else {
            tabs.setVisibility(View.GONE);
        }
        tabs.addTab(tabs.newTab().setText("전체").setTag(1));
        tabs.addTab(tabs.newTab().setText("제품명").setTag(2));
        tabs.addTab(tabs.newTab().setText("모델명").setTag(3));
        tabs.getTabAt(0).select();




        //탭레이아웃 선택 이벤트
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){
                   if(search_type.equals("text")){
                        CommonConn conn = new CommonConn(getContext(),"search.mo");
                        conn.addParams("search_div_text", search_div_text);
                        conn.executeConn(new CommonConn.ConnCallback() {
                            @Override
                            public void onResult(boolean isResult, String data) {

                                ArrayList<CategorySearchVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<CategorySearchVO>>(){}.getType());
                                if(list !=null &&list.size() != 0){
                                    getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new SearchResultExistFragment(list)).commit();

                                }else {
                                    getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new NotFoundFragment(search_text)).commit();


                                }
                            }
                        });
                    }
                }else if(tab.getPosition()==1){
                    if(search_type.equals("text")){
                        CommonConn conn = new CommonConn(getContext(),"search_name.mo");
                        conn.addParams("search_div_text", search_div_text);
                        conn.executeConn(new CommonConn.ConnCallback() {
                            @Override
                            public void onResult(boolean isResult, String data) {

                                ArrayList<CategorySearchVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<CategorySearchVO>>(){}.getType());
                                if(list !=null &&list.size() != 0){
                                    getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new SearchResultExistFragment(list)).commit();


                                }else {
                                    getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new NotFoundFragment(search_text)).commit();


                                }
                            }
                        });
                    }

                }else if( tab.getPosition() ==2){
                    if(search_type.equals("text")){
                        CommonConn conn = new CommonConn(getContext(),"search_code.mo");
                        conn.addParams("search_div_text", search_div_text);
                        conn.executeConn(new CommonConn.ConnCallback() {
                            @Override
                            public void onResult(boolean isResult, String data) {

                                ArrayList<CategorySearchVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<CategorySearchVO>>(){}.getType());
                                if(list !=null &&list.size() != 0){
                                    getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new SearchResultExistFragment(list)).commit();


                                }else {
                                    getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new NotFoundFragment(search_text)).commit();



                                }
                            }
                        });
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //-------------------------------------------------------------------------------------

        //Activity에서 검색받음 : seach_text 가 null이 아님
         //검색 여러방법으로 하기
        //검색창 검색어 입력으로 검색
        if(search_div_text != null){
            CommonConn conn = new CommonConn(getContext(),"search.mo");
            conn.addParams("search_div_text", search_div_text);
            conn.executeConn(new CommonConn.ConnCallback() {
                @Override
                public void onResult(boolean isResult, String data) {

                    ArrayList<CategorySearchVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<CategorySearchVO>>(){}.getType());
                    if(list !=null &&list.size() != 0){
                        getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new SearchResultExistFragment(list)).commit();

                        search_type = "text";    //탭레이아웃에서 뭐 검색해서 온지 파악용

                    }else {
                        getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new NotFoundFragment(search_text)).commit();

                    }
                }
            });
        }

        //바코드 검색 : 실제 데이터 확인해야함!!!!!!!!!!!!!!!!!!
        if(barcord_search_name != null){
            CommonConn conn = new CommonConn(getContext() , "barcord.mo" );
            conn.addParams("barcord_search_name",barcord_search_name);
            conn.executeConn(new CommonConn.ConnCallback() {
                @Override
                public void onResult(boolean isResult, String data) {
                    ArrayList<CategorySearchVO> list = new Gson().fromJson(data,
                            new TypeToken<ArrayList<CategorySearchVO>>() {
                            }.getType());
                    if(list.size() != 0){

                        getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new SearchResultExistFragment(list)).commit();

                        search_type = "barcord";    //탭레이아웃에서 뭐 검색해서 온지 파악용

                    }else {
                        getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new NotFoundFragment(barcord_search_name)).commit();

                    }

                }
            });

        }


        //카테고리로 검색 넘어옴
        //카테고리로 검색
        if(m_category != null){

            CommonConn conn = new CommonConn(getContext(), "list.mo");
            conn.addParams("m_name",m_category);
            conn.executeConn(new CommonConn.ConnCallback() {
                @Override
                public void onResult(boolean isResult, String data) {
                    if(isResult){
                        ArrayList<CategorySearchVO> list = new Gson().fromJson(data,
                                new TypeToken<ArrayList<CategorySearchVO>>() {
                                }.getType());

                        getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new SearchResultExistFragment(list)).commit();
                    }
                }
            });
        }





        return v;
    }

    public void search_list(){
        //입력한 text로 DB검색 : list받아오기

    }

}