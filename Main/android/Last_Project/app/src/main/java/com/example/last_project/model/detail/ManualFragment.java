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
import android.widget.Toast;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.last_project.CommonAlertActivity;
import com.example.last_project.R;
import com.example.last_project.WebviewActivity;
import com.example.last_project.common.CommonVal;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.search.category_search.CategorySearchVO;
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
    String pdfFileName;


    LinearLayout ln_model_detail_writing, ln_model_detail_as;
    ImageView imgv_manual_zzim, imgv_manual_link, imgv_manual_download; //* 다운로드 버튼 구현예정

    //제품정보
    ImageView imgv_manual_photo;
    TextView tv_manual_brand, tv_manual_model_name, tv_manual_model_code, tv_manual_catg;


    ImageView imgv_manual_help; //따봉버튼
    TextView tv_manual_help; //따봉버튼
    LinearLayout ln_manual_help; //따봉버튼
    TextView tv_manual_help_cnt;    //도움수


    TextView tv_manual_name;
    boolean  help_chk;
    boolean  zzim = true;
    NestedScrollView scrollView;

    //DB에서넘어온 모델정보
    CategorySearchVO model_info;

    //디비에서 조회한 찜하기 상태
    String help = "";

    public ManualFragment() {
    }

    public ManualFragment(Context context, CategorySearchVO model_info) {
        this.context = context;
        this.model_info = model_info;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_manual, container, false);

        //다운로드 버튼
//        imgv_manual_download = v.findViewById(R.id.imgv_manual_download);
//        imgv_manual_download.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(CommonVal.userInfo != null){
//                    //있는지 확인, 없으면 다운로드 있으면 있다고 말해주기
//                    CommonConn conn = new CommonConn(getContext(), "download_manual_check");
//                    conn.addParams("email", CommonVal.userInfo.getEmail());
//                    conn.addParams("model_code", model_info.getModel_code());
//                    conn.executeConn(new CommonConn.ConnCallback() {
//                        @Override
//                        public void onResult(boolean isResult, String data) {
//                            if(isResult){
//                                if(data.equals("1")) {//다운로드한적 있으면
//                                    Intent intent = new Intent(getContext(), CommonAlertActivity.class);
//                                    intent.putExtra("page", "ManualFragment_download_exist");
//                                    startActivity(intent);
//                                }else{//다운로드한적 없으면
//                                    Intent intent = new Intent(getContext(), CommonAlertActivity.class);
//                                    intent.putExtra("page", "ManualFragment_download_not_exist");
//                                    startActivity(intent);
//                                }
//
//                            }
//                        }
//                    });
//                }else{
//                    Intent intent = new Intent(getContext(), NotFoundAlertActivity.class);   //이름은 다른데 같은기능이라 그냥씀 로그인여부물어봄
//                    intent.putExtra("intent_type", "write"); //글쓰기에서 띄운 alert
//                    startActivity(intent);
//                }
//
//            }
//        });

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
                if (help_chk) {   //선택된 상황에서 클릭
                    imgv_manual_help.setImageResource(R.drawable.icon_thumbs);
                    tv_manual_help.setText("도움이\n되었나요?");
                    tv_manual_help.setTextColor(Color.parseColor("#4D4d4D"));
                    ln_manual_help.setBackgroundResource(R.drawable.shape_navy_border8);
                    tv_manual_help_cnt.setText(Integer.parseInt(tv_manual_help_cnt.getText().toString()) - 1 + "");
                    help_chk = false;
                } else { //선택안했을 시 클릭
                    imgv_manual_help.setImageResource(R.drawable.icon_thumbs_fill_white);
                    tv_manual_help.setText("도움이\n되었어요!");
                    tv_manual_help.setTextColor(Color.parseColor("#e9e9e9"));
                    ln_manual_help.setBackgroundResource(R.drawable.shape_navy_fill);
                    tv_manual_help_cnt.setText(Integer.parseInt(tv_manual_help_cnt.getText().toString()) + 1 + "");
                    help_chk = true;
                }
            }
        });

        pdfView = (PDFView) v.findViewById(R.id.pdfView);
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

        //디비에서 내이메일이랑, 메뉴얼코드 조회해서 n인지 y인지 판단.
        if (CommonVal.userInfo != null) {
            CommonConn conn = new CommonConn(getContext(), "my_manual_select");
            conn.addParams("email", CommonVal.userInfo.getEmail());
            conn.addParams("model_code", model_info.getModel_code());
            conn.executeConn_no_dialog(new CommonConn.ConnCallback() {
                @Override
                public void onResult(boolean isResult, String data) {
                    if(data.equals("1")){
                        imgv_manual_zzim.setImageResource(R.drawable.icon_heart_fill);
                        zzim = true;
                    }else{
                        imgv_manual_zzim.setImageResource(R.drawable.icon_heart);
                        zzim = false;
                    }

                }
            });

        }


        imgv_manual_zzim = v.findViewById(R.id.imgv_manual_zzim);
        imgv_manual_zzim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (zzim) {
                    imgv_manual_zzim.setImageResource(R.drawable.icon_heart);
                    zzim = false;
                    if (CommonVal.userInfo != null) {
                        my_manual_delete();
                        Toast.makeText(getContext(), "나의 설명서 목록에서 삭제 되었습니다", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(getContext(), CommonAlertActivity.class);
                        intent.putExtra("page", "manual_zzim");
                        startActivity(intent);
                    }

                } else {//찜이 안되어있을 때 찜하기 누르면
                    imgv_manual_zzim.setImageResource(R.drawable.icon_heart_fill);
                    zzim = true;
                    if (CommonVal.userInfo != null) {
                        my_manual_insert();
                        Toast.makeText(getContext(), "나의 설명서에 추가되었습니다", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(getContext(), CommonAlertActivity.class);
                        intent.putExtra("page", "manual_zzim");
                        startActivity(intent);
                    }

                    //* DB에 찜하기 선택되도록 해야함
                }
            }
        });

        //받아온 제품정보 넣어주기
        imgv_manual_photo = v.findViewById(R.id.imgv_manual_photo);
        tv_manual_brand = v.findViewById(R.id.tv_manual_brand);
        tv_manual_model_name = v.findViewById(R.id.tv_manual_model_name);
        tv_manual_model_code = v.findViewById(R.id.tv_manual_model_code);
        tv_manual_catg = v.findViewById(R.id.tv_manual_catg);

        Glide.with(getContext()).load(model_info.getFilepath().replace("localhost", "121.147.215.12:3302").replace("192.168.0.33","121.147.215.12:3302")).into(imgv_manual_photo);
        tv_manual_brand.setText(model_info.getBrand_name());
        tv_manual_model_name.setText(model_info.getModel_name() + " (" + model_info.getModel_code() + ")");
        tv_manual_model_code.setText(model_info.getModel_code());
        tv_manual_catg.setText(model_info.getCategory_name());

        //링크 해당 제품으로 검색하기
        imgv_manual_link = v.findViewById(R.id.imgv_manual_link);
        String search_keyword = model_info.getBrand_name() + model_info.getModel_name();
        imgv_manual_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebviewActivity.class);
                intent.putExtra("url", "https://www.google.com/search?q=" + search_keyword + "&oq=" + search_keyword);
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

        if (pdfView.isSwipeEnabled()) {
            pdfView.setSwipeEnabled(true);
            scrollView.requestDisallowInterceptTouchEvent(true);
        }

//        pdfView.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                if(MotionEvent.ACTION_DOWN == event.getAction()){
//                    Log.d("터치", "onTouch: 다운 ");
//                    scrollView.requestDisallowInterceptTouchEvent(true);
//                }else{
//                    Log.d("터치", "onTouch: 그외 ");
////                    scrollView.requestDisallowInterceptTouchEvent(true);
//
//                }
//                return true;
//            }
//        });
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

    @Override
    public void onResume() {
        super.onResume();
        if (CommonVal.userInfo != null) {
            CommonConn conn = new CommonConn(getContext(), "my_manual_select");
            conn.addParams("email", CommonVal.userInfo.getEmail());
            conn.addParams("model_code", model_info.getModel_code());
            conn.executeConn_no_dialog(new CommonConn.ConnCallback() {
                @Override
                public void onResult(boolean isResult, String data) {
                    help = data;

                }
            });

            if (help.equals("n")) {
                imgv_manual_zzim.setImageResource(R.drawable.icon_heart);
            } else if (help.equals("y")) {
                imgv_manual_zzim.setImageResource(R.drawable.icon_heart_fill);
            }

        }
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    public void my_manual_insert(){
        if (CommonVal.userInfo != null) {
            CommonConn conn = new CommonConn(getContext(), "my_manual_insert");
            conn.addParams("email", CommonVal.userInfo.getEmail());
            conn.addParams("model_code", model_info.getModel_code());
            conn.executeConn_no_dialog(new CommonConn.ConnCallback() {

                @Override
                public void onResult(boolean isResult, String data) {

                }
            });
        }
    }

    public void my_manual_delete(){
        if (CommonVal.userInfo != null) {
            CommonConn conn = new CommonConn(getContext(), "my_manual_delete");
            conn.addParams("email", CommonVal.userInfo.getEmail());
            conn.addParams("model_code", model_info.getModel_code());
            conn.executeConn_no_dialog(new CommonConn.ConnCallback() {

                @Override
                public void onResult(boolean isResult, String data) {

                }
            });
        }
    }


}