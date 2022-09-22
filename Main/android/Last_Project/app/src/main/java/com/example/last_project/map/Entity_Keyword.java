package com.example.last_project.map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
//@메소드방식("baseURL을 제외한 나머지")로 만들수 있습니다.
//@Header = 유저 인증 토큰이 필요할 때 사용됩니다.
//@Query = 문자열을 기반으로 웹 서버에 요청할 때 사용됩니다.
//@Path = 특정 자리에 원하는 변수를 넣고싶을 때 사용됩니다.(@Path에 있는 변수는 {board_id}로 들어갑니다!)
//@Body = 서버에 데이터를 보낼 때 주로 사용됩니다. @Body에 데이터를 담아 서버에 전달합니다.


public interface Entity_Keyword {
    @GET("v2/local/search/keyword.json")
    Call<KeyWord> searchKeyword(
            @Header("Authorization")String token,   //Authorization 대부분 Header 로 전해줍니다.
            @Query("query")String query            //우리가 찾고자 하는 키워드
//            @Query("x")String y,                    //y좌표(왜 반대인지는 모르겠음..)
//            @Query("y")String x,                    //x좌표
//            @Query("radius")int radius              //범위(중심좌표로 부터)
    );

//    @GET("api/boards/{board_id}/comments")
//    Call<List<CommentData>> getComments(
//            @Header("Authorization") String token,
//            @Path("board_id") int id
//    );


}
