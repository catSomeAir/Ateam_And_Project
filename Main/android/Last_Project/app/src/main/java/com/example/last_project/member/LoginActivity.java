package com.example.last_project.member;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.last_project.R;
import com.example.last_project.conn.CommonConn;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.example.last_project.category.CategoryActivity;
import com.example.last_project.member.join.JoinActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.user.UserApiClient;
import com.navercorp.nid.NaverIdLoginSDK;
import com.navercorp.nid.oauth.NidOAuthLogin;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.oauth.view.NidOAuthLoginButton;
import com.navercorp.nid.profile.NidProfileCallback;
import com.navercorp.nid.profile.data.NidProfileResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {

    NidOAuthLoginButton login_btn_naver;
    Button btn_login_local; //db접속 로그인 버튼
    //    EditText login_edt_id;
    LinearLayout ln_login, ln_login_google, ln_login_guest;
    TextView login_btn_join;
    //구글 로그인을 위한 전역변수
    private SignInButton btn_google; //구글 로그인 버튼
    private final int RC_SIGN_IN = 1000;
    GoogleSignInClient mGoogleSignInClient;

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
                Log.d("네이버", "onSuccess: " + NaverIdLoginSDK.INSTANCE.getAccessToken());
                naver_profile();
            }

            @Override
            public void onFailure(int i, @NonNull String s) {
                Log.d("네이버", "onFailure: " + s);

            }

            @Override
            public void onError(int i, @NonNull String s) {
                Log.d("네이버", "onError: " + s);
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
            }
        });

        getHashKey();

        // google
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        SignInButton signInButton = findViewById(R.id.btn_google);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

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

    /*네이버 로그인*/

    //setOAuthLoginCallback 을 이용을 해서 success가 되었을때 (token이있을때) 정보를 받아올수있는 객체를
    //사용해서 정보를 얻어오면된다.
    public void naver_profile(){
        //NidOAuthLogin().callProfileApi(nidProfileCallback) Kotiln
        NidOAuthLogin authLogin = new NidOAuthLogin();
        authLogin.callProfileApi(new NidProfileCallback<NidProfileResponse>() {
            @Override
            public void onSuccess(NidProfileResponse res) {
                Log.d("프로필", "onSuccess: ");
                Log.d("프로필", "onSuccess: " + res.getProfile().getEmail());
                Log.d("프로필", "onSuccess: " + res.getProfile().getMobile());
                Log.d("프로필", "onSuccess: " + res.getProfile().getName());
                CommonConn conn = new CommonConn(LoginActivity.this,"socialinfo.me");
                conn.addParams("email",res.getProfile().getEmail());
                conn.addParams("social","N");
                conn.executeConn(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {
                        Log.d("Result", "onResult: "+ isResult);
                    }
                });

            }
            @Override
            public void onFailure(int i, String s) {
                Log.d("프로필", "onFailure: " + s);
            }

            @Override
            public void onError(int i, @NonNull String s) {
                Log.d("프로필", "onError: "  + s);
            }
        });
        finish();
    }

    /*카카오로그인*/
    public void kakao_profile() {
        UserApiClient.getInstance().me((user, throwable) -> {
            if (throwable != null) {
                //오류가 났을때 어떤 오류인지 코드로 줌 KOE + 숫자 ( 단무지가 있음 )
                /*Intent kakaofailintent = new Intent(getApplicationContext(), JoinActivity.class);
                kakaofailintent.putExtra("present_email",user.getKakaoAccount().getEmail());
                startActivity(kakaofailintent);*/
            } else {
                Log.d("카카오", "kakao_profile: " + user.getKakaoAccount().getProfile().getNickname());
                Log.d("카카오", "kakao_profile: " + user.getKakaoAccount().getProfile().getThumbnailImageUrl());
                Log.d("카카오", "kakao_profile: " + user.getKakaoAccount().getEmail());
                Log.d("카카오", "kakao_profile: " + user.getKakaoAccount().getName());
                CommonConn conn = new CommonConn(LoginActivity.this,"socialinfo.me");
                conn.addParams("email",user.getKakaoAccount().getEmail());
                conn.addParams("social","K");
                conn.executeConn(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {
                        Log.d("Result", "onResult: "+ isResult);
                    }
                });

            }
            //카카오로그인 성공시 메인 액티비티로
            finish();
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

   /* 구글 로그인*/
   @Override
   public void onActivityResult(int requestCode, int resultCode, Intent data) {
       super.onActivityResult(requestCode, resultCode, data);

       // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
       if (requestCode == RC_SIGN_IN) {
           // The Task returned from this call is always completed, no need to attach
           // a listener.
           Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
           try {
               task.getResult(ApiException.class);
               GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
               if (acct != null) {
                   String personName = acct.getDisplayName();
                   String personGivenName = acct.getGivenName();
                   String personFamilyName = acct.getFamilyName();
                   String personEmail = acct.getEmail();
                   String personId = acct.getId();
                   Uri personPhoto = acct.getPhotoUrl();
                   /*구글 로그인 정보 DB에 저장*/
                   CommonConn conn = new CommonConn(LoginActivity.this,"socialinfo.me");
                   conn.addParams("email",acct.getEmail());
                   conn.addParams("social","G");
                   conn.executeConn(new CommonConn.ConnCallback() {
                       @Override
                       public void onResult(boolean isResult, String data) {
                           Log.d("Result", "onResult: "+ isResult);
                       }
                   });
                   finish();
               }
           } catch (ApiException e) {
               e.printStackTrace();
           }
           //handleSignInResult(task);

       }
        if (resultCode == 1) {
            finish();
        }
   }


}

