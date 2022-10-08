package com.example.last_project.mypage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.last_project.R;
import com.example.last_project.common.CommonVal;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.member.MemberVO;
import com.google.gson.Gson;

public class EditProfileActivity extends AppCompatActivity {
    EditText edt_name, edt_nickname, edt_pw, edt_email, edt_phone;
    Button btn_save;
    ImageView imgv_back, imgv_category_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        edt_name = findViewById(R.id.edt_name);
        edt_nickname = findViewById(R.id.edt_nickname);
//        edt_pw=findViewById(R.id.edt_pw);
        /*edt_email=findViewById(R.id.edt_email);*/
        edt_phone = findViewById(R.id.edt_phone);
        btn_save = findViewById(R.id.btn_save);
        imgv_back = findViewById(R.id.imgv_back);
        imgv_category_profile = findViewById(R.id.imgv_category_profile);
        /*edittext에 있는 글자*/

        /* DB연동해서 정보 업데이트*/
        //정보를 입력하지 않으면 입력해달라고 해야하나?
        MemberVO vo = CommonVal.userInfo;
        if (vo.getName() != null) {
            edt_name.setText(vo.getName());
        }
        if (vo.getNickname() != null) {
            edt_nickname.setText(vo.getNickname());
        }
        if (vo.getPhone() != null) {
            edt_phone.setText(vo.getPhone());
        }
        if (vo.getFilepath() != null) {
            Glide.with(EditProfileActivity.this).load(vo.getFilepath().replace("192.168.0.33","121.147.215.12:3302")).into(imgv_category_profile);
        }

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(EditProfileActivity.this, CommonAlertActivity.class);
//                intent.putExtra("page", "EditProfileActivity_save");
//                startActivityForResult(intent,0);
//                overridePendingTransition(0,0);


                CommonConn conn = new CommonConn(EditProfileActivity.this, "update.me");
                vo.setEmail(CommonVal.userInfo.getEmail());
                vo.setPw(edt_pw.getText().toString());
                vo.setName(edt_name.getText().toString());
                vo.setNickname(edt_nickname.getText().toString());
                vo.setPhone(edt_phone.getText().toString());
                conn.addParams("vo", new Gson().toJson(vo));
                conn.executeConn(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {
                        if (isResult) {
                            Toast.makeText(getApplicationContext(), "정보가 업데이트 되었습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

/*        RequestBody dataTest =
                RequestBody.create(
                        MediaType.parse("profile-edit"), new Gson().toJson(vo));

        ApiInterface apiInterface = ApiClient.getApiclient().create(ApiInterface.class);
        RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg") , new File(paths.get(i)) );
        fileList.add(MultipartBody.Part.createFormData("file"+i , "test" + i +".jpg" , fileBody) );

        new Thread(new Runnable() {
            @Override
            public void run() {
                apiInterface.sendFile_VO(dataTest, fileList).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        paths.clear();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });

//                    paths = new ArrayList<>();
            }
        }).start();*/


        imgv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}