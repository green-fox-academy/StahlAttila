package com.greenfoxacademy.projectmovieapp.services;

import com.greenfoxacademy.projectmovieapp.domains.Movie;
import com.greenfoxacademy.projectmovieapp.domains.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MovieDTOService {

    void addMovieDTO(Movie movie);
    List<MovieDTO> movieList();

}
