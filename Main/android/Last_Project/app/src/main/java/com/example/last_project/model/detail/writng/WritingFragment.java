package com.example.last_project.model.detail.writng;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.last_project.R;
import com.example.last_project.common.CommonVal;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.search.NotFoundAlertActivity;
import com.example.last_project.search.category_search.CategorySearchVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class WritingFragment extends Fragment implements View.OnClickListener {

    LinearLayout ln_writing_all, ln_writing_opinion, ln_writing_qna;
    TextView tv_writing_all, tv_writing_opinion, tv_writing_qna, tv_write_catg, tv_write_brand, tv_write_model_name, tv_write_model_code;
    ImageView imgv_profile, imgv_write_photo;
    CardView edt_writing;
    ArrayList<BoardVO> list;
    CategorySearchVO model_info;
    public WritingFragment(CategorySearchVO model_info) {

        this.model_info = model_info;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_writing, container, false);

        imgv_profile = v.findViewById(R.id.imgv_profile);

        tv_write_catg = v.findViewById(R.id.tv_write_catg);
        tv_write_catg.setText(model_info.getCategory_name());

        tv_write_brand = v.findViewById(R.id.tv_write_brand);
        tv_write_brand.setText(model_info.getBrand_name());

        tv_write_model_name = v.findViewById(R.id.tv_write_model_name);
        tv_write_model_name.setText(model_info.getModel_name());

        tv_write_model_code = v.findViewById(R.id.tv_write_model_code);
        tv_write_model_code.setText(model_info.getModel_code());

        imgv_write_photo = v.findViewById(R.id.imgv_write_photo);
        Glide.with(getContext()).load(model_info.getFilepath().replace("localhost", "121.147.215.12:3302").replace("192.168.0.33","121.147.215.12:3302")).into(imgv_write_photo);



        //로그인 유저
        if (CommonVal.userInfo != null) {
            if (CommonVal.userInfo.getFilepath() != null) {
                Glide.with(getContext()).load(CommonVal.userInfo.getFilepath().replace("localhost", "121.147.215.12:3302").replace("192.168.0.33","121.147.215.12:3302")).into(imgv_profile);
            }
        }

        ln_writing_all = v.findViewById(R.id.ln_writing_all);
        ln_writing_opinion = v.findViewById(R.id.ln_writing_opinion);
        ln_writing_qna = v.findViewById(R.id.ln_writing_qna);
        tv_writing_all = v.findViewById(R.id.tv_writing_all);
        tv_writing_opinion = v.findViewById(R.id.tv_writing_opinion);
        tv_writing_qna = v.findViewById(R.id.tv_writing_qna);
        ln_writing_all.setOnClickListener(this);
        ln_writing_opinion.setOnClickListener(this);
        ln_writing_qna.setOnClickListener(this);


        //edittext
        edt_writing = v.findViewById(R.id.edt_writing);


        edt_writing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CommonVal.userInfo == null) {
                    Intent intent = new Intent(getContext(), NotFoundAlertActivity.class);   //이름은 다른데 같은기능이라 그냥씀
                    intent.putExtra("intent_type", "write"); //글쓰기에서 띄운 alert
                    edt_writing.clearFocus();
                    startActivity(intent);
                } else if (CommonVal.userInfo != null) {  //로그인 된 상태에서 입력할 수 있는 엑티비티로 이동
                    Intent intent = new Intent(getContext(), WriteSpaceActivity.class);
                    intent.putExtra("model_code", model_info.getModel_code());
                    intent.putExtra("page", "WritingFragment_board");
                    startActivity(intent);
                }
            }
        });



        // 해당모델의 글 조회
        CommonConn conn = new CommonConn(getContext(), "board_list_select");
        conn.addParams("model_code", model_info.getModel_code());
        conn.addParams("cmt_code", "a");
        conn.executeConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                if(isResult){
                    list = new Gson().fromJson(data, new TypeToken<ArrayList<BoardVO>>(){}.getType());
                    if(list != null){
                        getChildFragmentManager().beginTransaction().replace(R.id.container_write, new ExistWriteListFragment(model_info.getModel_code(), list)).commit();
                        if(list.size()==0){
                            getChildFragmentManager().beginTransaction().replace(R.id.container_write, new NoWriteListFragment()).commit();
                        }
                    }else{
                        getChildFragmentManager().beginTransaction().replace(R.id.container_write, new NoWriteListFragment()).commit();
                    }
                }
            }
        });
//        CommonConn conn = new CommonConn(getContext(), "board_list_select");
//        conn.addParams("model_code", model_code);
//        conn.addParams("cmt_code", "a");
//        conn.executeConn(new CommonConn.ConnCallback() {
//            @Override
//            public void onResult(boolean isResult, String data) {
//                if(isResult){
//                    list = new Gson().fromJson(data, new TypeToken<ArrayList<BoardVO>>(){}.getType());
//                    NoWriteListFragment fragment = new NoWriteListFragment();
//                    if(list.size() != 0){
//                        WriteAdapter adapter = new WriteAdapter(getLayoutInflater(), getContext(), list);
//                        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
//                        recv_write.setLayoutManager(manager);
//                        recv_write.setAdapter(adapter);
//                        getChildFragmentManager().beginTransaction().remove(fragment);
//                    }else{
//                        getChildFragmentManager().beginTransaction().replace(R.id.container_no_write_list, fragment).commit();
//                    }
//                }
//            }
//        });




        return v;
    }

    @Override
    public void onClick(View v) {
        // 전체 , 의견, 질문 눌렀을 때 해당 결과만 나오도록 처리 해야함 , DB에 해당 컬럼 추가
        if (v.getId() == R.id.ln_writing_all || v.getId() == R.id.ln_writing_opinion || v.getId() == R.id.ln_writing_qna) {
            tv_writing_all.setTextColor(Color.parseColor("#a9a9a9"));
            tv_writing_opinion.setTextColor(Color.parseColor("#a9a9a9"));
            tv_writing_qna.setTextColor(Color.parseColor("#a9a9a9"));
            ln_writing_all.setBackgroundResource(R.drawable.shape_gray_radius);
            ln_writing_opinion.setBackgroundResource(R.drawable.shape_gray_radius);
            ln_writing_qna.setBackgroundResource(R.drawable.shape_gray_radius);


            if (v.getId() == R.id.ln_writing_all) {
                ln_writing_all.setBackgroundResource(R.drawable.shape_navy_radius);
                tv_writing_all.setTextColor(Color.parseColor("#d9d9d9"));
                CommonConn conn = new CommonConn(getContext(), "board_list_select");
                conn.addParams("model_code", model_info.getModel_code());
                conn.addParams("cmt_code", "a");
                conn.executeConn(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {
                        if(isResult){
                            list = new Gson().fromJson(data, new TypeToken<ArrayList<BoardVO>>(){}.getType());
                            if(list != null){
                                getChildFragmentManager().beginTransaction().replace(R.id.container_write, new ExistWriteListFragment(model_info.getModel_code(), list)).commit();
                                if(list.size()==0){
                                    getChildFragmentManager().beginTransaction().replace(R.id.container_write, new NoWriteListFragment()).commit();
                                }
                            }else{
                                getChildFragmentManager().beginTransaction().replace(R.id.container_write, new NoWriteListFragment()).commit();
                            }
                        }
                    }
                });


            } else if (v.getId() == R.id.ln_writing_opinion) {
                ln_writing_opinion.setBackgroundResource(R.drawable.shape_navy_radius);
                tv_writing_opinion.setTextColor(Color.parseColor("#d9d9d9"));
                CommonConn conn = new CommonConn(getContext(), "board_list_select");
                conn.addParams("model_code", model_info.getModel_code());
                conn.addParams("cmt_code", "o");
                conn.executeConn(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {
                        if(isResult){
                            list = new Gson().fromJson(data, new TypeToken<ArrayList<BoardVO>>(){}.getType());
                            if(list != null){
                                getChildFragmentManager().beginTransaction().replace(R.id.container_write, new ExistWriteListFragment(model_info.getModel_code(), list)).commit();
                                if(list.size()==0){
                                    getChildFragmentManager().beginTransaction().replace(R.id.container_write, new NoWriteListFragment()).commit();
                                }
                            }else{
                                getChildFragmentManager().beginTransaction().replace(R.id.container_write, new NoWriteListFragment()).commit();
                            }
                        }
                    }
                });

            } else if (v.getId() == R.id.ln_writing_qna) {
                ln_writing_qna.setBackgroundResource(R.drawable.shape_navy_radius);
                tv_writing_qna.setTextColor(Color.parseColor("#d9d9d9"));
                CommonConn conn = new CommonConn(getContext(), "board_list_select");
                conn.addParams("model_code", model_info.getModel_code());
                conn.addParams("cmt_code", "q");
                conn.executeConn(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {
                        if(isResult){
                            list = new Gson().fromJson(data, new TypeToken<ArrayList<BoardVO>>(){}.getType());
                            if(list != null){
                                getChildFragmentManager().beginTransaction().replace(R.id.container_write, new ExistWriteListFragment(model_info.getModel_code(), list)).commit();
                                if(list.size()==0){
                                    getChildFragmentManager().beginTransaction().replace(R.id.container_write, new NoWriteListFragment()).commit();
                                }
                            }else{
                                getChildFragmentManager().beginTransaction().replace(R.id.container_write, new NoWriteListFragment()).commit();
                            }
                        }
                    }
                });

            }
        }
    }


}