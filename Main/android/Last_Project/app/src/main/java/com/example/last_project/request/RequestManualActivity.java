package com.example.last_project.request;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestManualActivity extends AppCompatActivity {

    //이미지 파일경로 list
    ArrayList<String> paths = new ArrayList<>();

    //분류 선택시 스피너
    Spinner spinner;
    String select_category;
    String[] items = {"제품 분류를 선택하세요", "가전/tv", "컴퓨터 / 노트북", "태블릿 / 모바일", "자동차용품 / 공구", "가구 / 조명", "아동 / 유아", "사무", "취미 / 레저", "기타"};

    //취소버튼   , 보내기 버튼
    Button btn_request_cancel, btn_request_send;

    //뒤로가기
    ImageView imgv_request_back;


    //Edittext
    EditText edt_request_title, edt_request_content;
    //내용레이아웃
    LinearLayout ln_request_content;
    //내용 byte수
    TextView tv_request_content_byte;

    //사진첨부
    LinearLayout ln_request_picture, ln_request_picture2, ln_request_picture3;
    AlertDialog dialog;
    ImageView imgv_request_picture, imgv_request_picture2, imgv_request_picture3, imgv_request_remove, imgv_request_remove2, imgv_request_remove3;
    int ln_page = 0;
    double chk_index1, chk_index2, chk_index3 = 0;
    double total_size = 0;
    //파일용량
    TextView tv_request_img_size;
    DecimalFormat format = new DecimalFormat("#,###,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_manual);
        checkDangerousPermissions();

        //제목
        edt_request_title = findViewById(R.id.edt_request_title);


        //첨부파일용량
        tv_request_img_size = findViewById(R.id.tv_request_img_size);

        //사진첨부이미지
        imgv_request_picture = findViewById(R.id.imgv_request_picture);
        imgv_request_picture2 = findViewById(R.id.imgv_request_picture2);
        imgv_request_picture3 = findViewById(R.id.imgv_request_picture3);

        imgv_request_remove = findViewById(R.id.imgv_request_remove);
        imgv_request_remove2 = findViewById(R.id.imgv_request_remove2);
        imgv_request_remove3 = findViewById(R.id.imgv_request_remove3);

        //사진첨부버튼(레이아웃)
        ln_request_picture = findViewById(R.id.ln_request_picture);
        ln_request_picture2 = findViewById(R.id.ln_request_picture2);
        ln_request_picture3 = findViewById(R.id.ln_request_picture3);

        ln_request_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ln_page = 1;
                showDialog();

            }
        });
        ln_request_picture2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ln_page = 2;
                showDialog();

            }
        });
        ln_request_picture3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ln_page = 3;
                showDialog();

            }
        });
        imgv_request_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imgv_request_remove3.getVisibility() == View.VISIBLE && imgv_request_remove2.getVisibility() == View.VISIBLE) { // 2, 3, 다 차있는경우면
                    copy_picture((BitmapDrawable) imgv_request_picture2.getDrawable(), imgv_request_picture);  //2이미지를 1로 ,
                    copy_picture((BitmapDrawable) imgv_request_picture3.getDrawable(), imgv_request_picture2);  //3이미지를 2로 ,
                    imgv_request_remove3.setVisibility(View.INVISIBLE);
                   // imgv_request_picture3.setImageResource(R.drawable.icon_plus);

                    total_size -= chk_index1;
                    tv_request_img_size.setText(format.format(total_size / 1024 / 1024) + "");
//                    tv_request_img_size.setText(format.format(Double.parseDouble(tv_request_img_size.getText().toString()) - chk_index1)+"");
                    chk_index1 = chk_index2;
                    chk_index2 = chk_index3;
                    chk_index3 = 0;

                } else if (imgv_request_remove3.getVisibility() == View.INVISIBLE && imgv_request_remove2.getVisibility() == View.VISIBLE) {// 1, 2만 차있는경우면
                    copy_picture((BitmapDrawable) imgv_request_picture2.getDrawable(), imgv_request_picture);  //2이미지를 1로
                    imgv_request_picture.setTag(imgv_request_picture2.getTag());

                    ln_request_picture3.setVisibility(View.INVISIBLE);  //3레이아웃 안보이게
                    imgv_request_remove2.setVisibility(View.INVISIBLE);
                    imgv_request_picture2.setImageResource(R.drawable.icon_plus);

                    total_size -= chk_index1;
                    tv_request_img_size.setText(format.format(total_size / 1024 / 1024) + "");

                    chk_index1 = chk_index2;
                    chk_index2 = 0;
//                    tv_request_img_size.setText(format.format(Double.parseDouble(tv_request_img_size.getText().toString()) - chk_index2)+"");

                } else if (imgv_request_remove3.getVisibility() == View.INVISIBLE && imgv_request_remove2.getVisibility() == View.INVISIBLE) { //1만 채워진 경우
                    ln_request_picture2.setVisibility(View.INVISIBLE);  //3레이아웃 안보이게
                    imgv_request_remove.setVisibility(View.INVISIBLE);
                    imgv_request_picture.setImageResource(R.drawable.icon_plus);

                    total_size = 0;
                    tv_request_img_size.setText("0.00");
                    chk_index1 = 0;
                }
                //첫번째 이미지 지우면 패스지움
                paths.remove(0);
            }
        });

        imgv_request_remove2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imgv_request_remove3.getVisibility() == View.VISIBLE) { //1,2,3이 차있는경우면

                    copy_picture((BitmapDrawable) imgv_request_picture3.getDrawable(), imgv_request_picture2);  //3이미지를 2로 ,
                    imgv_request_picture2.setTag(imgv_request_picture3.getTag());
                    imgv_request_remove3.setVisibility(View.INVISIBLE);
                    imgv_request_picture3.setImageResource(R.drawable.icon_plus);

                    total_size -= chk_index2;
                    tv_request_img_size.setText(format.format(total_size / 1024 / 1024) + "");
                    chk_index2 = chk_index3;
                    chk_index3 = 0;


                } else if (imgv_request_remove3.getVisibility() == View.INVISIBLE) {// 1,2만 차있는경우면

                    ln_request_picture3.setVisibility(View.INVISIBLE);  //3레이아웃 안보이게
                    imgv_request_remove2.setVisibility(View.INVISIBLE);
                    imgv_request_picture2.setImageResource(R.drawable.icon_plus);

                    total_size -= chk_index2;
                    tv_request_img_size.setText(format.format(total_size / 1024 / 1024) + "");
                    chk_index2 = 0;
                }

                //두번째이미지지우면 paths에서 지움
                paths.remove(1);
//                tv_request_img_size.setText(format.format(Double.parseDouble(tv_request_img_size.getText().toString()) - chk_index2)+"");
            }
        });

        imgv_request_remove3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgv_request_remove3.setVisibility(View.INVISIBLE);
                imgv_request_picture3.setImageResource(R.drawable.icon_plus);
                total_size -= chk_index3;
                tv_request_img_size.setText(format.format(total_size / 1024 / 1024) + "");
                paths.remove(2);

//                tv_request_img_size.setText(format.format(Double.parseDouble(tv_request_img_size.getText().toString()) - chk_index3)+"");
            }
        });

        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                select_category = spinner.getSelectedItem().toString();
                Log.d("스피너", "onCreate: " + select_category);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //뒤로가기 버튼
        imgv_request_back = findViewById(R.id.imgv_request_back);
        imgv_request_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RequestManualActivity.this, RequestCancelActivity.class);
                startActivityForResult(intent, 0);
                overridePendingTransition(0, 0);

            }
        });

        //취소버튼
        btn_request_cancel = findViewById(R.id.btn_request_cancel);
        btn_request_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RequestManualActivity.this, RequestCancelActivity.class);
                startActivityForResult(intent, 0);
                overridePendingTransition(0, 0);
            }
        });

        //보내기버튼 : DB에 해당 내용 보내야함.
        btn_request_send = findViewById(R.id.btn_request_send);
        btn_request_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (empty_alert()) {
                    Intent intent = new Intent(RequestManualActivity.this, RequestResultActivity.class);
                    startActivity(intent);
                    finish();

                }
            }
        });

        //내용레이아웃 선택시 Edittext에 포커싱
        ln_request_content = findViewById(R.id.ln_request_content);
        edt_request_content = findViewById(R.id.edt_request_content);
        ln_request_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_request_content.requestFocus();
            }
        });

        //byte수 표시 Text
        tv_request_content_byte = findViewById(R.id.tv_request_content_byte);

        edt_request_content.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                tv_request_content_byte.setText(s.toString().getBytes().length + "");

            }
        });
    }

    //이미지 용량구하는 매소드
    public void bitmap_size(String img_path) {
//        Glide.with(RequestManualActivity.this)
//                .asBitmap()
//                .load(img_path)
//                .into(new SimpleTarget<Bitmap>() {
//                    @Override
//                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
//                        int byteCount = Integer.MIN_VALUE;
//                        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
//                            byteCount = resource.getByteCount();
//                        } else {
//                            byteCount = resource.getAllocationByteCount();
//                        }
//                        double sizeInKB = byteCount / 1024;
//                        double sizeInMB = sizeInKB / 1024;
//                        DecimalFormat format = new DecimalFormat("#,###,###.00");
//
////                        tv_request_img_size.setText(Double.parseDouble(String.valueOf(format.format( Double.parseDouble(tv_request_img_size.getText().toString())  +  sizeInMB /25.3)))+"");
//                    }
//                });
        if (ln_page == 1) {
            chk_index1 = new File(img_path).length();
            total_size += chk_index1;
        } else if (ln_page == 2) {
            chk_index2 = new File(img_path).length();
            total_size += chk_index2;
        } else if (ln_page == 3) {
            chk_index3 = new File(img_path).length();
            total_size += chk_index3;
        }

        tv_request_img_size.setText(format.format(total_size / 1024 / 1024) + "");
    }

    //gif 는 오류남
    //이미지 교체 -> drawble : 복사할 이미지의 getDrawable, 붙여넣기할 imageview
    public void copy_picture(BitmapDrawable drawable, ImageView image) {
//            BitmapDrawable drawable = (BitmapDrawable) imageView1.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        image.setImageBitmap(bmp);
    }

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
        if (resultCode ==3){
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
            if (ln_page == 1) {
                Glide.with(RequestManualActivity.this).load(img_path).into(imgv_request_picture);
                paths.add(img_path);
                imgv_request_remove.setVisibility(View.VISIBLE);
                ln_request_picture2.setVisibility(View.VISIBLE);

            } else if (ln_page == 2) {
                Glide.with(RequestManualActivity.this).load(img_path).into(imgv_request_picture2);
                paths.add(img_path);
                imgv_request_remove2.setVisibility(View.VISIBLE);
                ln_request_picture3.setVisibility(View.VISIBLE);
            } else if (ln_page == 3) {
                Glide.with(RequestManualActivity.this).load(img_path).into(imgv_request_picture3);
                paths.add(img_path);
                imgv_request_remove3.setVisibility(View.VISIBLE);
            }
            //넣은 이미지 용량 표시하기
            bitmap_size(img_path);

//            //Multipart 형태로 전송 ~ File ~ : 파일 받는형태 RequestBody , create( 타입, content타입(실제경로) )
//            //1. RequestBody
//            RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), new File(img_path));
//
//            //2. MultipartBody.Part
//            MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.jpg", fileBody);
//            //3. ApiInterface에 sendFile() 추가
//            //4. ApiInterface
//            ApiInterface apiInterface = ApiClient.getApiclient().create(ApiInterface.class);
//            apiInterface.sendFile(filePart).enqueue(new Callback<String>() {
//                @Override
//                public void onResponse(Call<String> call, Response<String> response) {
//
//                }
//
//                @Override
//                public void onFailure(Call<String> call, Throwable t) {
//
//                }
//            });
        } else if (requestCode == CAMERA_CODE && resultCode == RESULT_OK) {

            if (ln_page == 1) {
                Glide.with(RequestManualActivity.this).load(imgFilePath).into(imgv_request_picture);
                paths.add(0,imgFilePath);
                imgv_request_remove.setVisibility(View.VISIBLE);
                ln_request_picture2.setVisibility(View.VISIBLE);

            } else if (ln_page == 2) {
                Glide.with(RequestManualActivity.this).load(imgFilePath).into(imgv_request_picture2);
                paths.add(1,imgFilePath);
                imgv_request_remove2.setVisibility(View.VISIBLE);
                ln_request_picture3.setVisibility(View.VISIBLE);
            } else if (ln_page == 3) {  //파일경로 배열에담기
                Glide.with(RequestManualActivity.this).load(imgFilePath).into(imgv_request_picture3);
                paths.add(2,imgFilePath);
                imgv_request_remove3.setVisibility(View.VISIBLE);
            }
            bitmap_size(imgFilePath);
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

    //권한레벨 - 낮음 : 인터넷 - 사용하겠다고 메니페스트에 명시만 하면 OK
    //권한레벨 - 중간 : 유튜브 - 사용하겠다고 메니페스트에 명시 후 queries 로 재 명시 해줘야함.
    //권한레벨 - 높음 : 위치 -   카메라, 갤러리( 파일저장소 ) / 사용하겠다고 메니페스트에 명시 후 쿼리스로도 명시 후 사용자 동의.

    //권한요청 메소드
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            imgv_request_back.performClick();
            return true;
        }
        return false;
    }

    //입력 안된사항 알려주기

    public boolean empty_alert() {
        Intent intent = new Intent(RequestManualActivity.this, RequestEmptyActivity.class);

        if (select_category == "제품 분류를 선택하세요") {
            intent.putExtra("text", "제품 분류가 선택되지 않았습니다");
            startActivity(intent);
            return false;
        } else if (edt_request_title.getText().toString().length() == 0) {
            intent.putExtra("text", "제목이 입력되지 않았습니다");
            startActivity(intent);
            return false;
        } else if (edt_request_content.getText().toString().length() == 0) {
            intent.putExtra("text", "내용이 입력되지 않았습니다");
            startActivity(intent);
            return false;
        } else {
            MemberVO userinfo = CommonVal.userInfo;
            RequestManualVO vo = new RequestManualVO(userinfo.getEmail(), edt_request_title.getText().toString(), edt_request_content.getText().toString(), select_category);
//하나 보내는경우
//            RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), new File(imgFilePath)); //MediaType은 무슨타입인지 지정, 스트링형태의 파일패스
//            MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.jpg", fileBody);//첫번째 데이터는 이름, 두번째는 실제 파일이름, 세번째는 만들어진 파일바디
//
            RequestBody dataTest =
                    RequestBody.create(
                            MediaType.parse("multipart/form-data"), new Gson().toJson(vo));


            ApiInterface apiInterface = ApiClient.getApiclient().create(ApiInterface.class);

            //* 수정중

            List<MultipartBody.Part> fileList = new ArrayList<>();

            //이미지 파일경로 paths에 담기
          /*  if(imgv_request_remove.getVisibility()==View.VISIBLE ){
                paths.add(imgv_request_picture.getTag().toString());
            }
            if(imgv_request_remove2.getVisibility()==View.VISIBLE ){
                paths.add(imgv_request_picture2.getTag().toString());
            }
            if(imgv_request_remove3.getVisibility()==View.VISIBLE ){
                paths.add(imgv_request_picture3.getTag().toString());
            }*/

            //List<MultipartBody.Part> fileList paths에 저장된 경로의 파일 담기
            for (int i = 0; i < paths.size(); i++) {
                RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg") , new File(paths.get(i)) );
                fileList.add(MultipartBody.Part.createFormData("file"+i , "test" + i +".jpg" , fileBody) );
            }

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
            }).start();


//            CommonConn conn = new CommonConn(RequestManualActivity.this, "request_manual");
//
//
//            conn.addParams("data", new Gson().toJson(vo));
//            conn.executeConn(new CommonConn.ConnCallback() {
//                @Override
//                public void onResult(boolean isResult, String data) {
//                    if (isResult) {
//                        //* 여기서 성공, 실패 확인해서 페이지 처리해야할듯
//                    }
//                }
//            });
        }
        return true;
    }

}