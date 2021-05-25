package com.ani.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = repository.findByUserName(username)
                .orElseThrow(this::throwException);

        return new AppUserDetails(
                user
        );
    }

    private UsernameNotFoundException throwException() {
        return new UsernameNotFoundException("Provided User Not Available");
    }
}
