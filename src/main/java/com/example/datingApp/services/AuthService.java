package com.example.datingApp.services;

import com.example.datingApp.exceptions.UserAlreadyExistsException;
import com.example.datingApp.exceptions.UserNotFoundException;
import com.example.datingApp.mappers.*;
import com.example.datingApp.requests.*;
import com.example.datingApp.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final RegisterRequestMapper registerRequestMapper;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = registerRequestMapper.toEntity(registerRequest);
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("This user is already exist");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        String roleName = "User";
        Integer profileId = null;
        user.setRole(roleService.findByName(roleName));
        userService.save(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .userId(user.getId())
                .profileId(profileId)
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthRequest authRequest) {
        var user = userService.findByEmail(authRequest.getEmail()).orElseThrow(UserNotFoundException::new);
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
        );
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .userId(user.getId())
                .profileId(user.getProfile() == null ? null : user.getProfile().getId())
                .token(jwtToken)
                .build();
    }
}
