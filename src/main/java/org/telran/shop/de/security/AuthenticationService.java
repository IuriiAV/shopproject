package org.telran.shop.de.security;

import org.telran.shop.de.security.model.JwtAuthenticationResponse;
import org.telran.shop.de.security.model.SignInRequest;

public interface AuthenticationService {

    JwtAuthenticationResponse authenticate(SignInRequest request);
}
