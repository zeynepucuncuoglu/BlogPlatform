package com.zeynep.blog.security;

import com.zeynep.blog.domain.entities.User;
import com.zeynep.blog.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class BlogUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user =  userRepository.findByEmail(email)
               .orElseThrow(() -> new UsernameNotFoundException("User not found with email:" + email));
       return new BlogUserDetails(user);
    }
}
