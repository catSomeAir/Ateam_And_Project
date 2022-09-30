package com.example.last_project.postList;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.postList.adapter.RequestedPostAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class RequestedPostActivity extends AppCompatActivity {
    RecyclerView requested_post_recv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requested_post);
        requested_post_recv =findViewById(R.id.requested_post_recv);
        /*list = new ArrayList<RequestedPostVO>();*/

        CommonConn conn = new CommonConn(RequestedPostActivity.this,"requestedpost");
        conn.executeConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                Log.d("result", "onResult: "+isResult);
                ArrayList<RequestedPostVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<RequestedPostVO>>(){}.getType());
                RequestedPostAdapter adapter = new RequestedPostAdapter(getLayoutInflater(),list);
                RecyclerView.LayoutManager manager= new LinearLayoutManager(RequestedPostActivity.this, RecyclerView.VERTICAL,false);
                requested_post_recv.setAdapter(adapter);
                requested_post_recv.setLayoutManager(manager);
            }
        });



    }
}