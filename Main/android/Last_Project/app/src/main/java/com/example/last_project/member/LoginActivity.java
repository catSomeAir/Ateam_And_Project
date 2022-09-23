package com.example.last_project.member;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.user.UserApiClient;
import com.navercorp.nid.NaverIdLoginSDK;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.oauth.view.NidOAuthLoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {
    //    private static OAuthLogin mOAuthLoginInstance;
//    private static Context mContext;
    NidOAuthLoginButton login_btn_naver;
    Button btn_login_local; //db접속 로그인 버튼
    //    EditText login_edt_id;
    LinearLayout ln_login, ln_login_guest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);


        //일반로그인 ------------------------------------------------------------------------
        ln_login = findViewById(R.id.ln_login);
        ln_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Login_in_Activity.class);
                startActivityForResult(intent, 0);
                overridePendingTransition(R.anim.slideing_left_enter, R.anim.hold);
            }
        });


        //소셜로그인---------------------------------------------------------------------------

        //네이버---------------------------------------------------------------------------
        login_btn_naver = findViewById(R.id.login_btn_naver);
        NaverIdLoginSDK.INSTANCE.initialize(this, getString(R.string.naver_client_id), getString(R.string.naver_client_secret), getString(R.string.app_name));
//        login_btn_naver.setImageResource(R.drawable.naver);
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
        //-------소셜로그인 카카오
        KakaoSdk.init(this, "6a8daeb1b5866edc7517304827ad84ae");

        findViewById(R.id.btn_kakao).setOnClickListener(v -> {

        });

        // lamda식 자바코드를 함수형으로 간편하게 줄여서 사용한것
        findViewById(R.id.btn_kakao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //(OAuthToken?, Throwable?) ->Unit
                Function2<OAuthToken, Throwable, Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
                    @Override
                    public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                        if (oAuthToken != null) {
                            Log.d("토큰", "invoke: 받아옴");
                            kakao_profile();

                        }
                        if (throwable != null) {
                            Log.d("토큰", "invoke: 오류있음");
                        }
                        return null;
                    }
                };


                // 카카오톡 앱 설치 여부를 판단. 깔려있으면 카톡 앱으로 인증.
                if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(LoginActivity.this)) {
                    UserApiClient.getInstance().loginWithKakaoTalk(LoginActivity.this, callback);
                } else {
                    UserApiClient.getInstance().loginWithKakaoAccount(LoginActivity.this, callback);
                }

                /*    // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
                if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {

                } else {
                    UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
                }*/
            }
        });

        getHashKey();

    }

    /*카카오로그인*/
    public void kakao_profile() {
        UserApiClient.getInstance().me((user, throwable) -> {
            if (throwable != null) {
                //오류가 났을때 어떤 오류인지 코드로 줌 KOE + 숫자 ( 단무지가 있음 )
            } else {
                Log.d("카카오", "kakao_profile: " + user.getKakaoAccount().getProfile().getNickname());
                Log.d("카카오", "kakao_profile: " + user.getKakaoAccount().getProfile().getThumbnailImageUrl());
                Log.d("카카오", "kakao_profile: " + user.getKakaoAccount().getEmail());
                Log.d("카카오", "kakao_profile: " + user.getKakaoAccount().getName());

            }


            return null;
        });
    }

    private void getHashKey() {
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            finish();
        }
    }
}