package com.apietras.services.impl;

import com.apietras.model.CurrentUser;
import com.apietras.model.User;
import com.apietras.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * This service represents implementation of Spring Security interface, and it's used to determinate current user data.
 */

@Service
public class CurrentUserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public CurrentUserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email was not found", email)));
        return new CurrentUser(user);
    }


}
