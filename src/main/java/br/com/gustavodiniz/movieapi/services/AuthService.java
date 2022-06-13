package br.com.gustavodiniz.movieapi.services;

import br.com.gustavodiniz.movieapi.models.UserModel;

public interface AuthService {

    UserModel authenticated();

    void validateSelfOrAdmin(Long userId);
}
