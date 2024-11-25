package org.telran.shop.de.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.telran.shop.de.security.model.JwtAuthenticationResponse;
import org.telran.shop.de.security.model.SignInRequest;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;

    @Override
    public JwtAuthenticationResponse authenticate(SignInRequest request) {
        authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(request.login(),
                                request.password()));

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.login());

        String token = jwtService.generateToken(userDetails);
        // jwt.io - to check token
        return new JwtAuthenticationResponse(token);
    }
}
