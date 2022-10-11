package com.example.last_project.conn;

import java.util.HashMap;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiInterface {

    @FormUrlEncoded
    @POST
    Call<String> getData(@Url String url, @FieldMap HashMap<String,Object> parameters);

    //현재 상태에서는 재사용 가능한게 POST방식만 만들어 두어서 URL에 파라메터 노출이 없는 형태 : 보안은 좋음..

    //하지만 공공데이터 포털이나 공공의 목적으로 만들어진 API들은 GET방식이 많음. ( URL에 파라메터 노출이 있음 보안은 낮음)

    @GET("{url}")    //GET방식은 BASE_URL + URL맵핑 + ?뒤에 오는 파라메터
    Call<String> getDataGET(@Path("url") String url, @QueryMap HashMap<String, String> parameters);       //여기서 넘긴 Path내의 값이 @GET 의 {url}로 들어간다.



    //파일전송!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @POST("file.f")//1. 멀티파트 어노테이션
    @Multipart      //2. Part어노테이션 파라메터  MultipartBody.Par  -> fileMap에 접속되고 추가 (파라메터)
    Call<String> sendFile(@Part MultipartBody.Part file);


    //VO + file파일하나
    @POST("edit_profile")//1. 멀티파트 어노테이션
    @Multipart      //2. Part어노테이션 파라메터  MultipartBody.Par  -> fileMap에 접속되고 추가 (파라메터)
    Call<String> sendOneFile_VO(@Part("vo") RequestBody data ,@Part MultipartBody.Part file);

    //VO + files 동시에 보내기
    @POST("request_manual")
    @Multipart
    Call<String> sendFile_VO(@Part("vo") RequestBody data , @Part List<MultipartBody.Part> files); //@FieldMap 접속 되고 추가  파일만 보낼때
//    Call<String> sendFile_VO(@Part("vo") RequestBody data , @Part List<MultipartBody.Part> files); //@FieldMap 접속 되고 추가  파일만 보낼때
}
