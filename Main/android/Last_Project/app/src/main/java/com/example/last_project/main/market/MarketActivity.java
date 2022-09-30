package com.example.last_project.main.market;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.MainActivity;
import com.example.last_project.R;

public class MarketActivity extends AppCompatActivity {
    ImageView  market_btn_back;
    Button market_btn;
    Dialog market_dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        market_btn_back = findViewById(R.id.market_btn_back);
        market_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarketActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        int item = intent.getIntExtra("item_num",-1);

        if( item == 1 ){
            getSupportFragmentManager().beginTransaction().replace(R.id.market_container, new Main_MarketFragment()).commit();
        }else if( item == 2 ){
            getSupportFragmentManager().beginTransaction().replace(R.id.market_container, new Main_Market_gifticon_Fragment()).commit();
        }


        market_btn = findViewById(R.id.market_btn); // fragment 로 버튼 옮길 예정
        market_dialog = new Dialog(MarketActivity.this);
        market_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        market_dialog.setContentView(R.layout.market_dialog);

        market_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                showMarketDialog();
            }
        });





    }

    public void showMarketDialog(){
        market_dialog.show();
        market_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        market_dialog.findViewById(R.id.market_btn_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //상품 목록으로 이동 예정 - HAI
                market_dialog.dismiss();
                finish();
            }
        });


    }
}