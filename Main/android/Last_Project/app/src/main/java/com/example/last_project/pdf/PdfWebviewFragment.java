package com.example.last_project.pdf;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;

import com.example.last_project.R;

public class PdfWebviewFragment extends Fragment {

    WebView pdf_webView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_pdf_webview, container, false);

        return v;

    }
}