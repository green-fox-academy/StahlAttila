package com.greenfoxacademy.projectmovieapp.services;

import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Service
public class RetrofitServiceImpl implements RetrofitService{
    @Override
    public Retrofit buildRetrofit(String url, String type) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        if(type.toLowerCase().equals("gson")) {
            return new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client.build())
                    .build();
        }else if(type.toLowerCase().equals("string")) {
            return new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .client(client.build())
                    .build();
        }

        return null;
    }
}
