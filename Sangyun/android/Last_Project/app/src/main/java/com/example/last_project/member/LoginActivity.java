package com.example.last_project.member;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.last_project.R;
import com.example.last_project.conn.CommonConn;
import com.navercorp.nid.NaverIdLoginSDK;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.oauth.view.NidOAuthLoginButton;
import com.nhn.android.naverlogin.OAuthLogin;

public class LoginActivity extends AppCompatActivity {
    private static OAuthLogin mOAuthLoginInstance;
    private static Context mContext;
    NidOAuthLoginButton login_btn_naver;
    EditText login_edt_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);

        login_edt_id = findViewById(R.id.login_edt_id);
        
        CommonConn conn = new CommonConn(LoginActivity.this, "test.dg");
        conn.addParams("email","k");
        conn.executeConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                Log.d("TAG", "onResult: "+ data);
                login_edt_id.setText(data);
            }
        });

        //소셜로그인---------------------------------------------------------------------------

            //네이버---------------------------------------------------------------------------
        login_btn_naver = findViewById(R.id.login_btn_naver);
        NaverIdLoginSDK.INSTANCE.initialize(this, getString(R.string.naver_client_id) , getString(R.string.naver_client_secret), getString(R.string.app_name));
        login_btn_naver.setImageResource(R.drawable.temp_banner);
        login_btn_naver.setOAuthLoginCallback(new OAuthLoginCallback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onFailure(int i, @NonNull String s) {

            }

            @Override
            public void onError(int i, @NonNull String s) {

            }
        });



        //-------------------------------------------------------------------------------------
    }
}