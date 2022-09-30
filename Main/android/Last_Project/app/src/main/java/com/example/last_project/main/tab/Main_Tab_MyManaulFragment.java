package com.example.last_project.main.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_project.R;

public class Main_Tab_MyManaulFragment extends Fragment {
    RecyclerView recv_main_mymanual;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main__tab__my_manaul, container, false);
        recv_main_mymanual = v.findViewById(R.id.recv_main_mymanual);

        //형태가 같아서 사용함


        return v;


    }
}