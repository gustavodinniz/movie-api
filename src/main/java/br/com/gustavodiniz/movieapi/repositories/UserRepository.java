package br.com.gustavodiniz.movieapi.repositories;

import br.com.gustavodiniz.movieapi.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    boolean existsByUsername(String username);

    Optional<UserModel> findByUsername(String username);
}
