package com.example.last_project.model.detail.as;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;

import com.example.last_project.R;
import com.example.last_project.WebviewActivity;
import com.example.last_project.map.Documents;
import com.example.last_project.map.KeywordRepository;
import com.example.last_project.map.RetrofitOnSuccess;

import net.daum.mf.map.api.CameraPosition;
import net.daum.mf.map.api.CameraUpdateFactory;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.util.List;

public class AfterServiceActivity extends AppCompatActivity  implements MapView.MapViewEventListener,
        MapView.POIItemEventListener, MapView.OpenAPIKeyAuthenticationResultListener, RetrofitOnSuccess, MapView.CurrentLocationEventListener {
    LinearLayout ln_as_call, ln_as_homepage;
    TextView tv_as_call, tv_as_homepage, tv_as_category, tv_as_detail_adress;
    NestedScrollView scrollView;

    ImageView imgv_as_back;//뒤로각

    //맵
    ViewGroup mapViewContainer;
    MapView mapView;
    String x = "", y = "";
    MapPoint mapPoint;
    Documents data ;
    private static final String LOG_TAG = "AfterServiceActivity.this";
    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
    private static final int PERMISSIONS_REQUEST_CODE = 100;
    String[] REQUIRED_PERMISSIONS  = {Manifest.permission.ACCESS_FINE_LOCATION};

    //AS센터정보
    TextView tv_as_name;
    private KeywordRepository keywordRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_service);


        data = (Documents) getIntent().getSerializableExtra("data");


        scrollView = findViewById(R.id.scrollView);

        //AS센터정보
        //센터이름
        tv_as_name = findViewById(R.id.tv_as_name);
        tv_as_name.setText(data.getPlace_name());

        tv_as_category = findViewById(R.id.tv_as_category);
        tv_as_category.setText(data.getCategory_name());

        tv_as_detail_adress = findViewById(R.id.tv_as_detail_adress);
        tv_as_detail_adress.setText(data.getRoad_address_name());








        //뒤로가기
        imgv_as_back = findViewById(R.id.imgv_as_back);
        imgv_as_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //전화 아이콘
        ln_as_call  = findViewById(R.id.ln_as_call);

        //전화번호 담당 tv
        tv_as_call = findViewById(R.id.tv_as_call);
        tv_as_call.setText(data.getPhone());
        ln_as_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/"+tv_as_call.getText()));
                startActivity(intent);
            }
        });

        //홈페이지 주소
        tv_as_homepage = findViewById(R.id.tv_as_homepage);
        tv_as_homepage.setText(data.getPlace_url());
        //홈페이지 아이콘
        ln_as_homepage = findViewById(R.id.ln_as_homepage);
        ln_as_homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AfterServiceActivity.this, WebviewActivity.class);
                intent.putExtra("url", tv_as_homepage.getText() );
                startActivity(intent);
            }
        });

        //
        keywordRepository = new KeywordRepository();
        keywordRepository.retrieveData(AfterServiceActivity.this, tv_as_name.getText().toString()); //* 이부분은 intent받은걸로 수정해야함

        //맵
        mapView = new MapView(this);
        mapView.setMapViewEventListener(this);
        mapViewContainer = (ViewGroup) findViewById(R.id.map_view);

        mapViewContainer.addView(mapView);

//현재위치로 이동하게하기
//        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);
//        if (!checkLocationServicesStatus()) {
//            showDialogForLocationServiceSetting();
//        }else {
//            checkRunTimePermission();
//        }

    }



    //MapView 사용가능 상태여부 확인시켜줌
    @Override
    public void onMapViewInitialized(MapView mapView) {

    }

    //지도 중심 좌표가 이동한 경우 호출된다.
    @Override
    public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapPoint) {
       //     mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(Double.parseDouble(x), Double.parseDouble(y)), true);
        scrollView.requestDisallowInterceptTouchEvent(true);
    }

    //지도 확대/축소 레벨이 변경된 경우 호출된다.
    @Override
    public void onMapViewZoomLevelChanged(MapView mapView, int i) {
        scrollView.requestDisallowInterceptTouchEvent(true);
    }

    //사용자가 지도 위를 터치한 경우 호출된다.
    @Override
    public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {
        scrollView.requestDisallowInterceptTouchEvent(true);
    }

    //사용자가 지도 위 한 지점을 더블 터치한 경우 호출된다.
    @Override
    public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {
        scrollView.requestDisallowInterceptTouchEvent(true);
    }

    //사용자가 지도 위 한 지점을 길게 누른 경우(long press) 호출된다.
    @Override
    public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {
        scrollView.requestDisallowInterceptTouchEvent(true);
    }

    //사용자가 지도 드래그를 끝낸 경우 호출된다.
    @Override
    public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {
        scrollView.requestDisallowInterceptTouchEvent(true);
    }

    //    지도의 이동이 완료된 경우 호출된다.
    @Override
    public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {
        scrollView.requestDisallowInterceptTouchEvent(true);
    }

    @Override
    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {
        scrollView.requestDisallowInterceptTouchEvent(true);
    }



    public void kakao_callback() {
//        curl -v -X GET "https://dapi.kakao.com/v2/local/search/address.json" \
//        -H "Authorization: KakaoAK ${REST_API_KEY}" \
//        --data-urlencode "query=전북 삼성동 100"
    }

    public void retrieveOnSuccess(List<Documents> data) {
//        scrollView.requestDisallowInterceptTouchEvent(true);
        int getListSize = data.size();
        if(data.size() != 0){
            y = data.get(0).getX();
            x = data.get(0).getY();

            mapView.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(MapPoint.mapPointWithGeoCoord(Double.parseDouble(x), Double.parseDouble(y)), 2)));
            MapPOIItem marker = new MapPOIItem();//마커
            mapPoint = MapPoint.mapPointWithGeoCoord(Double.parseDouble(x), Double.parseDouble(y));

            marker.setItemName(tv_as_name.getText().toString()); //* 이부분은 intent받은걸로 수정해야함
            marker.setTag(0);
            marker.setMapPoint(mapPoint);
            marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
            marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
            mapView.addPOIItem(marker);
            if (!checkLocationServicesStatus()) {
                showDialogForLocationServiceSetting();
            }else {
                checkRunTimePermission();
            }
        }
    }


    //단말 사용자가 POI Item을 선택한 경우 호출된다.
    //사용자가 MapView 에 등록된 POI Item 아이콘(마커)를 터치한 경우 호출된다.
    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {
        scrollView.requestDisallowInterceptTouchEvent(true);
    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {
        scrollView.requestDisallowInterceptTouchEvent(true);
    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {
        scrollView.requestDisallowInterceptTouchEvent(true);
    }

    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {
        scrollView.requestDisallowInterceptTouchEvent(true);
    }

    // KEY값을 인증 서버에 요청하여 인증 여부를 통보받을 수 있다.
    //APP KEY 는 Android Application Package Name당 하나씩 카카오 개발자 APP KEY 발급 페이지 를 통해서 발급할 수 있다.
    @Override
    public void onDaumMapOpenAPIKeyAuthenticationResult(MapView mapView, int i, String s) {
        scrollView.requestDisallowInterceptTouchEvent(true);
    }

    @Override
    public void onSuccess() {
        scrollView.requestDisallowInterceptTouchEvent(true);
    }

    //현재위치-----------------------------------
    @Override
    public void onCurrentLocationUpdate(MapView mapView, MapPoint mapPoint, float v) {
//        MapPoint.GeoCoordinate mapPointGeo = mapPoint.getMapPointGeoCoord();
    }

    @Override
    public void onCurrentLocationDeviceHeadingUpdate(MapView mapView, float v) {

    }

    @Override
    public void onCurrentLocationUpdateFailed(MapView mapView) {

    }

    @Override
    public void onCurrentLocationUpdateCancelled(MapView mapView) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapViewContainer.removeAllViews();
    }

    void checkRunTimePermission(){

        //런타임 퍼미션 처리
        // 1. 위치 퍼미션을 가지고 있는지 체크합니다.
        int hasFineLocationPermission = ContextCompat.checkSelfPermission(AfterServiceActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION);

        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED ) {
            // 2. 이미 퍼미션을 가지고 있다면
            // ( 안드로이드 6.0 이하 버전은 런타임 퍼미션이 필요없기 때문에 이미 허용된 걸로 인식합니다.)
            // 3.  위치 값을 가져올 수 있음

        } else {  //2. 퍼미션 요청을 허용한 적이 없다면 퍼미션 요청이 필요합니다. 2가지 경우(3-1, 4-1)가 있습니다.
            // 3-1. 사용자가 퍼미션 거부를 한 적이 있는 경우에는
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])) {
                // 3-2. 요청을 진행하기 전에 사용자가에게 퍼미션이 필요한 이유를 설명해줄 필요가 있습니다.
                Toast.makeText(AfterServiceActivity.this, "이 앱을 실행하려면 위치 접근 권한이 필요합니다.", Toast.LENGTH_LONG).show();
                // 3-3. 사용자게에 퍼미션 요청을 합니다. 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE);
            } else {
                // 4-1. 사용자가 퍼미션 거부를 한 적이 없는 경우에는 퍼미션 요청을 바로 합니다.
                // 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE);
            }
        }
    }


    //여기부터는 GPS 활성화를 위한 메소드들
    private void showDialogForLocationServiceSetting() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("위치 서비스 비활성화");
        builder.setMessage("앱을 사용하기 위해서는 위치 서비스가 필요합니다.\n"
                + "위치 설정을 수정하시겠습니까?");
        builder.setCancelable(true);
        builder.setPositiveButton("설정", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Intent callGPSSettingIntent
                        = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivityForResult(callGPSSettingIntent, GPS_ENABLE_REQUEST_CODE);
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }


    public boolean checkLocationServicesStatus() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }


}