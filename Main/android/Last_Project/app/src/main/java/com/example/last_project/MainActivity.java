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
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.barcord.BarcordActivity;
import com.example.last_project.category.CategoryActivity;
import com.example.last_project.common.CommonMethod;
import com.example.last_project.common.CommonVal;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.main.banner.BannerActivity;
import com.example.last_project.main.manysearch.ManySearchAdapter;
import com.example.last_project.main.market.MarketActivity;
import com.example.last_project.main.tab.Main_Tab_HomeFragment;
import com.example.last_project.main.tab.Main_Tab_RecentFragment;
import com.example.last_project.search.SearchActivity;
import com.example.last_project.search.category_search.CategorySearchVO;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ramotion.circlemenu.CircleMenuView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgv_main_category;
    TabLayout tabs;
    LinearLayout ln_main_search;
    RecyclerView recv_main_manysearch;
    CircleMenuView menuView;
    //카테고리 클릭
    LinearLayout ln_ctg_gajeon, ln_ctg_computer, ln_ctg_mobile, ln_ctg_car, ln_ctg_gagu, ln_ctg_adong, ln_ctg_samu, ln_ctg_leisure;

    CardView cdv_plus;

    ImageView imgv_middle_banner;

    NestedScrollView scrollView;
    //마켓
    LinearLayout ln_main_market1, ln_main_market2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //카테고리 클릭 -> 이벤트는 OnClickListener에
        ln_ctg_gajeon = findViewById(R.id.ln_ctg_gajeon);
        ln_ctg_gajeon.setOnClickListener(this);
        ln_ctg_computer = findViewById(R.id.ln_ctg_computer);
        ln_ctg_computer.setOnClickListener(this);
        ln_ctg_mobile = findViewById(R.id.ln_ctg_mobile);
        ln_ctg_mobile.setOnClickListener(this);
        ln_ctg_car = findViewById(R.id.ln_ctg_car);
        ln_ctg_car.setOnClickListener(this);
        ln_ctg_gagu = findViewById(R.id.ln_ctg_gagu);
        ln_ctg_gagu.setOnClickListener(this);
        ln_ctg_adong = findViewById(R.id.ln_ctg_adong);
        ln_ctg_adong.setOnClickListener(this);
        ln_ctg_samu = findViewById(R.id.ln_ctg_samu);
        ln_ctg_samu.setOnClickListener(this);
        ln_ctg_leisure = findViewById(R.id.ln_ctg_leisure);
        ln_ctg_leisure.setOnClickListener(this);

        scrollView = findViewById(R.id.scrollView);

        //최근 본 list 담겨있는거 사용
        CommonVal.recent_list = CommonMethod.getStringArrayPref(MainActivity.this, "recent_list");

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
                }else if(index ==1){

                }else if(index ==2){

                }else if(index ==3){
                    Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                    startActivity(intent);

                }else if(index ==4){
                    if(CommonVal.userInfo != null){
                        Intent intent = new Intent(MainActivity.this, CategoryActivity.class);

                    }
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
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_main, new Main_Tab_RecentFragment()).commit();
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

        //많이 검색한목록 : DB에서 조회

        recv_main_manysearch = findViewById(R.id.recv_main_manysearch);


        CommonConn conn = new CommonConn(MainActivity.this, "main_many_list");
        conn.executeConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                if(isResult){
                    ArrayList<CategorySearchVO> list = new Gson().fromJson(data,new TypeToken<ArrayList<CategorySearchVO>>() {}.getType());
                    ManySearchAdapter adapter = new ManySearchAdapter(getLayoutInflater(), list, MainActivity.this);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL , false);
                    recv_main_manysearch.setLayoutManager(manager);
                    recv_main_manysearch.setAdapter(adapter);
                }
            }
        });





        //마켓
        ln_main_market1 = findViewById(R.id.ln_main_market1);
        ln_main_market1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MarketActivity.class);
                intent.putExtra("item_num",1);
                startActivity(intent);
            }
        });
        ln_main_market2 = findViewById(R.id.ln_main_market2);
        ln_main_market2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MarketActivity.class);
                intent.putExtra("item_num",2);
                startActivity(intent);
            }
        });

        imgv_middle_banner = findViewById(R.id.imgv_middle_banner);
        imgv_middle_banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BannerActivity.class);
                startActivity(intent);
            }
        });

    }//oncreate


    @Override
    public void onClick(View v) {
       // ln_ctg_gajeon, ln_ctg_computer, ln_ctg_mobile, ln_ctg_car, ln_ctg_gagu, ln_ctg_adong, ln_ctg_samu, ln_ctg_leisure;

        Intent intent = new Intent(MainActivity.this, CategoryActivity.class);

        if(v.getId() == R.id.ln_ctg_gajeon){
            intent.putExtra("category", 1);
        }else if(v.getId() == R.id.ln_ctg_computer){
            intent.putExtra("category", 2);
        }else if(v.getId() == R.id.ln_ctg_mobile){
            intent.putExtra("category", 3);
        }else if(v.getId() == R.id.ln_ctg_car){
            intent.putExtra("category", 4);
        }else if(v.getId() == R.id.ln_ctg_gagu){
            intent.putExtra("category", 5);
        }else if(v.getId() == R.id.ln_ctg_adong){
            intent.putExtra("category", 6);
        }else if(v.getId() == R.id.ln_ctg_samu){
            intent.putExtra("category", 7);
        }else if(v.getId() == R.id.ln_ctg_leisure){
            intent.putExtra("category", 8);
        }
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tabs.getTabAt(0).select();
        scrollView.smoothScrollTo(0,0);
        recv_main_manysearch.scrollToPosition(0 );

    }
}









