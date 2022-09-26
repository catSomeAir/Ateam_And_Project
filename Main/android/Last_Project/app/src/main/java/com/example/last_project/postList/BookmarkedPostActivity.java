package com.example.last_project.postList;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.postList.adapter.BookmarkedPostAdapter;

import java.util.ArrayList;

public class BookmarkedPostActivity extends AppCompatActivity {
    RecyclerView bookmarked_post_recv;
    ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarked_post);
         list= new ArrayList<String>();
         list.add(new String("냉장고"));
        bookmarked_post_recv =findViewById(R.id.bookmarked_post_recv);

        BookmarkedPostAdapter adapter = new BookmarkedPostAdapter(getLayoutInflater(),list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(BookmarkedPostActivity.this,RecyclerView.VERTICAL, false);
        bookmarked_post_recv.setAdapter(adapter);
        bookmarked_post_recv.setLayoutManager(manager);
    }
}