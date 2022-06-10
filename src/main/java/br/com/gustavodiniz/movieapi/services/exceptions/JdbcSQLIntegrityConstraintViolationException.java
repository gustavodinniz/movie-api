package br.com.gustavodiniz.movieapi.services.exceptions;

public class JdbcSQLIntegrityConstraintViolationException extends RuntimeException {

    public JdbcSQLIntegrityConstraintViolationException(String message) {
        super(message);
    }

}
