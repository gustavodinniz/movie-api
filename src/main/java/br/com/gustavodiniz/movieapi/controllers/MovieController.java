package br.com.gustavodiniz.movieapi.controllers;

import br.com.gustavodiniz.movieapi.dtos.MovieDTO;
import br.com.gustavodiniz.movieapi.services.MovieService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<Page<MovieDTO>> findAll(@PageableDefault(page = 0, size = 25, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        var movieDTO = movieService.findAll(pageable)
                .stream()
                .map(x -> modelMapper.map(x, MovieDTO.class)).collect(Collectors.toList());
        Page<MovieDTO> page = new PageImpl<>(movieDTO);
        log.info("Showing all movies.");
        return ResponseEntity.ok().body(page);
    }
}
