package com.example.last_project.map;

import android.util.Log;

import com.example.last_project.model.detail.as.AfterServiceActivity;
import com.example.last_project.model.detail.as.AfterServiceFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KeywordRepository {
    private Entity_Keyword entityKeyword;



    /* 생성자를 통해 레트로핏 객체를 가져옴 */
    public KeywordRepository() {
        entityKeyword = NetworkManager.getInstance().getRetrofit().create(Entity_Keyword.class);
    }

    public void retrieveData(AfterServiceActivity afterServiceActivity, String query){
        //YOUR_RSET_API_KEY 에 REST_API_KEY를 넣어줘야함.
//        Call<KeyWord> call = entityKeyword.searchKeyword("KakaoAK dccdece8a7b5479950d3f5acd3f341d3","한울 직업전문","126.93173","36.76995",1500);
        Call<KeyWord> call = entityKeyword.searchKeyword("KakaoAK 6a6881f134438240beffb0327de49a9e", query);
        call.enqueue(new Callback<KeyWord>() {
            @Override
            public void onResponse(Call<KeyWord> call, Response<KeyWord> response) {
                if(response.isSuccessful()){
                    Log.d( "Success","데이터 받아오기 성공");
                    afterServiceActivity.retrieveOnSuccess(response.body().getDocuments());
                }
                else{
                    Log.e( "Fail","서버 통신 실패");
                }
            }

            @Override
            public void onFailure(Call<KeyWord> call, Throwable t) {
                Log.e( "Fail","서버 통신 실패");
            }
        });
    }

    public void retrieveData_fragment(AfterServiceFragment activity, String query){
        //YOUR_RSET_API_KEY 에 REST_API_KEY를 넣어줘야함.
//        Call<KeyWord> call = entityKeyword.searchKeyword("KakaoAK dccdece8a7b5479950d3f5acd3f341d3","한울 직업전문","126.93173","36.76995",1500);
        Call<KeyWord> call = entityKeyword.searchKeyword("KakaoAK 6a6881f134438240beffb0327de49a9e", query);
        call.enqueue(new Callback<KeyWord>() {
            @Override
            public void onResponse(Call<KeyWord> call, Response<KeyWord> response) {
                if(response.isSuccessful()){
                    Log.d( "Success","데이터 받아오기 성공");
                    activity.retrieveOnSuccess(response.body().getDocuments());
                }
                else{
                    Log.e( "Fail","서버 통신 실패");
                }
            }

            @Override
            public void onFailure(Call<KeyWord> call, Throwable t) {
                Log.e( "Fail","서버 통신 실패");
            }
        });
    }

}
