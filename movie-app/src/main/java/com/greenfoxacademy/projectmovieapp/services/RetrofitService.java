package com.greenfoxacademy.projectmovieapp.services;

import retrofit2.Retrofit;

public interface RetrofitService {

    Retrofit buildRetrofit(String url, String type);
}
