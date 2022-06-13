package br.com.gustavodiniz.movieapi.services.impl;

import br.com.gustavodiniz.movieapi.models.UserModel;
import br.com.gustavodiniz.movieapi.repositories.UserRepository;
import br.com.gustavodiniz.movieapi.services.AuthService;
import br.com.gustavodiniz.movieapi.services.exceptions.ForbiddenException;
import br.com.gustavodiniz.movieapi.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserModel authenticated() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return userRepository.findByUsername(username);
        } catch (Exception e) {
            throw new UnauthorizedException("Invalid user");
        }
    }

    @Override
    public void validateSelfOrAdmin(Long userId) {
        UserModel user = authenticated();
        if (!user.getId().equals(userId) && !user.hasHole("ROLE_ADMIN")) {
            throw new ForbiddenException("Access denied");
        }
    }
}
