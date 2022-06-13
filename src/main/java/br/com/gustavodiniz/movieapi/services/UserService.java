package br.com.gustavodiniz.movieapi.services;

import br.com.gustavodiniz.movieapi.dtos.UserDTO;
import br.com.gustavodiniz.movieapi.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;

public interface UserService {
    UserModel createUser(UserDTO userDTO);

    UserModel createAdmin(UserDTO userDTO);

    UserDTO findById(Long id);

    UserDetails loadUserByUsername(String username);

    Page<UserModel> findAll(Pageable pageable);

    void delete(Long id);
}
