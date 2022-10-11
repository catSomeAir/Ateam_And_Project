package com.example.last_project.model;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.CommonAlertActivity;
import com.example.last_project.R;
import com.example.last_project.common.CommonVal;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.model.detail.ManualFragment;
import com.example.last_project.model.detail.as.AfterServiceFragment;
import com.example.last_project.model.detail.manual.ManualVO;
import com.example.last_project.model.detail.writng.WritingFragment;
import com.example.last_project.search.NotFoundAlertActivity;
import com.example.last_project.search.category_search.CategorySearchVO;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ModelDetailActivity extends AppCompatActivity implements View.OnClickListener {

    //설명서다운로드
    String File_Name = "확장자를 포함한 파일명";
    String File_extend = "확장자명";

    String fileURL = "http://121.147.215.12:3302/pj/download_manual"; // URL
    String Save_Path;
    String Save_folder = "/my_manual";

    ProgressBar loadingBar;
    DownloadThread dThread;

    //--------------------------------------


    ImageView imgv_back;
    //    LinearLayout ln_model_detail_writing;
    TabLayout tabs;

    TextView tv_detail_cancel;
    CategorySearchVO model_info;
    ManualVO manual_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_model_detail);


        model_info = (CategorySearchVO) getIntent().getSerializableExtra("model_info");
        manual_info = (ManualVO) getIntent().getSerializableExtra("manual_info");

//
//        CommonConn conn = new CommonConn(ModelDetailActivity.this, "manual_info");
//        conn.addParams("model_code", model_info.getModel_code());
//        conn.executeConn_no_dialog(new CommonConn.ConnCallback() {
//            @Override
//            public void onResult(boolean isResult, String data) {
//                manualVO = new Gson().fromJson(data, ManualVO.class);
//                CommonVal.manualInfo = manualVO;
//                File_Name = manualVO.getFilename();
//                File_extend = manualVO.getFilename().substring(manualVO.getFilename().indexOf(".")+1);
//                fileURL = fileURL+"?filename="+manualVO.getFilename() + "&filepath="+manualVO.getFilepath().replace("http://","");
//            }
//        });

        File_Name = manual_info.getFilename();
        File_extend = manual_info.getFilename().substring(manual_info.getFilename().indexOf(".")+1);
        fileURL = fileURL+"?filename="+manual_info.getFilename() + "&filepath="+manual_info.getFilepath().replace("http://","");

        //검색리스트에서 클릭해서 넘어온 모델정보


        //제품설명서 다운로드
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());



        loadingBar = (ProgressBar) findViewById(R.id.Loading);  //로딩바

        // 다운로드 경로를 외장메모리 사용자 지정 폴더로 함.
        String ext = Environment.getExternalStorageState();
        if (ext.equals(Environment.MEDIA_MOUNTED)) {
            Save_Path = Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + Save_folder;
        }

        imgv_back = findViewById(R.id.imgv_back);

        imgv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("제품설명서").setTag(1));
        tabs.addTab(tabs.newTab().setText("상품의견").setTag(2));
        tabs.addTab(tabs.newTab().setText("A/S센터").setTag(3));
        tabs.getTabAt(0).select();


        //처음은 바로 설명서 Fragment띄우기
        getSupportFragmentManager().beginTransaction().replace(R.id.container_model_detail, new ManualFragment(ModelDetailActivity.this, model_info, manual_info)).commit();

        //탭레이아웃 선택 이벤트
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if (tab.getPosition() == 0) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_model_detail, new ManualFragment(ModelDetailActivity.this, model_info, manual_info)).commit();
                } else if (tab.getPosition() == 1) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_model_detail, new WritingFragment(model_info)).commit();
                } else if (tab.getPosition() == 2) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_model_detail, new AfterServiceFragment(model_info)).commit();

                    //* 수정해야함
//                        getSupportFragmentManager().beginTransaction().replace(R.id.container_model_detail, new UnrelatedASFragment()).commit();//* 임시로 AS센터 없는 경우 확인하기 위해 만들어둠

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        if (tabs.getSelectedTabPosition() == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container_model_detail, new ManualFragment(ModelDetailActivity.this, model_info, manual_info)).commit();
        } else if (tabs.getSelectedTabPosition() == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container_model_detail, new WritingFragment(model_info)).commit();
        } else if (tabs.getSelectedTabPosition() == 2) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container_model_detail, new AfterServiceFragment(model_info)).commit();

            //* 수정해야함
//                        getSupportFragmentManager().beginTransaction().replace(R.id.container_model_detail, new UnrelatedASFragment()).commit();//* 임시로 AS센터 없는 경우 확인하기 위해 만들어둠

        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imgv_manual_download) {

            if (CommonVal.userInfo != null) {
                //있는지 확인, 없으면 다운로드 있으면 있다고 말해주기
                CommonConn conn = new CommonConn(ModelDetailActivity.this, "download_manual_check");
                conn.addParams("email", CommonVal.userInfo.getEmail());
                conn.addParams("model_code", model_info.getModel_code());
                conn.executeConn(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {
                        if (isResult) {
                            if (data.equals("1")) {//다운로드한적 있으면
                                Intent intent = new Intent(ModelDetailActivity.this, CommonAlertActivity.class);
                                intent.putExtra("page", "ManualFragment_download_exist");
                                startActivityForResult(intent,0);
                            } else {//다운로드한적 없으면
                                Intent intent = new Intent(ModelDetailActivity.this, CommonAlertActivity.class);
                                intent.putExtra("page", "ManualFragment_download_not_exist");
                                startActivityForResult(intent,0);
                            }

                        }
                    }
                });
            } else {
                Intent intent = new Intent(ModelDetailActivity.this, NotFoundAlertActivity.class);   //이름은 다른데 같은기능이라 그냥씀 로그인여부물어봄
                intent.putExtra("intent_type", "write"); //글쓰기에서 띄운 alert
                startActivity(intent);
            }

        }

    }

    //다운로드 처리
    class DownloadThread extends Thread {
        String ServerUrl;
        String LocalPath;

        DownloadThread(String serverPath, String localPath) {
            ServerUrl = serverPath;
            LocalPath = localPath;
        }

        @Override
        public void run() {
            URL imgurl;
            int Read;
            try {
                imgurl = new URL(ServerUrl);
                HttpURLConnection conn = (HttpURLConnection) imgurl
                        .openConnection();
                int len = conn.getContentLength();
                byte[] tmpByte = new byte[len];
                InputStream is = conn.getInputStream();
                File file = new File(LocalPath);
                FileOutputStream fos = new FileOutputStream(file);
                for (; ; ) {
                    Read = is.read(tmpByte);
                    if (Read <= 0) {
                        break;
                    }
                    fos.write(tmpByte, 0, Read);
                }
                is.close();
                fos.close();
                conn.disconnect();

            } catch (MalformedURLException e) {
                Log.e("ERROR1", e.getMessage());
            } catch (IOException e) {
                Log.e("ERROR2", e.getMessage());
                e.printStackTrace();
            }
            mAfterDown.sendEmptyMessage(0);
        }
    }

    Handler mAfterDown = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            loadingBar.setVisibility(View.GONE);
            // 파일 다운로드 종료 후 다운받은 파일을 실행시킨다.
            showDownloadFile();
        }

    };

    private void showDownloadFile() {
        Intent intent = new Intent();
        intent.setAction(android.content.Intent.ACTION_VIEW);
        File file = new File(Save_Path + "/" + File_Name);

        // 파일 확장자 별로 mime type 지정해 준다.
        if (File_extend.equals("mp3")) {
            intent.setDataAndType(Uri.fromFile(file), "audio/*");
        } else if (File_extend.equals("mp4")) {
            intent.setDataAndType(Uri.fromFile(file), "vidio/*");
        } else if (File_extend.equals("jpg") || File_extend.equals("jpeg")
                || File_extend.equals("JPG") || File_extend.equals("gif")
                || File_extend.equals("png") || File_extend.equals("bmp")) {
            intent.setDataAndType(Uri.fromFile(file), "image/*");
        } else if (File_extend.equals("txt")) {
            intent.setDataAndType(Uri.fromFile(file), "text/*");
        } else if (File_extend.equals("doc") || File_extend.equals("docx")) {
            intent.setDataAndType(Uri.fromFile(file), "application/msword");
        } else if (File_extend.equals("xls") || File_extend.equals("xlsx")) {
            intent.setDataAndType(Uri.fromFile(file),
                    "application/vnd.ms-excel");
        } else if (File_extend.equals("ppt") || File_extend.equals("pptx")) {
            intent.setDataAndType(Uri.fromFile(file),
                    "application/vnd.ms-powerpoint");
        } else if (File_extend.equals("pdf")) {
//            intent.setDataAndType(Uri.fromFile(file), "application/pdf");
            intent.setAction(Intent.ACTION_VIEW).setData(Uri.parse(fileURL));
        }
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 2000) { //제품설명서 다운로드처리해야함

            //            String File_Name = "확장자를 포함한 파일명";
//            String File_extend = "확장자명";
//
//            String fileURL = "웹서버 쪽 파일이 있는 경로"; // URL
//            String Save_Path;
//            String Save_folder = "/mydown";

            File dir = new File(Save_Path);
            // 폴더가 존재하지 않을 경우 폴더를 만듦
            if (!dir.exists()) {
                dir.mkdir();
            }

            // 다운로드 폴더에 동일한 파일명이 존재하는지 확인해서
            // 없으면 다운받고 있으면 해당 파일 실행시킴.
            if (new File(Save_Path + "/" + File_Name).exists() == false) {
                loadingBar.setVisibility(View.VISIBLE);
                dThread = new DownloadThread(fileURL/* + "/" + File_Name*/,
                        Save_Path + "/" + File_Name);
                dThread.start();
            } else {
                showDownloadFile();
            }

        }
    }

    public void manual_Info(){
        //설명서 정보 filename, filepath, 도움준 수 가져오기
        CommonConn conn = new CommonConn(ModelDetailActivity.this, "manual_info");
        conn.addParams("model_code", model_info.getModel_code());
        conn.executeConn_no_dialog(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                manual_info = new Gson().fromJson(data, ManualVO.class);
                CommonVal.manualInfo = manual_info;
                File_Name = manual_info.getFilename();
                File_extend = manual_info.getFilename().substring(manual_info.getFilename().indexOf(".")+1);
                fileURL = fileURL+"?filename="+manual_info.getFilename() + "&filepath="+manual_info.getFilepath().replace("http://","");
            }
        });
    }
}