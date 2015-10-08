package com.nare.narelloworld;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Odoroki on 2015-10-08.
 */
public interface CustomService {
    @FormUrlEncoded
    @POST("/test")
    Call<CustomData> test(@Field("asdf") String id, @Field("pw") String pw);
}
