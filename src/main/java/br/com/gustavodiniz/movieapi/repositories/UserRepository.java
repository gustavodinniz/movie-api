package br.com.gustavodiniz.movieapi.repositories;

import br.com.gustavodiniz.movieapi.models.RoleModel;
import br.com.gustavodiniz.movieapi.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    boolean existsByUsername(String username);

//    Optional<UserModel> findByUsername(String username);

    UserModel findByUsername(String username);

    Page<UserModel> findAllByActivated(Pageable pageable, Boolean activated);

    Page<UserModel> findAllByActivatedAndRoles(Pageable pageable, Boolean activated, RoleModel roleModel);
}
