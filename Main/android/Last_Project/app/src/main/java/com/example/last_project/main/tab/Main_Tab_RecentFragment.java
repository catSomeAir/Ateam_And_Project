package com.example.last_project.main.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.last_project.R;
import com.example.last_project.common.CommonVal;

public class Main_Tab_RecentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main__tab__recent, container, false);

        if( CommonVal.recent_list == null || CommonVal.recent_list.size() ==0 ){
            getChildFragmentManager().beginTransaction().replace(R.id.container_main_recent, new NotRecentFragment()).commit();
        }else {
            getChildFragmentManager().beginTransaction().replace(R.id.container_main_recent, new RecentResultFragment(2)).commit();
        }

        return v;
    }
}