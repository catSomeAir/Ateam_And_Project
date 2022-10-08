package com.example.last_project.mypage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.last_project.R;
import com.example.last_project.common.CommonVal;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.main.market.GiftVO;
import com.example.last_project.main.market.Market_Grid_Activity;
import com.example.last_project.member.MemberVO;
import com.example.last_project.point.PointActivity;
import com.example.last_project.postList.BookmarkedPostActivity;
import com.example.last_project.postList.DownloadedManualActivity;
import com.example.last_project.postList.RequestedPostActivity;
import com.example.last_project.postList.postListActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;

public class MypageActivity extends AppCompatActivity {
    LinearLayout edit_profile, my_post, my_reply, requested_post, point, market_buy_list, bookmarked_post, downloaded_manual;
    TabLayout tabs;
    TextView market_buy_qty,tv_nickname,tv_post_count,tv_reply_count, tv_my_level, tv_my_point;
    //뒤로가기버튼
    ImageView imgv_back, imgv_category_profile;


    private ArrayList<String> array_list;

    //    GridView grid_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
//        grid_view = findViewById(R.id.grid_view);


        //내등급, 포인트
        tv_my_level = findViewById(R.id.tv_my_level);
        tv_my_point = findViewById(R.id.tv_my_point);


        tabs = findViewById(R.id.tabs);
        /*마이페이지 화면연결*/

        edit_profile = findViewById(R.id.ll_edit_profile);
        /*이거 누르면 mypostfragment로 이동*/
        my_post = findViewById(R.id.ll_my_post);
        /*이거 누르면 myreplyfragment로 이동*/
        my_reply = findViewById(R.id.ll_my_reply);
        /*이거 누르면 RequestedPostActivity로 이동*/
        requested_post = findViewById(R.id.ll_requested_post);
        /*이거 누르면 pointactivity로 이동*/
        point = findViewById(R.id.ll_point);
        /*이거 누르면 아인언니가 만드신 구매내역보여주는 화면으로 이동*/

        //다운로드한 파일뜨도록하는거
        downloaded_manual = findViewById(R.id.ll_downloaded_manual);

        imgv_category_profile = findViewById(R.id.imgv_category_profile);
        tv_nickname = findViewById(R.id.tv_nickname);
        tv_post_count = findViewById(R.id.tv_post_count);
        tv_reply_count = findViewById(R.id.tv_reply_count);
        //이미지 나오게 하는 부분
        if (CommonVal.userInfo != null) {
            MemberVO vo = CommonVal.userInfo;
            if (vo.getFilepath() != null) {
                //피카소 글라이드 비교해봐야할듯
//            Picasso.get().load(CommonVal.userInfo.getProfile_img()).into(imgv_category_profile);
                Glide.with(MypageActivity.this).load(vo.getFilepath()).into(imgv_category_profile);
            }

            //등급, 포인트 나오게
            tv_my_level.setText("lv."+vo.getMy_level());
            tv_my_point.setText(vo.getPoint());
            //닉네임 나오게
            tv_nickname.setText(vo.getNickname()==null||vo.getNickname().equals("")?vo.getEmail():vo.getNickname());
            CommonConn conn = new CommonConn(MypageActivity.this, "count.ct");
            conn.addParams("email", vo.getEmail());
            conn.executeConn(new CommonConn.ConnCallback() {
                @Override
                public void onResult(boolean isResult, String data) {
                    if (isResult) {
                        HashMap<String, String> map = new Gson().fromJson(data, new TypeToken<HashMap<String, String>>() {
                        }.getType());
                        tv_post_count.setText(map.get("board_count"));
                        tv_reply_count.setText(map.get("reply_count"));
                    }
                }
            });

            //아인 수정중 ↓ ----------------------------------------------------------------------
            market_buy_list = findViewById(R.id.market_buy_list);
            market_buy_qty = findViewById(R.id.market_buy_qty);//구매내역에 해당 회원 포인트가 보이도록 처리하기 위한 id

            CommonConn buyconn = new CommonConn(MypageActivity.this, "gift.me");
            buyconn.addParams("email", CommonVal.userInfo.getEmail());
            buyconn.executeConn(new CommonConn.ConnCallback() {
                @Override
                public void onResult(boolean isResult, String data) {
                    ArrayList<GiftVO> list_gson = new Gson().fromJson(data
                            , new TypeToken<ArrayList<GiftVO>>() {
                            }.getType());
                    market_buy_qty.setText(list_gson.size() + "");


                }
            });

            market_buy_list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), Market_Grid_Activity.class);
//                startActivity(intent);
                    startActivityForResult(new Intent(MypageActivity.this, Market_Grid_Activity.class), 200);
                }

            });
            //아인----------------<뒤로가는 이미지 수정함>--------------------------------------
            imgv_back = findViewById(R.id.imgv_back);
            imgv_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
//                startActivity(intent);
                    finish(); //이게 뒤로가기누르는거랑 같은건데 이거는 아무것도없는상태에서 엑티비티 켜져있으면 뒤로가기버튼 = finish(); 같아요
                    overridePendingTransition(0,0);
                }
            });

            //아인 ↑----------------------------------------------------------------------------------


            /*이거 누르면 즐겨찾기한 설명서 보여줌*/
            bookmarked_post = findViewById(R.id.ll_bookmarked_post);

            edit_profile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MypageActivity.this, EditProfileActivity.class);
                    startActivity(intent);
                }
            });
            my_post.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MypageActivity.this, postListActivity.class);
                    intent.putExtra("1", "0");
                    startActivity(intent);

                }
            });
            my_reply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MypageActivity.this, postListActivity.class);
                    intent.putExtra("1", "1");
                    startActivity(intent);

                }
            });
            requested_post.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MypageActivity.this, RequestedPostActivity.class);
                    startActivity(intent);
                }
            });
            point.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MypageActivity.this, PointActivity.class);
                    startActivity(intent);
                }
            });

            bookmarked_post.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MypageActivity.this, BookmarkedPostActivity.class);
                    startActivity(intent);
                }
            });


            downloaded_manual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MypageActivity.this, DownloadedManualActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}