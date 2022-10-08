package com.example.last_project.postList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.CommonAlertActivity;
import com.example.last_project.R;
import com.example.last_project.common.CommonVal;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.postList.adapter.EdtBookmarkedPostAdapter;
import com.example.last_project.postList.adapter.EdtBookmarkedPost_deleteAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class EdtBookmarkedPostActivity extends AppCompatActivity implements EdtBookmarkedPostAdapter.OnStartDragListener {
    RecyclerView rv_edt_bookmarked_post;
    ImageView imgv_back;
    Button btn_edt_save, btn_edt_delete;
    ArrayList<BookmarkEdtVO> edt_list = new ArrayList<>();
    ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edt_bookmarked_post);
        rv_edt_bookmarked_post = findViewById(R.id.rv_edt_bookmarked_post);
        imgv_back = findViewById(R.id.imgv_back);
        btn_edt_save = findViewById(R.id.btn_edt_save);
        btn_edt_delete = findViewById(R.id.btn_edt_delete);

        CommonConn conn = new CommonConn(EdtBookmarkedPostActivity.this, "bookmarkedpost");
        conn.addParams("email", CommonVal.userInfo.getEmail());
        conn.executeConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                Log.d("result", "onResult: " + isResult);
                ArrayList<BookmarkedPostVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<BookmarkedPostVO>>() {
                }.getType());

                for (int i = 0; i < list.size(); i++) {
                    edt_list.add(new BookmarkEdtVO(list.get(i), false));
                }
                EdtBookmarkedPostAdapter adapter = new EdtBookmarkedPostAdapter(getLayoutInflater(), edt_list, EdtBookmarkedPostActivity.this, EdtBookmarkedPostActivity.this, EdtBookmarkedPostActivity.this);
                RecyclerView.LayoutManager manager = new LinearLayoutManager(EdtBookmarkedPostActivity.this, RecyclerView.VERTICAL, false);
                BookmarkItemTouchCallback mCallback = new BookmarkItemTouchCallback(adapter);
                mItemTouchHelper = new ItemTouchHelper(mCallback);
                mItemTouchHelper.attachToRecyclerView(rv_edt_bookmarked_post);
                rv_edt_bookmarked_post.setAdapter(adapter);
                rv_edt_bookmarked_post.setLayoutManager(manager);
            }
        });

        btn_edt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<BookmarkEdtVO> new_list = new ArrayList<>();
                for (int i = 0; i < edt_list.size(); i++) {
                    if (!edt_list.get(i).isChecked()) {
                        new_list.add(new BookmarkEdtVO(edt_list.get(i).getVo(), false));
                    }
                }
                EdtBookmarkedPost_deleteAdapter adapter = new EdtBookmarkedPost_deleteAdapter(getLayoutInflater(), new_list, EdtBookmarkedPostActivity.this, EdtBookmarkedPostActivity.this);
                RecyclerView.LayoutManager manager = new LinearLayoutManager(EdtBookmarkedPostActivity.this, RecyclerView.VERTICAL, false);
                rv_edt_bookmarked_post.setLayoutManager(manager);
                rv_edt_bookmarked_post.setAdapter(adapter);

                EdtBookmarkedPostAdapter adapter1 = new EdtBookmarkedPostAdapter(getLayoutInflater(), new_list, EdtBookmarkedPostActivity.this, EdtBookmarkedPostActivity.this, EdtBookmarkedPostActivity.this);
                RecyclerView.LayoutManager manager1 = new LinearLayoutManager(EdtBookmarkedPostActivity.this, RecyclerView.VERTICAL, false);
                BookmarkItemTouchCallback mCallback = new BookmarkItemTouchCallback(adapter1);
                mItemTouchHelper = new ItemTouchHelper(mCallback);
                mItemTouchHelper.attachToRecyclerView(rv_edt_bookmarked_post);
                rv_edt_bookmarked_post.setLayoutManager(manager1);
                rv_edt_bookmarked_post.setAdapter(adapter1);


            }
        });

        btn_edt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EdtBookmarkedPostActivity.this, CommonAlertActivity.class);
                intent.putExtra("page", "EdtBookmarkedPostActivity_save");
                startActivityForResult(intent,0);
                overridePendingTransition(0,0);



            }
        });

        //뒤로 가기 버튼 누르면 뒤로감
        imgv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0, 0);
            }
        });
    }

    @Override
    public void onStartDrag(EdtBookmarkedPostAdapter.ViewHolder holder) {
        mItemTouchHelper.startDrag(holder);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode  == 1){
            for (int i = 0; i < edt_list.size(); i++) {
                if (edt_list.get(i).isChecked()) {
                    CommonConn conn = new CommonConn(EdtBookmarkedPostActivity.this, "my_manual_delete");
                    conn.addParams("email", CommonVal.userInfo.getEmail());
                    conn.addParams("model_code", edt_list.get(i).getVo().getModel_code());
                    edt_list.remove(i);
                    conn.executeConn_no_dialog(new CommonConn.ConnCallback() {
                        @Override
                        public void onResult(boolean isResult, String data) {

                        }
                    });
                }
            }
            finish();
        }
    }
}