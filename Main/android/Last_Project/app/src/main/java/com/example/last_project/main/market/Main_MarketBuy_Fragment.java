package com.example.last_project.main.market;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.last_project.R;
import com.example.last_project.common.CommonVal;
import com.example.last_project.conn.CommonConn;

public class Main_MarketBuy_Fragment extends Fragment {
    TextView market_tv_point1_1, market_tv_point2_1, market_tv_menu_price1;
//    Dialog market_null_dialog;

    Button market_btn;
    Dialog market_dialog, market_null_dialog, nopoing_dialog;
    FragmentActivity fragmentActivity;
    int product_point, having_point;
    public Main_MarketBuy_Fragment(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

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

        //다이얼로그
        market_dialog = new Dialog(getContext());
        market_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        market_dialog.setContentView(R.layout.market_dialog);

        market_null_dialog = new Dialog(getContext());
        market_null_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        market_null_dialog.setContentView(R.layout.market_null_dialog);

        nopoing_dialog = new Dialog(getContext());
        nopoing_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        nopoing_dialog.setContentView(R.layout.nopoint_dialog);

        //엑티비티에있는 버튼
        market_btn = fragmentActivity.findViewById(R.id.market_btn);
//        market_tv_menu_price1.setPaintFlags(market_tv_menu_price1.pai //취소선 넣다가 보류

//        market_tv_point1_1.setText(userpoint);
        if(CommonVal.userInfo != null) {
            Log.d("포인트", "onCreateView: "+CommonVal.userInfo.getPoint());
            market_tv_point1_1.setText(CommonVal.userInfo.getPoint());
        }else {
            market_tv_point1_1.setText("0");
        }

        market_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product_point = Integer.parseInt(market_tv_point2_1.getText().toString());
                having_point = Integer.parseInt(CommonVal.userInfo.getPoint());

                int result  = having_point - product_point;
                if(result>= 0){
                showMarketDialog();
                    CommonConn conn = new CommonConn(getContext(), "gift_insert"); //스프링 연결 url 지정
                    conn.addParams("email", CommonVal.userInfo.getEmail()); //정보를 담아 넘겨줌
                    conn.addParams("point", result);
                    CommonVal.userInfo.setPoint(result+"");
                    conn.executeConn(new CommonConn.ConnCallback() {
                        @Override
                        public void onResult(boolean isResult, String data) {

                        }
                    });
                }else {
                    show_nopoint_ialog();
                }


                getActivity().finish();
            }
        });


        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(CommonVal.userInfo != null) {
            Log.d("포인트", "onCreateView: "+CommonVal.userInfo.getPoint());
            market_tv_point1_1.setText(CommonVal.userInfo.getPoint());
        }else {
            market_tv_point1_1.setText("0");

        }

    }
    public void showMarketDialog(){
        market_dialog.show();
        market_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        market_dialog.findViewById(R.id.market_btn_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                market_dialog.dismiss();
                getActivity().finish();
            }
        });


    }
    public void show_nopoint_ialog(){
        nopoing_dialog.show();
        nopoing_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        nopoing_dialog.findViewById(R.id.market_btn_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nopoing_dialog.dismiss();
                getActivity().finish();
            }
        });


    }

}