package br.com.gustavodiniz.movieapi.services;

import br.com.gustavodiniz.movieapi.dtos.UserDTO;
import br.com.gustavodiniz.movieapi.models.UserModel;

public interface UserService {
    UserModel create(UserDTO userDTO);
}
