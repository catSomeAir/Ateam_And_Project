package com.example.last_project.map;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {
    private static final String baseUrl = "https://dapi.kakao.com";
    private static NetworkManager instance = null;
    private Retrofit retrofit;

    // 생성자 private(외부에서 접근하지 못하게)
    private NetworkManager(){
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    //한번만 객체생성
    public static NetworkManager getInstance(){
        if(instance == null){
            instance = new NetworkManager();
        }
        return instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }


}
