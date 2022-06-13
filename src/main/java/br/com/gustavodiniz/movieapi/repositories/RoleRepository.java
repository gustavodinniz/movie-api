package br.com.gustavodiniz.movieapi.repositories;

import br.com.gustavodiniz.movieapi.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
}
