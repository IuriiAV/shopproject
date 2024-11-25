package org.telran.shop.de.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String generateToken(UserDetails userDetails) {
        //eyJhbGciOiJIUzUxMiJ9
        // .eyJpYXQiOjE3MjUxMDc3NjQsImV4cCI6MTcyNTI1MTc2NCwic3ViIjoiYWxleEBnbWFpbC5jb20ifQ
        // .LrO2StnqMA5yzy_1C4x76FZw_toUBr9EroSCGn36VdkcPuN8WtqtggTY3gM1-Q2Kwx-md66OJNZQSulCTrL1bg
        return "eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE3MjUxMDc3NjQsImV4cCI6MTcyNTI1MTc2NCwic3ViIjoiYWxleEBnbWFpbC5jb20ifQ.LrO2StnqMA5yzy_1C4x76FZw_toUBr9EroSCGn36VdkcPuN8WtqtggTY3gM1-Q2Kwx-md66OJNZQSulCTrL1bg";
    }

    public String extractUserName(String jwt) {
        return "thomas";
    }

    public boolean isTokenValid(String jwt, UserDetails userDetails) {
        return true;
    }
}
