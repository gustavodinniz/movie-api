package br.com.gustavodiniz.movieapi.services.exceptions;

public class UserAlreadyRegisteredException extends RuntimeException {
    public UserAlreadyRegisteredException(String username) {
        super("User already registered: " + username);
    }
}
