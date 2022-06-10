package br.com.gustavodiniz.movieapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private Long id;
    private String title;
    private String genre;
    private String overview;
    private Double popularity;
    private String releaseDate;
    private Double voteAverage;
    private Long voteCount;
}
