package com.lexart.app.modules.user.application.service;

import com.lexart.app.modules.user.application.port.out.UserRepository;
import com.lexart.app.modules.user.domain.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AuthApplicationService implements  UserDetailsService {

    private UserRepository userRepository;

    public AuthApplicationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));
        Collection<? extends GrantedAuthority> authorities = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_".concat(role.getName())))
                .collect(Collectors.toSet());
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true, authorities);
    }
}
