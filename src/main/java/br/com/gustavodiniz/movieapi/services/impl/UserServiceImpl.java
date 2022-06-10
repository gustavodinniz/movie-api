package br.com.gustavodiniz.movieapi.services.impl;

import br.com.gustavodiniz.movieapi.dtos.UserDTO;
import br.com.gustavodiniz.movieapi.models.UserModel;
import br.com.gustavodiniz.movieapi.repositories.UserRepository;
import br.com.gustavodiniz.movieapi.services.UserService;
import br.com.gustavodiniz.movieapi.services.exceptions.UserAlreadyRegisteredException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserModel create(UserDTO userDTO) {
        boolean exists = userRepository.existsByUsername(userDTO.getUsername());
        if (exists) {
            throw new UserAlreadyRegisteredException(userDTO.getUsername());
        }
        return userRepository.save(modelMapper.map(userDTO, UserModel.class));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return User
                .builder()
                .username(userModel.getUsername())
                .password(userModel.getPassword())
                .roles("ADMIN")
                .build();
    }
}
