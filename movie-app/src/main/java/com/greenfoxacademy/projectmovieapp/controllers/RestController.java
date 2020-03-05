package com.greenfoxacademy.projectmovieapp.controllers;

import com.greenfoxacademy.projectmovieapp.domains.AuthenticationRequest;
import com.greenfoxacademy.projectmovieapp.domains.Movie;
import com.greenfoxacademy.projectmovieapp.domains.MovieDTO;
import com.greenfoxacademy.projectmovieapp.domains.User;
import com.greenfoxacademy.projectmovieapp.services.MovieDBApiService;
import com.greenfoxacademy.projectmovieapp.services.MovieDTOService;
import com.greenfoxacademy.projectmovieapp.services.MyUserDetailsService;
import com.greenfoxacademy.projectmovieapp.services.UserService;
import com.greenfoxacademy.projectmovieapp.util.JwtUtil;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;
import java.net.URI;
import java.util.List;


@org.springframework.web.bind.annotation.RestController
public class RestController {

    MovieDTOService service;
    AuthenticationManager authenticationManager;
    MyUserDetailsService userDetailsService;
    JwtUtil jwtTokenUtil;
    UserService userService;


    @Autowired
    public RestController(MovieDTOService service, UserService userService, AuthenticationManager authenticationManager, MyUserDetailsService userDetailsService, JwtUtil jwtTokenUtil) {
        this.service = service;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }


    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) throws IOException {
        OkHttpClient.Builder client = new OkHttpClient.Builder();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();

        MovieDBApiService movieDBApiService = retrofit.create(MovieDBApiService.class);

        final Call<Movie> call = movieDBApiService.getMovie(id, "5b39c4360c305b2a28c128e7c85b780c");

        try{
            Response<Movie> response = call.execute();
            Movie movie = response.body();
            service.addMovieDTO(movie);
            return ResponseEntity.ok(movie);
        } catch (IOException ignored) {
            return ResponseEntity.badRequest().body(null);
        }

    }

    @GetMapping("/list")
    public ResponseEntity<List<MovieDTO>> getTheSavedMovieDatas(Model model) {
       List<MovieDTO> movieList = service.movieList();

        return ResponseEntity.ok().body(movieList);
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthentication(@RequestParam String username, @RequestParam String password) throws Exception {
        User user = userService.findByName(username);
        if(user == null) {
            return ResponseEntity.badRequest().body("User does not exist!");
        }else if(!user.getPassword().equals(password)) {
            return ResponseEntity.badRequest().body("Password does not match!");
        }

        AuthenticationRequest authenticationRequest = new AuthenticationRequest(username, password);

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        HttpHeaders headers = new HttpHeaders();
        headers.set("SET-COOKIE", "Bearer "+ jwt);
        headers.setLocation(URI.create("list"));

        /*return ResponseEntity.ok().headers(headers).body(new AuthenticationResponse(jwt));*/
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }


}
