package com.backend.spyne.service;

import com.backend.spyne.entity.User;
import com.backend.spyne.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByEmail(username);
//        if (user.isPresent()) {
//            return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(), new ArrayList<>());
//        }
//        throw new UsernameNotFoundException("User not found with email: " + username);
//    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findUserByMobileNo(String mobileNo) {
        return userRepository.findByMobileNo(mobileNo);
    }

    public Optional<User> findUserByName(String name) {
        return userRepository.findByNameContaining(name);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
