package com.example.last_project.main.tab;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.common.CommonMethod;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.search.category_search.CategorySearchVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class RecentResultFragment extends Fragment {

    RecyclerView recv_main_recent;
    int result_type ;

    public RecentResultFragment(int result_type) {
        this.result_type = result_type;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recent_result, container, false);
        recv_main_recent = v.findViewById(R.id.recv_main_recent);

        if(result_type== 1){

        }else if(result_type==2){
            CommonConn conn = new CommonConn(getContext(), "recent_list");
            conn.addParams("data", new Gson().toJson(CommonMethod.getStringArrayPref(getContext(),"recent_list")));
            conn.executeConn_no_dialog(new CommonConn.ConnCallback() {
                @Override
                public void onResult(boolean isResult, String data) {
                    ArrayList<CategorySearchVO> list = new Gson().fromJson(data,
                            new TypeToken<ArrayList<CategorySearchVO>>() {
                            }.getType());
                    Log.d("232323", "onResult: "+data);
                    Main_Tab_Adapter adapter = new Main_Tab_Adapter(getContext(), getLayoutInflater(),list);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                    recv_main_recent.setLayoutManager(manager);
                    recv_main_recent.setAdapter(adapter);
                }
            });









        }


        return v;
    }
}