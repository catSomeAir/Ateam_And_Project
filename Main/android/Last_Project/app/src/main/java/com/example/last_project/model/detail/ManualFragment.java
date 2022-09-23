package com.example.last_project.model.detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import com.example.last_project.R;
import com.example.last_project.WebviewActivity;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.google.android.material.tabs.TabLayout;
import com.shockwave.pdfium.PdfDocument;

import java.util.List;

public class ManualFragment extends Fragment implements OnPageChangeListener, OnLoadCompleteListener {

    GestureDetector detector;
    Context context;
    PDFView pdfView;
    String SAMPLE_FILE = "test.pdf";
    Integer pageNumber = 0;
    String  pdfFileName;
    LinearLayout ln_model_detail_writing, ln_model_detail_as;
    ImageView imgv_manual_zzim, imgv_manual_link, imgv_manual_download; //* 다운로드 버튼 구현예정


    ImageView imgv_manual_help; //따봉버튼
    TextView tv_manual_help; //따봉버튼
    LinearLayout ln_manual_help; //따봉버튼
    TextView tv_manual_help_cnt;    //도움수


    TextView tv_manual_name;
    boolean zzim, help_chk;

    NestedScrollView scrollView;
    public ManualFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_manual, container, false);

        //전체 스크롤뷰
        scrollView = v.findViewById(R.id.scrollView);

        //도움이 되었나요
        imgv_manual_help = v.findViewById(R.id.imgv_manual_help);
        tv_manual_help = v.findViewById(R.id.tv_manual_help);
        ln_manual_help = v.findViewById(R.id.ln_manual_help);
        tv_manual_help_cnt = v.findViewById(R.id.tv_manual_help_cnt);   //도움 수
        //도움이되었나요 클릭시
        ln_manual_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(help_chk){   //선택된 상황에서 클릭
                    imgv_manual_help.setImageResource(R.drawable.icon_thumbs);
                    tv_manual_help.setText("도움이\n되었나요?");
                    tv_manual_help.setTextColor(Color.parseColor("#4D4d4D"));
                    ln_manual_help.setBackgroundResource(R.drawable.shape_navy_border8);
                    tv_manual_help_cnt.setText(Integer.parseInt(tv_manual_help_cnt.getText().toString()) - 1+"");
                    help_chk = false;
                }else{ //선택안했을 시 클릭
                    imgv_manual_help.setImageResource(R.drawable.icon_thumbs_fill_white);
                    tv_manual_help.setText("도움이\n되었어요!");
                    tv_manual_help.setTextColor(Color.parseColor("#e9e9e9"));
                    ln_manual_help.setBackgroundResource(R.drawable.shape_navy_fill);
                    tv_manual_help_cnt.setText(Integer.parseInt(tv_manual_help_cnt.getText().toString()) + 1+"");
                    help_chk = true;
                }
            }
        });

        pdfView= (PDFView)v.findViewById(R.id.pdfView);
        displayFromAsset(SAMPLE_FILE);

        //상품의견, AS센터 -> 탭선택되도록하기
        ln_model_detail_writing = v.findViewById(R.id.ln_model_detail_writing);
        ln_model_detail_writing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               TabLayout tabs = (TabLayout) getActivity().findViewById(R.id.tabs);
               tabs.selectTab(tabs.getTabAt(1));
            }
        });
        ln_model_detail_as = v.findViewById(R.id.ln_model_detail_as);
        ln_model_detail_as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabLayout tabs = (TabLayout) getActivity().findViewById(R.id.tabs);
                tabs.selectTab(tabs.getTabAt(2));
            }
        });

        //찜하기 하트 선택 : DB정보에 넣어야할 예정임
        imgv_manual_zzim = v.findViewById(R.id.imgv_manual_zzim);
        imgv_manual_zzim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zzim){
                    imgv_manual_zzim.setImageResource(R.drawable.icon_heart);
                    zzim = false;
                }else{//찜이 안되어있을 때 찜하기 누르면
                    imgv_manual_zzim.setImageResource(R.drawable.icon_heart_fill);
                    zzim = true;
                    //* DB에 찜하기 선택되도록 해야함
                }
            }
        });

        //링크 해당 제품으로 검색하기
        imgv_manual_link = v.findViewById(R.id.imgv_manual_link);
        tv_manual_name = v.findViewById(R.id.tv_manual_name);
        imgv_manual_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebviewActivity.class);
                intent.putExtra("url", "https://www.google.com/search?q="+tv_manual_name.getText().toString()+"&oq="+tv_manual_name.getText().toString());
                startActivity(intent);
            }
        });
        return v;
    }
    private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;

        pdfView.fromAsset(SAMPLE_FILE)
                .defaultPage(pageNumber)
                .enableSwipe(true)
                .fitEachPage(true)
                .pageFling(true)
                .pageSnap(true)
                .autoSpacing(true)
                .swipeHorizontal(true)
                .onPageChange(this)
                .enableAnnotationRendering(false)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(getContext()))
                .load();

        if(pdfView.isSwipeEnabled()){
            pdfView.setSwipeEnabled(true);
            scrollView.requestDisallowInterceptTouchEvent(true);
        }

        pdfView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(MotionEvent.ACTION_DOWN == event.getAction()){
                    Log.d("터치", "onTouch: 다운 ");
                    scrollView.requestDisallowInterceptTouchEvent(true);
                }else{
                    Log.d("터치", "onTouch: 그외 ");
//                    scrollView.requestDisallowInterceptTouchEvent(true);

                }
                return true;
            }
        });
        detector = new GestureDetector(getContext(), new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                return false;
            }
        });
    }


    @Override
    public void loadComplete(int nbPages) {
        PdfDocument.Meta meta = pdfView.getDocumentMeta();
        pdfView.fitToWidth(nbPages);
        printBookmarksTree(pdfView.getTableOfContents(), "-");
    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        getActivity().setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pageCount));
    }

    public void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {
        for (PdfDocument.Bookmark b : tree) {

            Log.e("TAG", String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));

            if (b.hasChildren()) {
                printBookmarksTree(b.getChildren(), sep + "-");
            }
        }
    }
}