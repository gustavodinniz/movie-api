package br.com.gustavodiniz.movieapi.repositories;

import br.com.gustavodiniz.movieapi.models.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieModel, Long> {
}
