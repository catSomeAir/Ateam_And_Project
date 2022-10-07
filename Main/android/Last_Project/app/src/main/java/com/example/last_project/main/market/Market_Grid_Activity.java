package com.example.last_project.main.market;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;

import java.util.ArrayList;

public class Market_Grid_Activity extends AppCompatActivity {
    GridView grid_view;
    ImageView market_grid_back;



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 200){

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_grid);

        grid_view = findViewById(R.id.grid_view);
        market_grid_back = findViewById(R.id.market_grid_back);
        market_grid_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        ArrayList<GridVO> grid_list = new ArrayList<>();
        grid_list.add(new GridVO(R.drawable.img_gifticon_br1, "배스킨라빈스"
                , "더블주니어 아이스크림","4,700"));
        grid_list.add(new GridVO(R.drawable.img_gifticon_sb1, "서브웨이"
                , "에그마요(15cm) 쿠키세트","7,400"));
        grid_list.add(new GridVO(R.drawable.img_gifticon_tj1, "뚜레쥬르"
                , "새우오믈렛토스트","4,000"));
        grid_list.add(new GridVO(R.drawable.img_gifticon_gc1, "공차"
                , "얼그레이 밀크티L","4,200"));
        grid_list.add(new GridVO(R.drawable.img_gifticon_mega1, "메가MGC커피"
                , "유니콘매직에이드(블루)","3,500"));
        grid_list.add(new GridVO(R.drawable.img_gifticon_mega2, "메가MGC커피"
                , "자몽에이드","3,500"));
        grid_list.add(new GridVO(R.drawable.img_gifticon_mega3, "메가MGC커피"
                , "(ICE)아메리카노","2,000"));
        grid_list.add(new GridVO(R.drawable.market_gifticon2, "스타벅스"
                , "아이스 카페 아메리카노 T 2잔","9,000"));

        Market_Grid_Adapter adapter = new Market_Grid_Adapter(grid_list, getLayoutInflater());
        grid_view.setAdapter(adapter);





    }
}