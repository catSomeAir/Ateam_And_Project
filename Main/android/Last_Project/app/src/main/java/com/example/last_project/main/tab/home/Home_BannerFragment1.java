package com.example.last_project.main.tab.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.last_project.R;
import com.example.last_project.event.EventDetailActivity;


public class Home_BannerFragment1 extends Fragment {
    ImageView imgv_main_banner1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home__banner1, container, false);

        imgv_main_banner1 = v.findViewById(R.id.imgv_main_banner1);
        imgv_main_banner1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EventDetailActivity.class);
                intent.putExtra("index", "0");
                startActivity(intent);

            }
        });

        return v;
    }
}