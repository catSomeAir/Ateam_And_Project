package com.example.last_project.main.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.common.CommonVal;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.search.category_search.CategorySearchVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class Main_Tab_MyManaulFragment extends Fragment {
    RecyclerView recv_main_mymanual;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main__tab__my_manaul, container, false);
        recv_main_mymanual = v.findViewById(R.id.recv_main_mymanual);

        //형태가 같아서 사용함

        if( CommonVal.userInfo != null ) {
            CommonConn conn = new CommonConn(getContext(), "my_manual_list");
            conn.addParams("email", CommonVal.userInfo.getEmail());
            conn.executeConn_no_dialog(new CommonConn.ConnCallback() {
                @Override
                public void onResult(boolean isResult, String data) {
                    if(isResult){
                        ArrayList<CategorySearchVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<CategorySearchVO>>(){}.getType());
                        getChildFragmentManager().beginTransaction().replace(R.id.container_main_mymanual, new Main_Tab_MyManualExistFragment(list)).commit();
                    }
                }
            });
        }else{
            getChildFragmentManager().beginTransaction().replace(R.id.container_main_mymanual, new Main_Tab_MyManualNoFragment()).commit();
        }
        return v;
    }
}