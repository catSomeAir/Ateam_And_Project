package com.example.last_project.main.tab;

import android.os.Bundle;
import android.util.Log;
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
    private int num_page = 4;                             //indicator 수

    private boolean thread_check = true;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main__tab__home, container, false);

        //뷰페이지
        vp_main_tap_home = v.findViewById(R.id.vp_main_tap_home);
        vp_main_tap_home.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL); //뷰페이지 방향설정 : 가로
        vp_main_tap_home.setCurrentItem(1000); //시작 지점
        vp_main_tap_home.setOffscreenPageLimit(4); //최대 이미지 수

        //뷰페이지 adapter
        bannerAdapter = new HomeFragmentAdapter(Main_Tab_HomeFragment.this, num_page);      //파라메터 : fragment, int count
        vp_main_tap_home.setAdapter(bannerAdapter); //뷰페이지에 adpater연결

        //Indicator
        indicator_main_tap_home = v.findViewById(R.id.indicator_main_tap_home);

        //Indicator -> 뷰페이지 연결
        indicator_main_tap_home.setViewPager(vp_main_tap_home);
        indicator_main_tap_home.createIndicators(num_page, 0);
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
//        autoSlide();
        return v;
    }

    public void autoSlide() {
        // new Handler<- SlpashActivity 페이지전환
        // runOnUiThread : 비동기로 화면전환 쓰레드사용  --->> Activity 단에서만 사용가능

        if (thread_check) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        for (int i = 0; i < 3000; i++) {
                            final int value = i;
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    //비동기로 디자인 작업

                                    vp_main_tap_home.setCurrentItem(value);  //현재 아이템
                                }
                            });

                            try {
                                if (i == 3000 - 1) {
                                    i = -1;
                                }
                                Thread.sleep(4500);

                            } catch (Exception e) {
                            }
                        }
                    }
                }).start();



        }

    }

    @Override
    public void onStart() {
        super.onStart();
        vp_main_tap_home.setCurrentItem(0);
        autoSlide();
        thread_check = true;
        Log.d("주기", "onStart: ");
    }



    @Override
    public void onStop() {
        super.onStop();
        thread_check = false;
        Log.d("주기", "onStop: ");

    }


}