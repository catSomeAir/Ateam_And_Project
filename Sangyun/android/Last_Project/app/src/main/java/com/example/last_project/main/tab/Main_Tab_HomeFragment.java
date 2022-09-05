package com.example.last_project.main.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.last_project.R;
import com.example.last_project.main.tab.home.HomeFragmentAdapter;

import me.relex.circleindicator.CircleIndicator3;

public class Main_Tab_HomeFragment extends Fragment {
    private ViewPager2 vp_main_tap_home;                  //뷰페이지
    private FragmentStateAdapter bannerAdapter;           //배너 붙이기
    private CircleIndicator3 indicator_main_tap_home;     //뷰페이지 indicator
    private int num_page = 3;                             //indicator 수
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main__tab__home, container, false);

        //뷰페이지
        vp_main_tap_home = v.findViewById(R.id.vp_main_tap_home);
        vp_main_tap_home.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL); //뷰페이지 방향설정 : 가로
        vp_main_tap_home.setCurrentItem(1000); //시작 지점
        vp_main_tap_home.setOffscreenPageLimit(3); //최대 이미지 수

        //뷰페이지 adapter
        bannerAdapter = new HomeFragmentAdapter(Main_Tab_HomeFragment.this, num_page);      //파라메터 : fragment, int count
        vp_main_tap_home.setAdapter(bannerAdapter); //뷰페이지에 adpater연결

        //Indicator
        indicator_main_tap_home = v.findViewById(R.id.indicator_main_tap_home);

        //Indicator -> 뷰페이지 연결
        indicator_main_tap_home.setViewPager(vp_main_tap_home);

        vp_main_tap_home.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    vp_main_tap_home.setCurrentItem(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                indicator_main_tap_home.animatePageSelected(position % num_page);
            }
        });
        
        return v;
    }
}