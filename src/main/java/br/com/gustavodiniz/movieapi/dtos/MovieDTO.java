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
    private String overview;
    private Double popularity;
    private String releaseDate;
    private String title;
    private Double voteAverage;
    private Long voteCount;
}
