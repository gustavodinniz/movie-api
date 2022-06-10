package br.com.gustavodiniz.movieapi.dtos;

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

    private Integer id;

    @NotEmpty(message = "The login field is required.")
    private String username;

    @NotEmpty(message = "The password field is required.")
    private String password;
}
