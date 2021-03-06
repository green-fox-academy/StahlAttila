package com.greenfoxacademy.projectmovieapp.controllers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.projectmovieapp.domains.*;
import com.greenfoxacademy.projectmovieapp.services.*;
import com.greenfoxacademy.projectmovieapp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import java.io.IOException;
import java.util.List;


@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final String apikey = System.getenv("API_KEY");

    MovieDTOService service;
    AuthenticationManager authenticationManager;
    MyUserDetailsService userDetailsService;
    JwtUtil jwtTokenUtil;
    UserService userService;
    RetrofitService retrofitService;


    @Autowired
    public RestController(RetrofitService retrofitService, MovieDTOService service, UserService userService, AuthenticationManager authenticationManager, MyUserDetailsService userDetailsService, JwtUtil jwtTokenUtil) {
        this.service = service;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
        this.retrofitService = retrofitService;
    }

    @GetMapping("/genre/list")
    public ResponseEntity<?> getGenres() {
        Retrofit retrofit = retrofitService.buildRetrofit("https://api.themoviedb.org/", "string");
        MovieDBApiService movieDBApiService = retrofit.create(MovieDBApiService.class);
        final Call<String> call = movieDBApiService.getGenres(apikey);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try{
            Response<String> response = call.execute();
            String genres = response.body();
            GenresVO genreList = mapper.readValue(genres, GenresVO.class);
            return ResponseEntity.ok(genreList);
        } catch (IOException ignored) {
            return ResponseEntity.badRequest().body(null);
        }
    }


    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id)  {

        Retrofit retrofit = retrofitService.buildRetrofit("https://api.themoviedb.org/", "gson");
        MovieDBApiService movieDBApiService = retrofit.create(MovieDBApiService.class);

        final Call<Movie> call = movieDBApiService.getMovie(id, apikey);

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
    public ResponseEntity<List<MovieDTO>> getTheSavedMovieDatas() {
       List<MovieDTO> movieList = service.movieList();

        return ResponseEntity.ok().body(movieList);
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthentication(/*HttpServletRequest response, @RequestParam String username, @RequestParam String password*/@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        User user = userService.findByName(authenticationRequest.getUsername());
        if(user == null) {
            return ResponseEntity.badRequest().body("User does not exist!");
        }else if(!user.getPassword().equals(authenticationRequest.getPassword())) {
            return ResponseEntity.badRequest().body("Password does not match!");
        }

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

        /*HttpHeaders headers = new HttpHeaders();
        headers.set("SET-COOKIE", "Bearer "+ jwt);
        headers.setLocation(URI.create("list"));*/

        return ResponseEntity.ok().body(new AuthenticationResponse(jwt));
        /*return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);*/
    }


}
