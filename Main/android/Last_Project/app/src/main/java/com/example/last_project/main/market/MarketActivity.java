package com.example.last_project.main.market;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.MainActivity;
import com.example.last_project.R;

public class MarketActivity extends AppCompatActivity {
    ImageView market_btn_back;
    Button market_btn, market_btn_login, market_btn_cancel;
    Dialog market_dialog, market_null_dialog;
    FrameLayout market_container;
    TextView market_tv_menu_name, market_tv_point2_1;

    String product_point = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        market_container = findViewById(R.id.market_container);
        market_btn_login = findViewById(R.id.market_btn_login);
        market_btn_cancel = findViewById(R.id.market_btn_cancel);


        market_btn_back = findViewById(R.id.market_btn_back);

        market_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarketActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        market_btn = findViewById(R.id.market_btn); // fragment 로 버튼 옮길 예정OR
        market_dialog = new Dialog(MarketActivity.this);
        market_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        market_dialog.setContentView(R.layout.market_dialog);

        market_null_dialog = new Dialog(MarketActivity.this);
        market_null_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        market_null_dialog.setContentView(R.layout.market_null_dialog);

        market_tv_point2_1 = findViewById(R.id.market_tv_point2_1);
        Intent intent = getIntent();
        int item = intent.getIntExtra("item_num", -1);

        if (item == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.market_container, new Main_MarketFragment(MarketActivity.this)).commit();
        } else if (item == 2) {
            getSupportFragmentManager().beginTransaction().replace(R.id.market_container, new Main_Market_gifticon_Fragment()).commit();
        }

//        market_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GiftVO vo = new GiftVO();
//
////                if (CommonVal.userInfo == null) {
////                    showMarket_loginDialog();
////
////
////
////                } else {
////                    showMarketDialog();
////                    Main_MarketBuy_Fragment fragment = new Main_MarketBuy_Fragment();
////
////                    product_point = fragment.market_tv_point2_1.getText().toString();
////                    int result = Integer.parseInt(CommonVal.userInfo.getPoint()) - Integer.parseInt(product_point);
////                    getSupportFragmentManager().beginTransaction().replace(R.id.market_container, fragment).commit(); //결제화면 연결
////
////                    CommonConn conn = new CommonConn(MarketActivity.this, "gift_insert"); //스프링 연결 url 지정
////                    conn.addParams("email", CommonVal.userInfo.getEmail()); //정보를 담아 넘겨줌
////                    conn.addParams("porint", result+"");
////                    conn.executeConn(new CommonConn.ConnCallback() {
////                        @Override
////                        public void onResult(boolean isResult, String data) {
////
////                        }
////                    });
////                }
////            }
////
////        });
//
//
//
//
//
//    }
//
//    public void showMarketDialog(){
//        market_dialog.show();
//        market_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//        market_dialog.findViewById(R.id.market_btn_dialog).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                market_dialog.dismiss();
//                finish();
//            }
//        });
//
//
//    }
//
//    public void showMarket_loginDialog(){
//        market_null_dialog.show();
//        market_null_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        market_null_dialog.findViewById(R.id.market_btn_login).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//                startActivity(intent);
//                market_null_dialog.dismiss();
//
//            }
//        });
//    }
    }
}

