package com.example.last_project.model;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;
import com.github.barteksc.pdfviewer.PDFView;

public class ModelDetailActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_detail);

        pdfView = findViewById(R.id.pdfView);

        pdfView.fromAsset("Manual.pdf").load();


    }
}