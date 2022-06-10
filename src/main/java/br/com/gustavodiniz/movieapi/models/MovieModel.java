package br.com.gustavodiniz.movieapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_MOVIES")
public class MovieModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String genre;

    @Column(columnDefinition = "text")
    private String overview;

    private Double popularity;

    private String releaseDate;

    private Double voteAverage;

    private Long voteCount;

}
