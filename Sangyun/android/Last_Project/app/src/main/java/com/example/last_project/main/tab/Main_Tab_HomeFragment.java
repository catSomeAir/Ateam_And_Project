package com.example.last_project.main.tab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.last_project.R;

import me.relex.circleindicator.CircleIndicator3;

public class Main_Tab_HomeFragment extends Fragment {
    private ViewPager2 vp_main_tap_home;                  //뷰페이지
    private CircleIndicator3 indicator_main_tap_home;     //뷰페이지 indicator
    private int num_page = 3;                             //indicator 수
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main__tab__home, container, false);

        //뷰페이지
        vp_main_tap_home = v.findViewById(R.id.vp_main_tap_home);

        //Indicator
        indicator_main_tap_home = v.findViewById(R.id.indicator_main_tap_home);

        //Indicator -> 뷰페이지 연결
        indicator_main_tap_home.setViewPager(vp_main_tap_home);




        return v;
    }
}