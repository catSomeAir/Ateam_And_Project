package com.example.last_project.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;
import com.example.last_project.common.CommonVal;


public class NewsExistFragment extends Fragment {
    RecyclerView recv_news;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_nesw_exist, container, false);

        recv_news = v.findViewById(R.id.recv_news);
        NewsAdapter adapter = new NewsAdapter(getLayoutInflater(), getContext(), CommonVal.alarm_list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        recv_news.setLayoutManager(manager);
        recv_news.setAdapter(adapter);

        return v;
    }
}