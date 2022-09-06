package com.example.last_project.member;

<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;
import com.navercorp.nid.NaverIdLoginSDK;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.oauth.view.NidOAuthLoginButton;

public class LoginActivity extends AppCompatActivity {
//    private static OAuthLogin mOAuthLoginInstance;
//    private static Context mContext;
    NidOAuthLoginButton login_btn_naver;
    Button btn_login_local; //db접속 로그인 버튼
//    EditText login_edt_id;
    LinearLayout ln_login;
=======
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

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
>>>>>>> 1a48d713eaf7e24bb931b82edd57d7eff58f0b4a
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);

<<<<<<< HEAD
//        login_edt_id = findViewById(R.id.login_edt_id);
        
/*        CommonConn conn = new CommonConn(LoginActivity.this, "test.dg");
=======
        login_edt_id = findViewById(R.id.login_edt_id);
        
        CommonConn conn = new CommonConn(LoginActivity.this, "test.dg");
>>>>>>> 1a48d713eaf7e24bb931b82edd57d7eff58f0b4a
        conn.addParams("email","kel102@gmail.com");
        conn.executeConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
<<<<<<< HEAD

            }
        });*/

        //일반로그인 ------------------------------------------------------------------------
        ln_login = findViewById(R.id.ln_login);
        ln_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Login_in_Activity.class);
                startActivityForResult(intent,0);
                overridePendingTransition(R.anim.slideing_left_enter, R.anim.hold);
            }
        });


=======
                Log.d("TAG", "onResult: "+ data);
                login_edt_id.setText(data);
            }
        });

>>>>>>> 1a48d713eaf7e24bb931b82edd57d7eff58f0b4a
        //소셜로그인---------------------------------------------------------------------------

            //네이버---------------------------------------------------------------------------
        login_btn_naver = findViewById(R.id.login_btn_naver);
        NaverIdLoginSDK.INSTANCE.initialize(this, getString(R.string.naver_client_id) , getString(R.string.naver_client_secret), getString(R.string.app_name));
<<<<<<< HEAD
//        login_btn_naver.setImageResource(R.drawable.naver);
=======
        login_btn_naver.setImageResource(R.drawable.naver);
>>>>>>> 1a48d713eaf7e24bb931b82edd57d7eff58f0b4a
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
<<<<<<< HEAD

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode ==1){
            finish();
        }
    }
=======
>>>>>>> 1a48d713eaf7e24bb931b82edd57d7eff58f0b4a
}