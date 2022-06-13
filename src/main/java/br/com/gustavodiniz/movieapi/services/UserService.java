package br.com.gustavodiniz.movieapi.services;

import br.com.gustavodiniz.movieapi.dtos.UserDTO;
import br.com.gustavodiniz.movieapi.models.UserModel;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    UserModel createUser(UserDTO userDTO);

    UserModel createAdmin(UserDTO userDTO);

    UserDTO findById(Long id);

    UserDetails loadUserByUsername(String username);
}
