package com.nare.narelloworld;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Odoroki on 2015-10-08.
 */
public class MainActivity extends AppCompatActivity {

    CustomService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetrofit();

        service.test("test1", "안녕").enqueue(new Callback<CustomData>() {
            @Override
            public void onResponse(Response<CustomData> response, Retrofit retrofit) {
                Toast.makeText(getApplicationContext(), response.body().hello, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    void setRetrofit(){

        Retrofit ret = new Retrofit.Builder()
                .baseUrl("http://192.168.43.135:3141")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = ret.create(CustomService.class);
    }
}
