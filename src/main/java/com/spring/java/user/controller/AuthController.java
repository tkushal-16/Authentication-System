package com.spring.java.user.controller;

import com.spring.java.user.dao.Role;
import com.spring.java.user.dao.RoleType;
import com.spring.java.user.dao.User;
import com.spring.java.user.dto.LoginRequest;
import com.spring.java.user.dto.RegisterRequest;
import com.spring.java.user.repository.RoleRepository;
import com.spring.java.user.repository.UserRepository;
import com.spring.java.user.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest req) {

        User user = new User();
        user.setUsername(req.username());
        user.setPassword(encoder.encode(req.password()));

        //Role role = roleRepo.findByName(RoleType.ROLE_USER).orElseThrow();
        //user.getRoles().add(role);

        userRepo.save(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req) {

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.username(), req.password()));

        UserDetails user = (UserDetails) auth.getPrincipal();
        assert user != null;
        return jwtUtil.generateToken(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "Admin access";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String user() {
        return "User access";
    }

}
