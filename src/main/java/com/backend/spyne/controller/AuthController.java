//package com.backend.spyne.controller;
//
//
////import com.example.discussionapp.models.User;
////import com.example.discussionapp.services.UserService;
////import com.example.discussionapp.util.JwtTokenUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import com.backend.spyne.entity.User;
//import com.backend.spyne.service.UserService;
//import com.backend.spyne.util.JwtResponse;
//import com.backend.spyne.util.JwtTokenUtil;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody User user) throws Exception {
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
//        final UserDetails userDetails = userService.loadUserByUsername(user.getEmail());
//        final String token = jwtTokenUtil.generateToken(userDetails);
//        return ResponseEntity.ok(new JwtResponse(token));
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
//        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//        return ResponseEntity.ok(userService.saveUser(user));
//    }
//}
