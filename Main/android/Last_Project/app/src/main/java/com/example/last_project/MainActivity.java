package com.example.last_project;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
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
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
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
import com.example.last_project.model.detail.writng.ReplyVO;
import com.example.last_project.mypage.MypageActivity;
import com.example.last_project.news.NewsActivity;
import com.example.last_project.news.NewsVO;
import com.example.last_project.postList.BookmarkedPostActivity;
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
import com.ramotion.circlemenu.CircleMenuView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgv_main_category;
    TabLayout tabs;
    LinearLayout ln_main_search;
    RecyclerView recv_main_manysearch;
    CircleMenuView menuView;

    //????????????
    String reply_cnt_before, reply_cnt_after;//???????????? ??? ?????? ???????????? ?????? ?????????
    String notice_cnt_before, notice_cnt_after;

    boolean conn_check;
    //    CircleMenu menuView1;
    //???????????? ??????
    LinearLayout ln_ctg_gajeon, ln_ctg_computer, ln_ctg_mobile, ln_ctg_car, ln_ctg_gagu, ln_ctg_adong, ln_ctg_samu, ln_ctg_leisure;

    CardView cdv_plus;

    ImageView imgv_middle_banner;
    GoogleSignInClient mGoogleSignInClient;
    NestedScrollView scrollView;
    private final int RC_SIGN_IN = 1000;
    Main_Tab_HomeFragment mtFragment = new Main_Tab_HomeFragment();
    //??????
    LinearLayout ln_main_market1, ln_main_market2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //??????????????????

            news_alarm();





        //?????????????????????

        //??????
        //??????
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
        String email = preferences.getString("email", null);
        String pw = preferences.getString("pw", null);
        String social_code = preferences.getString("social_code", null);
        if (social_code != null) {
            if (!social_code.equals("0")) {
                if (social_code.equals("G")) {
                    Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                    startActivityForResult(signInIntent, RC_SIGN_IN);
                } else if (social_code.equals("N")) {

                } else if (social_code.equals("K")) {

                }
            } else {
                CommonConn conn = new CommonConn(MainActivity.this, "login.me");
                conn.addParams("email", email);
                conn.addParams("pw", pw);
                conn.executeConn_no_dialog(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {
                        if (isResult) {

                            if (data == null) {
                                Toast.makeText(MainActivity.this, "??????????????? ???????????? ????????????.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "????????? ??????", Toast.LENGTH_SHORT).show();
                                CommonVal.userInfo = new Gson().fromJson(data, MemberVO.class);


                            }
                        } else {
                            Toast.makeText(MainActivity.this, "???????????????", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

//        SharedPreferences.Editor editor = preferences.edit();   // Editer ????????? ???????????? ?????????
//        editor.putString("email", CommonVal.userInfo.getEmail());
//        editor.putString("pw", CommonVal.userInfo.getPw());
//        editor.apply();


        //???????????? ?????? -> ???????????? OnClickListener???
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

        //?????? ??? list ??????????????? ??????
        CommonVal.recent_list = CommonMethod.getStringArrayPref(MainActivity.this, "recent_list");

        //?????? circle menu?????????????????? +??????
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
                }, 500); //????????? ?????? ??????
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        menuView.open(true);
                    }
                }, 850); //????????? ?????? ??????
            }
        });
        //?????? circle menu

        menuView = findViewById(R.id.circle_menu);

        menuView.setEventListener(new CircleMenuView.EventListener() {
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
                if (index == 0) {
                    Intent intent = new Intent(MainActivity.this, BarcodeActivity.class);
                    startActivity(intent);

                } else if (index == 1) {
                    Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                    startActivity(intent);
                } else if (index == 2) {
                    if (CommonVal.userInfo != null) {
                        Intent intent = new Intent(MainActivity.this, BookmarkedPostActivity.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(MainActivity.this, NotFoundAlertActivity.class);
                        intent.putExtra("intent_type", "write");
                        startActivity(intent);
                    }
                } else if (index == 3) {
                    Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                    startActivity(intent);

                } else if (index == 4) {
                    if (CommonVal.userInfo != null) {
                        Intent intent = new Intent(MainActivity.this, MypageActivity.class);
                        startActivity(intent);

                    } else {
                        Intent intent = new Intent(MainActivity.this, NotFoundAlertActivity.class);
                        intent.putExtra("intent_type", "write");
                        startActivity(intent);
                    }
                }
                overridePendingTransition(0, 0);

                cdv_plus.setVisibility(View.VISIBLE);
                menuView.setVisibility(View.GONE);
            }

        });


        //val <=  var
        //interface
        //?????? ???????????????--------------------------------------------------------------------
        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("???").setTag(1));
        tabs.addTab(tabs.newTab().setText("???????????????").setTag(2));
        tabs.addTab(tabs.newTab().setText("??????").setTag(3));
        tabs.getTabAt(0).select();

        getSupportFragmentManager().beginTransaction().replace(R.id.container_main, new Main_Tab_HomeFragment()).commit();

        //??????????????? ?????? ?????????
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    mtFragment = new Main_Tab_HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_main, mtFragment).commit();

                    return;

                } else if (tab.getPosition() == 1) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_main, new Main_Tab_MyManaulFragment()).commit();


                } else {
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

        //???????????? ?????? ??????
        imgv_main_category = findViewById(R.id.imgv_main_category);
        imgv_main_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slideing_left_enter, R.anim.hold);
            }
        });

        //????????? ??????
        ln_main_search = findViewById(R.id.ln_main_search);
        ln_main_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        //?????? ??????????????? : DB?????? ??????

        recv_main_manysearch = findViewById(R.id.recv_main_manysearch);


        CommonConn conn = new CommonConn(MainActivity.this, "main_many_list");
        conn.executeConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                if (isResult) {
                    ArrayList<CategorySearchVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<CategorySearchVO>>() {
                    }.getType());
                    ManySearchAdapter adapter = new ManySearchAdapter(getLayoutInflater(), list, MainActivity.this);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false);
                    recv_main_manysearch.setLayoutManager(manager);
                    recv_main_manysearch.setAdapter(adapter);
                }
            }
        });


        //??????
        ln_main_market1 = findViewById(R.id.ln_main_market1);
        ln_main_market1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MarketActivity.class);
                intent.putExtra("item_num", 1);
                startActivity(intent);
            }
        });
        ln_main_market2 = findViewById(R.id.ln_main_market2);
        ln_main_market2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MarketActivity.class);
                intent.putExtra("item_num", 2);
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

        if (v.getId() == R.id.ln_ctg_gajeon) {
            intent.putExtra("category", 1);
        } else if (v.getId() == R.id.ln_ctg_computer) {
            intent.putExtra("category", 2);
        } else if (v.getId() == R.id.ln_ctg_mobile) {
            intent.putExtra("category", 3);
        } else if (v.getId() == R.id.ln_ctg_car) {
            intent.putExtra("category", 4);
        } else if (v.getId() == R.id.ln_ctg_gagu) {
            intent.putExtra("category", 5);
        } else if (v.getId() == R.id.ln_ctg_adong) {
            intent.putExtra("category", 6);
        } else if (v.getId() == R.id.ln_ctg_samu) {
            intent.putExtra("category", 7);
        } else if (v.getId() == R.id.ln_ctg_leisure) {
            intent.putExtra("category", 8);
        }
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        tabs.getTabAt(1).select();
//        tabs.getTabAt(2).select();
        tabs.getTabAt(0).select();
        news_alarm();

        scrollView.smoothScrollTo(0, 0);
        recv_main_manysearch.scrollToPosition(0);

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
                    /*?????? ????????? ?????? DB??? ??????*/
                    CommonConn conn = new CommonConn(MainActivity.this, "socialinfo.me");

                    MemberVO vo = new MemberVO();
                    vo.setSocial_code("G");
                    vo.setEmail(personEmail);
                    vo.setName(personName);
                    vo.setFilepath(personPhoto.toString());

                    conn.addParams("vo", new Gson().toJson(vo));
                    conn.executeConn_no_dialog(new CommonConn.ConnCallback() {
                        @Override
                        public void onResult(boolean isResult, String data) {
                            Log.d("Result", "onResult: " + isResult);
                            MemberVO vo = new Gson().fromJson(data, MemberVO.class);
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

    //??????????????? ?????????
    public void saveLoginInfo() {
        SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();   // Editer ????????? ???????????? ?????????
        editor.putString("email", CommonVal.userInfo.getEmail());
        editor.putString("pw", CommonVal.userInfo.getPw());
        editor.putString("social_code", CommonVal.userInfo.getSocial_code());
        editor.apply();
    }

    //???????????? ?????????
    public void news_alarm() {

        // ?????? ?????? : ????????????, ??????????????? ??????, ??????????????? ???????????? ????????????
        // ???????????? ?????? email??? ????????? ????????? count??? ????????? ?????? ?????? ????????? ??????????????????
        //???????????? notice, board, req_board
//        CommonConn while_conn = new CommonConn(MainActivity.this, "alarm");
//        while_conn.addParams("email", CommonVal.userInfo);
//        while_conn.executeConn(new CommonConn.ConnCallback() {
//            @Override
//            public void onResult(boolean isResult, String data) {
//
//            }
//        });

        //?????? ??? ??? ?????? ????????? ??????
        if (CommonVal.userInfo != null) {
            if (reply_cnt_before != null) { //????????? ????????? ????????? ????????? ????????????

                CommonConn reply_cnt_conn = new CommonConn(MainActivity.this, "reply_cnt");
                reply_cnt_conn.addParams("email", CommonVal.userInfo.getEmail());
                reply_cnt_conn.executeConn_no_dialog(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {
                        reply_cnt_after = data;
                        if(!reply_cnt_before.equals(reply_cnt_after)){  //????????? ?????? ?????????
                            conn_check = true;  //????????? ???????????? ????????? ???????????? ??????????????????

                        }
                    }
                });
                if(conn_check){
                    //?????? ??????????????? ????????????
                    CommonConn reply_info = new CommonConn(MainActivity.this, "reply_info");
                    reply_info.addParams("email", CommonVal.userInfo.getEmail());
                    reply_info.executeConn_no_dialog(new CommonConn.ConnCallback() {
                        @Override
                        public void onResult(boolean isResult, String data) {
                            NewsVO newsVO = new NewsVO();
                            ReplyVO replyVO = new Gson().fromJson(data,ReplyVO.class);

                            newsVO.setReply_vo(replyVO);
                            CommonVal.alarm_list.add(newsVO);
                            reply_cnt_before = reply_cnt_after;
                            conn_check = false;
                            push_alarm();
                        }
                    });
                }
            }else {
                CommonConn reply_cnt_conn = new CommonConn(MainActivity.this, "reply_cnt");
                reply_cnt_conn.addParams("email", CommonVal.userInfo.getEmail());
                reply_cnt_conn.executeConn_no_dialog(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {
                        reply_cnt_before = data;

                    }
                });
            }
//            if(notice_cnt_before != null){
//
//            }


        }
    }

    public void push_alarm(){

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.logo_navy);
        Bitmap smallIcon = BitmapFactory.decodeResource(getResources(), R.drawable.logo_navy);

        String description = "??????";
        String CHANNEL_ID = "??????";
        String name1 = "??????";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name1, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        PendingIntent pendingIntent =
                PendingIntent.getActivity(MainActivity.this, 4
                        , new Intent(getApplicationContext()
                                , MainActivity.class), Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ? PendingIntent.FLAG_IMMUTABLE : PendingIntent.FLAG_UPDATE_CURRENT);
        //???????????? ?????? ???????????? FLAG ?????? ?????? ????????????


        NotificationCompat.Builder builder =
                null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                    .setSmallIcon(IconCompat.createWithBitmap(smallIcon))
                    .setContentTitle("???????????????")
                    .setContentText(CommonVal.alarm_list.get(CommonVal.alarm_list.size()).getReply_vo().getEmail() + "?????? ????????? ???????????????\n" + CommonVal.alarm_list.get(CommonVal.alarm_list.size()).getReply_vo().getContent()+"    ?????? ???")
                    .setDefaults(Notification.DEFAULT_VIBRATE)
                    .setStyle(new NotificationCompat.InboxStyle()
                            .addLine(CommonVal.alarm_list.get(CommonVal.alarm_list.size()).getReply_vo().getEmail() + "?????? ????????? ???????????????    ?????? ???")
                            .addLine(CommonVal.alarm_list.get(CommonVal.alarm_list.size()).getReply_vo().getContent()))
                    .setLargeIcon(largeIcon)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setAutoCancel(true)

                    .setContentIntent(pendingIntent);
        }

        NotificationManager manager = (NotificationManager) MainActivity.this.getSystemService(MainActivity.this.NOTIFICATION_SERVICE);
        if (manager != null)

            manager.notify(1, builder.build());
    }
}









