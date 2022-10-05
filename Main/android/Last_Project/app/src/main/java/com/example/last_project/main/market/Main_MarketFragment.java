package com.example.last_project.main.market;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.last_project.R;
import com.example.last_project.common.CommonVal;
import com.example.last_project.member.LoginActivity;
import com.google.android.material.tabs.TabLayout;

public class Main_MarketFragment extends Fragment {
    TabLayout market_tabs;
    FragmentActivity fragmentActivity;
    Button market_btn;

    Dialog market_dialog, market_null_dialog;


    public Main_MarketFragment(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main__market, container, false);

        market_tabs = v.findViewById(R.id.market_tabs);

        market_null_dialog = new Dialog(getContext());
        market_null_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        market_null_dialog.setContentView(R.layout.market_null_dialog);

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
        market_btn =  fragmentActivity.findViewById(R.id.market_btn);
        market_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CommonVal.userInfo == null) {
                    showMarket_loginDialog();



                } else {

                    fragmentActivity.getSupportFragmentManager().beginTransaction().replace(R.id.market_container, new Main_MarketBuy_Fragment(fragmentActivity)).commit(); //결제화면 연결
                    market_btn.setText("확인");
//                    int result = Integer.parseInt(CommonVal.userInfo.getPoint()) - Integer.parseInt(product_point);
//                    CommonConn conn = new CommonConn(MarketActivity.this, "gift_insert"); //스프링 연결 url 지정
//                    conn.addParams("email", CommonVal.userInfo.getEmail()); //정보를 담아 넘겨줌
//                    conn.addParams("porint", result+"");
//                    conn.executeConn(new CommonConn.ConnCallback() {
//                        @Override
//                        public void onResult(boolean isResult, String data) {
//
//                        }
//                    });
                }
            }
        });

        return v;
    }
//    if (CommonVal.userInfo == null) {
//                    showMarket_loginDialog();
//
//
//
//                } else {
//                    showMarketDialog();
//                    Main_MarketBuy_Fragment fragment = new Main_MarketBuy_Fragment();
//
//                    product_point = fragment.market_tv_point2_1.getText().toString();
//                    int result = Integer.parseInt(CommonVal.userInfo.getPoint()) - Integer.parseInt(product_point);
//                    getSupportFragmentManager().beginTransaction().replace(R.id.market_container, fragment).commit(); //결제화면 연결
//
//                    CommonConn conn = new CommonConn(MarketActivity.this, "gift_insert"); //스프링 연결 url 지정
//                    conn.addParams("email", CommonVal.userInfo.getEmail()); //정보를 담아 넘겨줌
//                    conn.addParams("porint", result+"");
//                    conn.executeConn(new CommonConn.ConnCallback() {
//                        @Override
//                        public void onResult(boolean isResult, String data) {
//
//                        }
//                    });
//                }
//            }
//
//        });

    public void showMarket_loginDialog(){
        market_null_dialog.show();
        market_null_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        market_null_dialog.findViewById(R.id.market_btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                market_null_dialog.dismiss();

            }
        });
    }
}