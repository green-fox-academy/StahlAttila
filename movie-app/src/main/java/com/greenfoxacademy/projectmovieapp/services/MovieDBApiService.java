package com.greenfoxacademy.projectmovieapp.services;

import com.greenfoxacademy.projectmovieapp.domains.Movie;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Service
public interface MovieDBApiService {

    @GET("3/movie/{movie_id}")
    Call<Movie> getMovie(@Path("movie_id") Long id, @Query("api_key") String apiKey);


}
