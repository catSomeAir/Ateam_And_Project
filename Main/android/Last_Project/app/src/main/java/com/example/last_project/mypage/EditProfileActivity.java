package com.example.last_project.mypage;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import com.bumptech.glide.Glide;
import com.example.last_project.R;
import com.example.last_project.common.CommonVal;
import com.example.last_project.conn.ApiClient;
import com.example.last_project.conn.ApiInterface;
import com.example.last_project.member.MemberVO;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfileActivity extends AppCompatActivity {
    EditText edt_name, edt_nickname, edt_pw, edt_email, edt_phone;
    Button btn_save;
    ImageView imgv_back, imgv_category_profile;
    AlertDialog dialog;
    String send_path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        //권한받기
        checkDangerousPermissions();


        edt_name = findViewById(R.id.edt_name);
        edt_nickname = findViewById(R.id.edt_nickname);
//        edt_pw=findViewById(R.id.edt_pw);
        /*edt_email=findViewById(R.id.edt_email);*/
        edt_phone = findViewById(R.id.edt_phone);
        btn_save = findViewById(R.id.btn_save);
        imgv_back = findViewById(R.id.imgv_back);
        imgv_category_profile = findViewById(R.id.imgv_category_profile);
        imgv_category_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
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
            Glide.with(EditProfileActivity.this).load(vo.getFilepath().replace("192.168.0.33", "121.147.215.12:3302")).into(imgv_category_profile);
        }

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MemberVO vo = new MemberVO();
                vo.setEmail(CommonVal.userInfo.getEmail());
                vo.setName(edt_name.getText().toString());
                vo.setNickname(edt_nickname.getText().toString());
                vo.setPhone(edt_phone.getText().toString());

//
                RequestBody dataTest =
                        RequestBody.create(
                                MediaType.parse("multipart/form-data"), new Gson().toJson(vo));
                try {

                    RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), new File(send_path)); //MediaType은 무슨타입인지 지정, 스트링형태의 파일패스
                    MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.jpg", fileBody);//첫번째 데이터는 이름, 두번째는 실제 파일이름, 세번째는 만들어진 파일바디

                    ApiInterface apiInterface = ApiClient.getApiclient().create(ApiInterface.class);
                    apiInterface.sendOneFile_VO(dataTest, filePart).enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {

                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                } catch (Exception e) {

                }


                            Toast.makeText(getApplicationContext(), "정보가 업데이트 되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });


        imgv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }//onCreate();

    //사진첨부 ----------
    String[] dialog_item = {"카메라", "갤러리"};
    public final int LOAD_IMG = 1000; //이미지 구별상수 -> startActivityForResult 라는 메소드가 인텐트가 실행되면 intent종료되고 돌아올때 결과 얻어올 수 있음.
    //모든 결과는 하나의 메소드인 onActivityResult라는 메소드에서 처리해야함
    //어떤 작업이 끝났는지에 따라서 코드분기를 해줘야함.
    public final int CAMERA_CODE = 1001;

    public boolean showDialog() {

        //다이얼로그 생성 : Builder이용
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //사용자에게 보이는 글씨 setTitle : 리턴타입이 빌터라 .찍고 만들면됨,
        builder.setTitle(" 선택하세요 ")
                .setSingleChoiceItems(dialog_item, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        if (dialog_item[i].equals("카메라")) {
                            Log.d("카메라", "다이얼로그: " + i);
                            Intent pickIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            //임시파일 만들기 : 프로바이더로 임시파일을 채워서 가져오게 만들기
                            //일단 이 인텐트가 사용가능한지 체크
                            if (pickIntent.resolveActivity(getPackageManager()) != null) { //intent가 가능하다면~ 이라는 뜻
                                //임시파일만들기 : 메소드생성해놈 createFile()
                                File file = createFile();
                                if (file != null) {
                                    //API 24부터는 프로바이더를 통해서 사진을 캡쳐한걸 가져와야함 ( 임시파일 )
                                    Uri imgUri = FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName() + ".fileprovider", file);         //getUriForFile( 어플컨텍스트, 인증(패키지네임.fileprovider), file)
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {     //API 24이상인경우
                                        pickIntent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);
                                    } else {
                                        pickIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                                    }
                                }
                                startActivityForResult(pickIntent, CAMERA_CODE);

                            }
                        } else {    //갤러리클릭시
                            Log.d("갤러리", "다이얼로그: " + i);
                            Intent intent = new Intent();   //생성자에 어떤 작업을 할건지 액션을 지정해도됨 , setter
                            intent.setType("image/");   //이미지 전체폴더에
                            intent.setAction(Intent.ACTION_PICK);
//                            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);       //한번에 여러파일 첨부할 경우 true주면된다.
                            startActivityForResult(Intent.createChooser(intent, "Select Picture"), LOAD_IMG);   //, GELLARY_CODE 멀티로 하는 경우 LOAD_IMG대신에

                        }

                    }

                });
        dialog = builder.create();
        dialog.show();

        return true;

    }//showDialog()

    public String imgFilePath;  //이미지 임시파일경로

    //임 시 파 일  리 턴 메 소 드
    private File createFile() {
        //1. 파일이름 동적으로 만들기
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "Pj03My" + timeStamp;

        //2. 사진파일을 저장하기 위한 경로
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        //3. 임시파일만들기
        File rtnFile = null;
        try {
            rtnFile = File.createTempFile(fileName, ".jpg", storageDir);  //createTempFile(이름, 확장자, 경로)
        } catch (IOException e) {
            e.printStackTrace();
        }

        imgFilePath = rtnFile.getAbsolutePath();    //임시파일경로의 절대경로

        return rtnFile;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 3) {
            finish();

        }
        if (resultCode == 1) {
            finish();
            return;
        } else if (resultCode == 2) {
            return;
        }


        //돌아오니까 여기서 다이얼로그종료 : 전역변수로 빼서
        dialog.dismiss();
        // requestCode : 보내준코드 1000번이 기본값임 -> 어디있다 왔는지 구분용도
        if (requestCode == LOAD_IMG && resultCode == RESULT_OK) {// 안드에서 성공은 -1
            //Intent Data 형태로 주는 경로는 사실 사진파일 실제경로가 아니라
            Log.d("갤러리", "onActivityResult: " + data.getData());
            Log.d("갤러리", "onActivityResult: " + data.getData().getPath());
            String img_path = getRealPath(data.getData());      //Uri 가상 : data.getData()

            Glide.with(EditProfileActivity.this).load(img_path).into(imgv_category_profile);
            send_path = img_path;

        } else if (requestCode == CAMERA_CODE && resultCode == RESULT_OK) {


            Glide.with(EditProfileActivity.this).load(imgFilePath).into(imgv_category_profile);
            send_path = imgFilePath;

        }
    }

    public String getRealPath(Uri contentUri) {  //가상 URI : Cursor 하나씩 뒤져서 가지고옴
        String res = null;
        //저장소 전체이미지 배열형태로 가지고옴
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);   //쭉 검색해서 가지고옴 /contentUri를 proj에서 검색
        if (cursor.moveToFirst()) {   //각 데이터 데이터 첫번째값으로 이동이 된다면? 있다면
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);   //해당 인덱스값을 뺴온다.

        }
        cursor.close(); //커서 닫아줌
        return res;
    }


    private void checkDangerousPermissions() {
        String[] permissions = {
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_MEDIA_LOCATION,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {  //사용자 거절 ->못쓰게 막힘
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Toast.makeText(this, "권한 설명 필요함.", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);

            }
        }
    }


    // 위의 메소드 결과 받아오는메소드
    // 권한요청 받아오는 결과 메소드 : onRequestPermissionsResult() 여기로 돌아옴
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {  //해당인덱스 permission
                    Log.d("TAG", "권한 승인 됨: " + permissions[i]);
                } else {
                    Log.d("TAG", "권한 승인 안됨: " + permissions[i]);
                }
            }
        }
    }


}