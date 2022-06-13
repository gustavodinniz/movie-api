package br.com.gustavodiniz.movieapi.controllers;

import br.com.gustavodiniz.movieapi.dtos.MovieDTO;
import br.com.gustavodiniz.movieapi.dtos.UserDTO;
import br.com.gustavodiniz.movieapi.services.UserService;
import br.com.gustavodiniz.movieapi.services.exceptions.UserAlreadyRegisteredException;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO userDTO) {
        try {
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(userService.createUser(userDTO).getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (UserAlreadyRegisteredException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @PostMapping(value = "/admin")
    public ResponseEntity<UserDTO> createAdmin(@RequestBody @Valid UserDTO userDTO) {
        try {
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(userService.createAdmin(userDTO).getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (UserAlreadyRegisteredException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAllUsers(
            @PageableDefault(page = 0, size = 25, sort = "username", direction = Sort.Direction.ASC) Pageable pageable) {
        var userDTO = userService.findAll(pageable)
                .stream()
                .map(x -> modelMapper.map(x, UserDTO.class)).collect(Collectors.toList());
        Page<UserDTO> page = new PageImpl<>(userDTO);
        log.info("Showing all users.");
        return ResponseEntity.ok().body(page);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable Long id) {
        userService.delete(id);
        log.info("User with id: {} has been disabled successfully.", id);
        return ResponseEntity.noContent().build();
    }
}
