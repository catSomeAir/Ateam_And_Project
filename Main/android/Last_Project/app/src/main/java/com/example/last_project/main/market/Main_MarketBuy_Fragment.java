package com.example.last_project.main.market;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.last_project.R;
import com.example.last_project.common.CommonVal;

public class Main_MarketBuy_Fragment extends Fragment {
    TextView market_tv_point1_1, market_tv_point2_1, market_tv_menu_price1;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main__market_buy_, container, false);
//        DecimalFormat myFormatter = new DecimalFormat("###,###"); //포맷 나중에
//        int userpoint = Integer.parseInt(myFormatter.format(CommonVal.userInfo.getPoint()));//숫자 콤마 포맷

        market_tv_point1_1 = v.findViewById(R.id.market_tv_point1_1);
        market_tv_point2_1 = v.findViewById(R.id.market_tv_point2_1);
        market_tv_menu_price1 = v.findViewById(R.id.market_tv_menu_price1);

//        market_tv_menu_price1.setPaintFlags(market_tv_menu_price1.pai //취소선 넣다가 보류

//        market_tv_point1_1.setText(userpoint);
        if(CommonVal.userInfo == null) {
            market_tv_point1_1.setText("");
        }else {
            market_tv_point1_1.setText(CommonVal.userInfo.getPoint());

        }

        return v;
    }


}