package com.example.last_project.request;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;

public class RequestManualActivity extends AppCompatActivity {

    Spinner spinner;
    String select_category;
    String[] items= {"가전/tv", "컴퓨터 / 노트북", "태블릿 / 모바일", "자동차용품 / 공구", "가구 / 조명", "아동 / 유아", "사무", "취미 / 레저"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_manual);

        spinner = findViewById(R.id.spinner);

        //
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                select_category = spinner.getSelectedItem().toString();
                Log.d("스피너", "onCreate: "+ select_category);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}