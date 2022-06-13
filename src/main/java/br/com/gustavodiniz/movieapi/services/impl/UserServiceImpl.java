package br.com.gustavodiniz.movieapi.services.impl;

import br.com.gustavodiniz.movieapi.dtos.UserDTO;
import br.com.gustavodiniz.movieapi.models.RoleModel;
import br.com.gustavodiniz.movieapi.models.UserModel;
import br.com.gustavodiniz.movieapi.repositories.RoleRepository;
import br.com.gustavodiniz.movieapi.repositories.UserRepository;
import br.com.gustavodiniz.movieapi.services.AuthService;
import br.com.gustavodiniz.movieapi.services.UserService;
import br.com.gustavodiniz.movieapi.services.exceptions.ResourceNotFoundException;
import br.com.gustavodiniz.movieapi.services.exceptions.UserAlreadyRegisteredException;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Log4j2
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthService authService;

    @Override
    public UserModel createUser(UserDTO userDTO) {
        boolean exists = userRepository.existsByUsername(userDTO.getUsername());
        if (exists) {
            throw new UserAlreadyRegisteredException(userDTO.getUsername());
        }

        RoleModel roleModel = new RoleModel(2L, "ROLE_USER");
        Set<RoleModel> roleUser = new HashSet<>();
        roleUser.add(roleModel);

        UserModel userModel = modelMapper.map(userDTO, UserModel.class);
        userModel.setRoles(roleUser);
        userModel.setActivated(true);

        return userRepository.save(userModel);
    }

    @Override
    public UserModel createAdmin(UserDTO userDTO) {
        boolean exists = userRepository.existsByUsername(userDTO.getUsername());
        if (exists) {
            throw new UserAlreadyRegisteredException(userDTO.getUsername());
        }

        RoleModel roleModel = new RoleModel(1L, "ROLE_ADMIN");
        Set<RoleModel> roleUser = new HashSet<>();
        roleUser.add(roleModel);

        UserModel userModel = modelMapper.map(userDTO, UserModel.class);
        userModel.setRoles(roleUser);
        userModel.setActivated(true);

        return userRepository.save(userModel);
    }

    @Override
    public UserDTO findById(Long id) {
        authService.validateSelfOrAdmin(id);
        Optional<UserModel> userModel = userRepository.findById(id);
        UserModel entity = userModel.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new UserDTO(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByUsername(username);
        if (userModel == null) {
            log.error("User not found: " + username);
            throw new UsernameNotFoundException("Email not found");
        }
        log.info("User found: " + username);
        return userModel;
    }

    @Override
    public Page<UserModel> findAll(Pageable pageable) {
        Boolean activated = true;
        RoleModel roleModel = new RoleModel(2L, "ROLE_USER");
        return userRepository.findAllByActivatedAndRoles(pageable, activated, roleModel);
    }
}
