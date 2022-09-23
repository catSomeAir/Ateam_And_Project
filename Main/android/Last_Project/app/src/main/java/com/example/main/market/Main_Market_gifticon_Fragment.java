package com.example.last_project.main.market;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.last_project.R;
import com.google.android.material.tabs.TabLayout;

public class Main_Market_gifticon_Fragment extends Fragment {
    TabLayout market_tabs;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main__market_gifticon_, container, false);

        market_tabs = v.findViewById(R.id.market_tabs);


        getChildFragmentManager().beginTransaction().replace(R.id.market_container, new Main_Market_Tab_A_Fragment()).commit();

        market_tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d("TAG", "onTabSelected: "+tab.getPosition());
                if(tab.getPosition() == 0){

                    getChildFragmentManager().beginTransaction().replace(R.id.market_container, new Main_Market_Tab_A_Fragment()).commit();
                } else if(tab.getPosition() == 1){
                    getChildFragmentManager().beginTransaction().replace(R.id.market_container, new Main_Market_Tab_B_Fragment()).commit();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        getChildFragmentManager()

        return v;
    }
}