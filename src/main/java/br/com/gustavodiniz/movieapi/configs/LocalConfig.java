package br.com.gustavodiniz.movieapi.configs;

import br.com.gustavodiniz.movieapi.models.MovieModel;
import br.com.gustavodiniz.movieapi.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private MovieRepository movieRepository;

    @Bean
    public void startDB() {

        MovieModel movieModel1 = new MovieModel(null, "Poder e a Lei", "Ação", "Muito bom", 1.0, "10/02/2022", 4.0, 1000L);
        MovieModel movieModel2 = new MovieModel(null, "Sonic 2 - O filme", "Aventura", "Ok", 6.3, "11/03/2022", 3.5, 257L);
        MovieModel movieModel3 = new MovieModel(null, "Cidade de Deus", "Drama", "Filme legal", 7.0, "13/01/2022", 2.0, 14665L);
        MovieModel movieModel4 = new MovieModel(null, "Enquanto estivermos juntos", "Romance", "Filme ok", 8.0, "21/03/2022", 3.9, 45451L);
        MovieModel movieModel5 = new MovieModel(null, "Através da minha janela", "Romance", "Bom", 1.0, "15/04/2022", 3.7, 5156165L);

        movieRepository.saveAll(List.of(movieModel1, movieModel2, movieModel3, movieModel4, movieModel5));

    }
}
