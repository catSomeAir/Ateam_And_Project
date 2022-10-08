package com.example.last_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.barcode.BarcodeActivity;
import com.example.last_project.category.CategoryActivity;
import com.example.last_project.common.CommonMethod;
import com.example.last_project.common.CommonVal;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.main.banner.BannerActivity;
import com.example.last_project.main.manysearch.ManySearchAdapter;
import com.example.last_project.main.market.MarketActivity;
import com.example.last_project.main.tab.Main_Tab_HomeFragment;
import com.example.last_project.main.tab.Main_Tab_MyManaulFragment;
import com.example.last_project.main.tab.Main_Tab_RecentFragment;
import com.example.last_project.member.MemberVO;
import com.example.last_project.mypage.MypageActivity;
import com.example.last_project.search.NotFoundAlertActivity;
import com.example.last_project.search.SearchActivity;
import com.example.last_project.search.category_search.CategorySearchVO;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hitomi.cmlibrary.CircleMenu;
import com.ramotion.circlemenu.CircleMenuView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgv_main_category;
    TabLayout tabs;
    LinearLayout ln_main_search;
    RecyclerView recv_main_manysearch;
    CircleMenuView menuView;
    CircleMenu menuView1;
    //카테고리 클릭
    LinearLayout ln_ctg_gajeon, ln_ctg_computer, ln_ctg_mobile, ln_ctg_car, ln_ctg_gagu, ln_ctg_adong, ln_ctg_samu, ln_ctg_leisure;

    CardView cdv_plus;

    ImageView imgv_middle_banner;
    GoogleSignInClient mGoogleSignInClient;
    NestedScrollView scrollView;
    private final int RC_SIGN_IN = 1000;
    Main_Tab_HomeFragment mtFragment = new Main_Tab_HomeFragment();
    //마켓
    LinearLayout ln_main_market1, ln_main_market2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //자동로그인확인

        //소셜
        //구글
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
        String email = preferences.getString("email", null);
        String pw = preferences.getString("pw", null);
        String social_code = preferences.getString("social_code", null);
        if(social_code != null){
            if(!social_code.equals("0")) {
                if (social_code.equals("G")) {
                    Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                    startActivityForResult(signInIntent, RC_SIGN_IN);
                } else if (social_code.equals("N")) {

                } else if (social_code.equals("K")) {

                }
            }else{
                CommonConn conn = new CommonConn(MainActivity.this, "login.me");
                conn.addParams("email", email);
                conn.addParams("pw",pw);
                conn.executeConn_no_dialog(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {
                        if(isResult){

                            if(data == null){
                                Toast.makeText(MainActivity.this, "회원정보가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(MainActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                                CommonVal.userInfo = new Gson().fromJson(data, MemberVO.class);


                            }
                        }else {
                            Toast.makeText(MainActivity.this ,"로그인실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

//        SharedPreferences.Editor editor = preferences.edit();   // Editer 객체를 리턴하는 메소드
//        editor.putString("email", CommonVal.userInfo.getEmail());
//        editor.putString("pw", CommonVal.userInfo.getPw());
//        editor.apply();


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

        //테스트
        menuView1 = findViewById(R.id.circle_menu1);
        menuView1.setMainMenu(Color.parseColor("#123456") ,R.drawable.barcode, R.drawable.barcode)
                    .addSubMenu(Color.parseColor("#123456") ,R.drawable.mail)
                    .addSubMenu(Color.parseColor("#123456") ,R.drawable.mail)
                    .addSubMenu(Color.parseColor("#123456") ,R.drawable.mail);


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
            }

            @Override
            public void onButtonClickAnimationEnd(@NonNull CircleMenuView view, int index) {
                if(index==0){
                    Intent intent = new Intent(MainActivity.this, BarcodeActivity.class);
                    startActivity(intent);
                }else if(index ==1){

                }else if(index ==2){

                }else if(index ==3){
                    Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                    startActivity(intent);

                }else if(index ==4){
                    if(CommonVal.userInfo != null){
                        Intent intent = new Intent(MainActivity.this, MypageActivity.class);
                        startActivity(intent);

                    }else{
                        Intent intent = new Intent(MainActivity.this, NotFoundAlertActivity.class);
                        intent.putExtra("intent_type", "write");
                        startActivity(intent);
                    }
                }
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
                    mtFragment = new Main_Tab_HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_main, mtFragment).commit();

                    return;

                }else if(tab.getPosition()==1){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_main, new Main_Tab_MyManaulFragment()).commit();


                }else{
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_main, new Main_Tab_RecentFragment()).commit();
                }
                mtFragment.stopThread();

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
                if (acct != null) {
                    String personName = acct.getDisplayName();
                    String personGivenName = acct.getGivenName();
                    String personFamilyName = acct.getFamilyName();
                    String personEmail = acct.getEmail();
                    String personId = acct.getId();
                    Uri personPhoto = acct.getPhotoUrl();
                    /*구글 로그인 정보 DB에 저장*/
                    CommonConn conn = new CommonConn(MainActivity.this,"socialinfo.me");

                    MemberVO vo = new MemberVO();
                    vo.setSocial_code("G");
                    vo.setEmail(personEmail);
                    vo.setName(personName);
                    vo.setFilepath(personPhoto.toString());

                    conn.addParams("vo", new Gson().toJson(vo));
                    conn.executeConn_no_dialog(new CommonConn.ConnCallback() {
                        @Override
                        public void onResult(boolean isResult, String data) {
                            Log.d("Result", "onResult: "+ isResult);
                            MemberVO vo =  new Gson().fromJson(data, MemberVO.class);
                            CommonVal.userInfo = vo;
                            saveLoginInfo();

                        }
                    });
                }
            } catch (ApiException e) {
                e.printStackTrace();
            }

        }
    }
    //자동로그인 메소드
    public void saveLoginInfo() {
        SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();   // Editer 객체를 리턴하는 메소드
        editor.putString("email", CommonVal.userInfo.getEmail());
        editor.putString("pw", CommonVal.userInfo.getPw());
        editor.putString("social_code", CommonVal.userInfo.getSocial_code());
        editor.apply();
    }
}









