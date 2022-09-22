package com.example.last_project;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
import androidx.cardview.widget.CardView;
=======
>>>>>>> 456bce5d00044f8495d6999f8f1c61bdf6d5fd46
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.barcord.BarcordActivity;
import com.example.last_project.category.CategoryActivity;
import com.example.last_project.main.manysearch.ManySearchAdapter;
import com.example.last_project.main.tab.Main_Tab_HomeFragment;
import com.example.last_project.search.SearchActivity;
import com.google.android.material.tabs.TabLayout;
import com.ramotion.circlemenu.CircleMenuView;

public class MainActivity extends AppCompatActivity {
    ImageView imgv_main_category;
    TabLayout tabs;
    LinearLayout ln_main_search;
    RecyclerView recv_main_manysearch;
<<<<<<< HEAD
    CircleMenuView menuView;

    CardView cdv_plus;
=======
>>>>>>> 456bce5d00044f8495d6999f8f1c61bdf6d5fd46

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //하단 circle menu나오도록하는 +버튼
        cdv_plus = findViewById(R.id.cdv_plus);
        cdv_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cdv_plus.setVisibility(View.GONE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                       menuView.setVisibility(View.VISIBLE);

                    }
                }, 500); //딜레이 타임 조절
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        menuView.open(true);
                    }
                }, 850); //딜레이 타임 조절
            }
        });
        //하단 circle menu
        menuView = findViewById(R.id.circle_menu);
        menuView.setEventListener(new CircleMenuView.EventListener(){
            @Override
            public void onMenuOpenAnimationStart(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuOpenAnimationStart: ");
            }

            @Override
            public void onMenuOpenAnimationEnd(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuOpenAnimationEnd: ");
            }

            @Override
            public void onMenuCloseAnimationStart(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuCloseAnimationStart: ");
            }

            @Override
            public void onMenuCloseAnimationEnd(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuCloseAnimationEnd: ");
                cdv_plus.setVisibility(View.VISIBLE);
                menuView.setVisibility(View.GONE);
            }

            @Override
            public void onButtonClickAnimationStart(@NonNull CircleMenuView view, int index) {
                Log.d("D", "onButtonClickAnimationStart: ");
                if(index==0){
                    Intent intent = new Intent(MainActivity.this, BarcordActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onButtonClickAnimationEnd(@NonNull CircleMenuView view, int index) {
                cdv_plus.setVisibility(View.VISIBLE);
                menuView.setVisibility(View.GONE);
            }

        });








        //val <=  var
        //interface
        //메인 탭레이아웃--------------------------------------------------------------------
        tabs =findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("홈").setTag(1));
        tabs.addTab(tabs.newTab().setText("나의설명서").setTag(2));
        tabs.addTab(tabs.newTab().setText("최근").setTag(3));
        tabs.getTabAt(0).select();

        getSupportFragmentManager().beginTransaction().replace(R.id.container_main, new Main_Tab_HomeFragment()).commit();

        //탭레이아웃 선택 이벤트
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_main, new Main_Tab_HomeFragment()).commit();
                }else if(tab.getPosition()==1){
                    Intent intent = new Intent(MainActivity.this, WebviewActivity.class);
                    intent.putExtra("url", "https://m.map.kakao.com/actions/searchView?q=%EC%82%BC%EC%84%B1%EC%84%9C%EB%B9%84%EC%8A%A4%EC%84%BC%ED%84%B0&wxEnc=LVSOTP&wyEnc=QNLTTMN&lvl=4");//placeSearch
                    startActivity(intent);
                }else{

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //-------------------------------------------------------------------------------------

        //카테고리 버튼 선택
        imgv_main_category = findViewById(R.id.imgv_main_category);
        imgv_main_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slideing_left_enter, R.anim.hold);
            }
        });

        //검색란 터치
        ln_main_search = findViewById(R.id.ln_main_search);
        ln_main_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        //많이 검색한목록
        recv_main_manysearch = findViewById(R.id.recv_main_manysearch);
        ManySearchAdapter adapter = new ManySearchAdapter(getLayoutInflater());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL , false);
        recv_main_manysearch.setLayoutManager(manager);
        recv_main_manysearch.setAdapter(adapter);


    }


}









