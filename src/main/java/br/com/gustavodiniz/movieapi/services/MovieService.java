package br.com.gustavodiniz.movieapi.services;

import br.com.gustavodiniz.movieapi.dtos.MovieDTO;
import br.com.gustavodiniz.movieapi.models.MovieModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Persistable;

public interface MovieService {

    Page<MovieModel> findAll(Pageable pageable);

    MovieModel findById(Long id);

    MovieModel create(MovieDTO movieDTO);

    MovieModel update(MovieDTO movieDTO);
}
