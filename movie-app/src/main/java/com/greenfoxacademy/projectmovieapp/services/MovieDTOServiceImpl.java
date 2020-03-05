package com.greenfoxacademy.projectmovieapp.services;

import com.greenfoxacademy.projectmovieapp.domains.Movie;
import com.greenfoxacademy.projectmovieapp.domains.MovieDTO;
import com.greenfoxacademy.projectmovieapp.repositories.MovieDTORepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieDTOServiceImpl implements MovieDTOService {

    MovieDTORepository repository;

    @Autowired
    public MovieDTOServiceImpl(MovieDTORepository repository) {
        this.repository = repository;
    }


    @Override
    public void addMovieDTO(Movie movie) {
        repository.save(new MovieDTO(movie));
    }

    @Override
    public List<MovieDTO> movieList() {
        return (List<MovieDTO>) repository.findAll();
    }

    @Bean
    public ModelMapper modelMapper () {
        return new ModelMapper();
    }
}
