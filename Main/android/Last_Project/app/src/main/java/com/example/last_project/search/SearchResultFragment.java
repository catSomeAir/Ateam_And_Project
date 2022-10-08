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
    String[] barcode_div_name;
    String barcode_search_name;

    //검색 타입 : 검색어(text), 바코드(barcode), 카테고리(category)
    String search_type;


    public SearchResultFragment(String m_category) {
        this.m_category = m_category;

    }

    public SearchResultFragment(String search_text, String search_div_text, String search_type) {
        this.search_text = search_text;
        this.search_div_text = search_div_text;
        this.search_type = search_type;
    }

    public SearchResultFragment(String barcode_search_name, String[] barcode_div_name) {
        this.barcode_search_name = barcode_search_name;
        this.barcode_div_name = barcode_div_name;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search_result, container, false);
//        recv_search_result = v.findViewById(R.id.recv_search_result);
//        ln_search_exist  = v.findViewById(R.id.ln_search_exist);

        //검색 탭레이아웃--------------------------------------------------------------------
        tabs = v.findViewById(R.id.tabs);

        tabs.addTab(tabs.newTab().setText("전체").setTag(1));
        tabs.addTab(tabs.newTab().setText("제품명").setTag(2));
        tabs.addTab(tabs.newTab().setText("모델명").setTag(3));

        if (search_type != null) {

            if (search_type.equals("barcode")) {
                tabs.getTabAt(1).select();
            } else {
                tabs.getTabAt(0).select();
            }
        }


        //탭레이아웃 선택 이벤트
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    if (search_type!=null&&search_type.equals("text")) {
                        CommonConn conn = new CommonConn(getContext(), "search.mo");
                        conn.addParams("search_div_text", search_div_text);
                        conn.executeConn(new CommonConn.ConnCallback() {
                            @Override
                            public void onResult(boolean isResult, String data) {

                                ArrayList<CategorySearchVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<CategorySearchVO>>() {
                                }.getType());
                                if (list != null && list.size() != 0) {
                                    getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new SearchResultExistFragment(list)).commit();
//                                    SearchResultAdapter adapter = new SearchResultAdapter(getLayoutInflater(), SearchResultFragment.this, list);// 나중에 list보내줘야함
//                                    RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
//                                    recv_search_result.setLayoutManager(manager);
//                                    recv_search_result.setAdapter(adapter);
//                                    ln_search_exist.setVisibility(View.VISIBLE);
//                                    recv_search_result.setVisibility(View.VISIBLE);


                                } else {
                                    getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new NotFoundFragment(search_text)).commit();
//                                    ln_search_exist.setVisibility(View.GONE);
//                                    recv_search_result.setVisibility(View.GONE);

                                }
                            }
                        });
                    }
                } else if (tab.getPosition() == 1) {
                    if (search_type!=null&&search_type.equals("text")) {
                        CommonConn conn = new CommonConn(getContext(), "search_name.mo");
                        conn.addParams("search_div_text", search_div_text);
                        conn.executeConn(new CommonConn.ConnCallback() {
                            @Override
                            public void onResult(boolean isResult, String data) {

                                ArrayList<CategorySearchVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<CategorySearchVO>>() {
                                }.getType());
                                if (list != null && list.size() != 0) {
                                    getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new SearchResultExistFragment(list)).commit();
//                                    SearchResultAdapter adapter = new SearchResultAdapter(getLayoutInflater(), SearchResultFragment.this, list);// 나중에 list보내줘야함
//                                    RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
//                                    recv_search_result.setLayoutManager(manager);
//                                    recv_search_result.setAdapter(adapter);
//                                    ln_search_exist.setVisibility(View.VISIBLE);
//                                    recv_search_result.setVisibility(View.VISIBLE);

                                } else {
                                    getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new NotFoundFragment(search_text)).commit();
//                                    ln_search_exist.setVisibility(View.GONE);
//                                    recv_search_result.setVisibility(View.GONE);

                                }
                            }
                        });
                    }

                } else if (tab.getPosition() == 2) {
                    if (search_type!=null&&search_type.equals("text")) {
                        CommonConn conn = new CommonConn(getContext(), "search_code.mo");
                        conn.addParams("search_div_text", search_div_text);
                        conn.executeConn(new CommonConn.ConnCallback() {
                            @Override
                            public void onResult(boolean isResult, String data) {

                                ArrayList<CategorySearchVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<CategorySearchVO>>() {
                                }.getType());
                                if (list != null && list.size() != 0) {
                                    getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new SearchResultExistFragment(list)).commit();
//                                    SearchResultAdapter adapter = new SearchResultAdapter(getLayoutInflater(), SearchResultFragment.this, list);// 나중에 list보내줘야함
//                                    RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
//                                    recv_search_result.setLayoutManager(manager);
//                                    recv_search_result.setAdapter(adapter);
//                                    ln_search_exist.setVisibility(View.VISIBLE);
//                                    recv_search_result.setVisibility(View.VISIBLE);

                                } else {
                                    getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new NotFoundFragment(search_text)).commit();
//                                    ln_search_exist.setVisibility(View.GONE);
//                                    recv_search_result.setVisibility(View.GONE);


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

        //Activity에서 검색받음 : seach_text 가 null이 아님
        //검색 여러방법으로 하기
        //검색창 검색어 입력으로 검색
        if (search_div_text != null) {
            CommonConn conn = new CommonConn(getContext(), "search.mo");
            conn.addParams("search_div_text", search_div_text);
            conn.executeConn(new CommonConn.ConnCallback() {
                @Override
                public void onResult(boolean isResult, String data) {

                    ArrayList<CategorySearchVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<CategorySearchVO>>() {
                    }.getType());
                    if (list != null && list.size() != 0) {
                        getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new SearchResultExistFragment(list)).commit();
//                        SearchResultAdapter adapter = new SearchResultAdapter(getLayoutInflater(), SearchResultFragment.this, list);// 나중에 list보내줘야함
//                        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
//                        recv_search_result.setLayoutManager(manager);
//                        recv_search_result.setAdapter(adapter);
                        search_type = "text";    //탭레이아웃에서 뭐 검색해서 온지 파악용
//                        ln_search_exist.setVisibility(View.VISIBLE);
//                        recv_search_result.setVisibility(View.VISIBLE);
                    } else {
                        getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new NotFoundFragment(search_text)).commit();
//                        ln_search_exist.setVisibility(View.GONE);
//                        recv_search_result.setVisibility(View.GONE);
                    }
                }
            });
        }
        //카테고리로 검색
        if (m_category != null) {

            CommonConn conn = new CommonConn(getContext(), "list.mo");
            conn.addParams("m_name", m_category);
            conn.executeConn(new CommonConn.ConnCallback() {
                @Override
                public void onResult(boolean isResult, String data) {
                    if (isResult) {
                        ArrayList<CategorySearchVO> list = new Gson().fromJson(data,
                                new TypeToken<ArrayList<CategorySearchVO>>() {
                                }.getType());

                        getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new SearchResultExistFragment(list)).commit();
                    }
                }
            });
        }

        //바코드 검색 : 실제 데이터 확인해야함!!!!!!!!!!!!!!!!!!
        if (search_type!= null&&search_type.equals("barcode")) {
            CommonConn conn = new CommonConn(getContext(), "barcode.mo");
            conn.addParams("barcode_search_name", search_text);
            conn.executeConn(new CommonConn.ConnCallback() {
                @Override
                public void onResult(boolean isResult, String data) {
                    ArrayList<CategorySearchVO> list = new Gson().fromJson(data,
                            new TypeToken<ArrayList<CategorySearchVO>>() {
                            }.getType());
                    if (list != null) {

                        getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new SearchResultExistFragment(list)).commit();
//                        SearchResultAdapter adapter = new SearchResultAdapter(getLayoutInflater(), SearchResultFragment.this, list);// 나중에 list보내줘야함
//                        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
//                        recv_search_result.setLayoutManager(manager);
//                        recv_search_result.setAdapter(adapter);
                        search_type = "barcode";    //탭레이아웃에서 뭐 검색해서 온지 파악용
//                        ln_search_exist.setVisibility(View.VISIBLE);
//                        recv_search_result.setVisibility(View.VISIBLE);
                    } else {
                        getChildFragmentManager().beginTransaction().replace(R.id.container_search_result, new NotFoundFragment(search_text)).commit();
//                        ln_search_exist.setVisibility(View.GONE);
//                        recv_search_result.setVisibility(View.GONE);
                    }

                }
            });

        }


        //카테고리로 검색 넘어옴








       /* //임시테스트
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





        //리사이클러뷰 붙이기
//* 임시 : 비스포크 검색시 DB에 있는 데이터 받아오기
        CommonConn conn = new CommonConn(getContext(), "list.mo");
//        conn.addParams("search_text",search_text); DB 맵퍼에ㅔ서 were조건이 되어질검색어에 해당 우선은 데이터 받아와 지는지 확인한 뒤에 추후 수정
        conn.executeConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                if(isResult){
                    ArrayList<CategorySearchVO> list = new Gson().fromJson(data,
                            new TypeToken<ArrayList<CategorySearchVO>>() {
                            }.getType());

                    SearchResultAdapter adapter = new SearchResultAdapter(getLayoutInflater(), SearchResultFragment.this, list);// 나중에 list보내줘야함
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
                    recv_search_result.setLayoutManager(manager);
                    recv_search_result.setAdapter(adapter);
                }
            }
        });*/


        return v;
    }

    public void search_list() {
        //입력한 text로 DB검색 : list받아오기

    }

}