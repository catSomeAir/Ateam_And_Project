package com.example.last_project.main.market;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;

public class MarketActivity extends AppCompatActivity {

    Button market_btn;
    Dialog market_dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        Main_MarketFragment fragment = new Main_MarketFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.market_container, fragment).commit();

        market_btn = findViewById(R.id.market_btn);
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