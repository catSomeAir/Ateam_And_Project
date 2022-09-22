package com.example.last_project.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.model.ModelDetailActivity;
import com.example.last_project.model.ModelInfoVO;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class SearchResultFragment extends Fragment {
    TabLayout tabs;
    RecyclerView recv_search_result;
    ArrayList<ModelInfoVO> list = null;
    String search_text;
    LinearLayout ln_test; // 리사이클러뷰 대신 임시로 -> 검색결과 클릭시 상세페이지로 이동시키기

    public SearchResultFragment(String search_text) {
        this.search_text = search_text;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_search_result, container, false);
        recv_search_result = v.findViewById(R.id.recv_search_result);

        //리사이클러뷰 붙이기
        SearchResultAdapter adapter = new SearchResultAdapter(getLayoutInflater(), SearchResultFragment.this);// 나중에 list보내줘야함
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recv_search_result.setLayoutManager(manager);
        recv_search_result.setAdapter(adapter);

        //검색 탭레이아웃--------------------------------------------------------------------
        tabs =v.findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("전체").setTag(1));
        tabs.addTab(tabs.newTab().setText("제품명").setTag(2));
        tabs.addTab(tabs.newTab().setText("모델명").setTag(3));
        tabs.getTabAt(0).select();


        //탭레이아웃 선택 이벤트
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==1){
                    getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new NotFoundFragment(search_text)).commit();
                    ln_test.setVisibility(View.GONE);
                }else if(tab.getPosition()==0){
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
        //DB연결해서 붙이기
//        CommonConn conn = new CommonConn(getContext(), "test.up");
//        conn.executeConn(new CommonConn.ConnCallback() {
//            @Override
//            public void onResult(boolean isResult, String data) {
//                if(isResult){
//                    list = new Gson().fromJson(data, new TypeToken<ArrayList<ModelInfoVO>>() {
//                            }.getType());
//                    Glide.with(getContext()).load(list.get(0).getFilepath()).into(temp_img);
//                }
//            }
//        });
//        Glide.with(this).load("http://192.168.0.33/iot/upload/board/2022/08/31/52d5d963-2b23-4823-a752-4f48be5727f5_banner2.jpg").into(temp_img);

        //임시테스트
        //상세페이지 이동하는 레이아웃 : 사실 이거 adpater에서 해야하므로 db연동시 이거 adpater쪽으로 이동
        ln_test= v.findViewById(R.id.ln_test);
        ln_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ModelDetailActivity.class);

                startActivity(intent);

            }
        });

        //임시테스트 : 검색어 일치 결과 없는 경우

        if(!search_text.equals("비스포크")){
            getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new NotFoundFragment(search_text)).commit();
            ln_test.setVisibility(View.GONE);
        }
        return v;
    }
}