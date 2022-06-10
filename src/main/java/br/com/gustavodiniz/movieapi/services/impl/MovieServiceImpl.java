package br.com.gustavodiniz.movieapi.services.impl;

import br.com.gustavodiniz.movieapi.dtos.MovieDTO;
import br.com.gustavodiniz.movieapi.models.MovieModel;
import br.com.gustavodiniz.movieapi.repositories.MovieRepository;
import br.com.gustavodiniz.movieapi.services.MovieService;
import br.com.gustavodiniz.movieapi.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<MovieModel> findAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @Override
    public MovieModel findById(Long id) {
        Optional<MovieModel> movieModel = movieRepository.findById(id);
        return movieModel.orElseThrow(() -> new ObjectNotFoundException("Movie not found."));
    }

    @Override
    public MovieModel create(MovieDTO movieDTO) {
        return movieRepository.save(modelMapper.map(movieDTO, MovieModel.class));
    }

    @Override
    public MovieModel update(MovieDTO movieDTO) {
        return movieRepository.save(modelMapper.map(movieDTO, MovieModel.class));
    }

    @Override
    public void delete(Long id) {
        findById(id);
        movieRepository.deleteById(id);
    }
}
