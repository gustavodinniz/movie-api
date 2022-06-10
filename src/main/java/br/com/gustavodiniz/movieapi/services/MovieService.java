package br.com.gustavodiniz.movieapi.services;

import br.com.gustavodiniz.movieapi.models.MovieModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {

    Page<MovieModel> findAll(Pageable pageable);

    MovieModel findById(Long id);
}
