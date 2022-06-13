package br.com.gustavodiniz.movieapi.dtos;

import br.com.gustavodiniz.movieapi.models.RoleModel;
import br.com.gustavodiniz.movieapi.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotEmpty(message = "The login field is required.")
    private String username;

    @NotEmpty(message = "The password field is required.")
    private String password;

    private RoleModel roles;

    public UserDTO(UserModel entity) {
        id = entity.getId();
        username = entity.getUsername();
        password = entity.getPassword();
    }
}
