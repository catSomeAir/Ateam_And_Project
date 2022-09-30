package com.example.last_project.member;

import android.annotation.SuppressLint;
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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;
import com.example.last_project.category.CategoryActivity;
import com.example.last_project.member.join.JoinActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
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

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    //    private static OAuthLogin mOAuthLoginInstance;
    //    private static Context mContext;
    NidOAuthLoginButton login_btn_naver;
    Button btn_login_local; //db접속 로그인 버튼
    //    EditText login_edt_id;
    LinearLayout ln_login, ln_login_google, ln_login_guest;
    TextView login_btn_join;
    //구글 로그인을 위한 전역변수
    private SignInButton btn_google; //구글 로그인 버튼
    private FirebaseAuth auth;      //파이어 베이스 인증 객체
    private GoogleApiClient googleApiClient;    //구글 API 클라이언트객체
    private static final int REQ_SIGN_GOOGLE = 1; //구글 로그인 결과 코드

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) { //앱이 실행될 때 처음 수행되는 곳
        super.onCreate(savedInstanceState);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);
        //회원가입(HAI)--------------------------------------------------------------------
        login_btn_join = findViewById(R.id.login_btn_join);
        login_btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(LoginActivity.this, JoinActivity.class);
                startActivityForResult(new Intent(LoginActivity.this, JoinActivity.class),100);

            }
        });



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

        /*구글 로그인*/
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();
        auth = FirebaseAuth.getInstance(); //파이어베이스 인증 객체 초기화
        ln_login_google = findViewById(R.id.ln_login_google);
        btn_google = findViewById(R.id.btn_google);
        btn_google.setBackgroundResource(R.drawable.google);
        ln_login_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //구글 로그인 버튼 위 레이아웃으로 버튼 만듦/ 본래 버튼 안눌림
            }
        });
        btn_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent, REQ_SIGN_GOOGLE);
            }
        });

    }/* oncreate */

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

    /*카카오 로그인*/
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


    //구글 로그인
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //구글 로그인 인증을 요청 했을 떄 결과 값을 되돌려 받는 곳
        if (resultCode == REQ_SIGN_GOOGLE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                GoogleSignInAccount account = result.getSignInAccount();//account 라는 데이터는 구글 로그인 정보를 담고 있음 (닉네임,프로필Url,이메일주소)
                resultLogin(account); //로그인 결과 값 출력 수행하라는 메소드
            }
        }
        if (resultCode == 1) {
            finish();
        }

    }

    private void resultLogin(GoogleSignInAccount account) { //구글 로그인 실제 성공했냐 안했냐
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) { //로그인 성공했으면
                            Toast.makeText(LoginActivity.this, "로그인성공", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), CategoryActivity.class); //로그인 했을 때 카테고리 액티비티로 넘어가게
                            intent.putExtra("nickname", account.getDisplayName());
                            intent.putExtra("photoUrl", String.valueOf(account.getPhotoUrl()));
                        } else {//로그인 실패시
                            Toast.makeText(LoginActivity.this, "로그인실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}