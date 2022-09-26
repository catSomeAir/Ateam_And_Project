package com.example.last_project.event;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;


public class EventActivity extends AppCompatActivity {
    RecyclerView recv_event;
    Integer[] event_imgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        recv_event = findViewById(R.id.recv_event);
        //event_imgs = new Integer[5];
        event_imgs= new Integer[]{R.drawable.banner1, R.drawable.banner2, R.drawable.banner3, R.drawable.banner4, R.drawable.banner5, R.drawable.banner6};

        EventAdapter adapter = new EventAdapter(getLayoutInflater(),event_imgs);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recv_event.setAdapter(adapter);
        recv_event.setLayoutManager(manager);
    }


}