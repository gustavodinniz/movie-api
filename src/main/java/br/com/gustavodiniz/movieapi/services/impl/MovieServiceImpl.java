package br.com.gustavodiniz.movieapi.services.impl;

import br.com.gustavodiniz.movieapi.models.MovieModel;
import br.com.gustavodiniz.movieapi.repositories.MovieRepository;
import br.com.gustavodiniz.movieapi.services.MovieService;
import br.com.gustavodiniz.movieapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Page<MovieModel> findAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @Override
    public MovieModel findById(Long id) {
        Optional<MovieModel> movieModel = movieRepository.findById(id);
        return movieModel.orElseThrow(() -> new ObjectNotFoundException("Movie not found."));
    }
}
