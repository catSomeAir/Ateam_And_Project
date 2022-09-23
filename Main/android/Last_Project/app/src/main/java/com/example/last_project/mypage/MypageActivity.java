package com.example.last_project.mypage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;
import com.example.last_project.point.PointActivity;
import com.example.last_project.postList.BookmarkedPostActivity;
import com.example.last_project.postList.RequestedPostActivity;
import com.example.last_project.postList.postListActivity;

public class MypageActivity extends AppCompatActivity {
    LinearLayout edit_profile,my_post,my_reply,requested_post,point,구매내역,bookmarked_post;
    //뒤로가기버튼
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
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
        구매내역 =findViewById(R.id.ll_구매내역);
        /*이거 누르면 즐겨찾기한 설명서 보여줌*/
        bookmarked_post = findViewById(R.id.ll_bookmarked_post);

        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),EditProfileActivity.class);
                startActivity(intent);
            }
        });
        my_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), postListActivity.class);
                startActivity(intent);
            }
        });
        my_reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), postListActivity.class);
                startActivity(intent);
            }
        });
        requested_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RequestedPostActivity.class);
                startActivity(intent);
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PointActivity.class);
                startActivity(intent);
            }
        });
        /*아직 합치기 전이라 구매내역은 나중에 할 예정*/
        bookmarked_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BookmarkedPostActivity.class);
                startActivity(intent);
            }
        });
    }
}