package com.example.last_project.conn;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://121.147.215.12:3302/pj/";
    private static Retrofit retrofit;
        //http://121.147.215.12:3302/pj/

    //8. Api클라이언트 : url , retrofit -> 앱연결
    public static Retrofit getApiclient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .client(new OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS).build())
                    .build();

        }
        return retrofit;
    }

    //공통코드로 BASE_URL 바꾸기        : 공공데이터의 endPoint에 해당, 생성할떄 파라메터로 넘겨서 사용
    public static Retrofit getApiclient(String base_url) {
       // if (retrofit == null) {

        Retrofit
            retrofitGet = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .client(new OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS).build())
                    .build();

//        }
        return retrofitGet;
    }
}
