package com.antco.photoalbum.service;

import com.antco.photoalbum.model.entity.Credentials;
import com.antco.photoalbum.service.api.ICredentialsService;
import com.antco.photoalbum.service.api.ITokenService;
import com.antco.photoalbum.service.api.TokenClaims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TokenService implements ITokenService {

    private final ICredentialsService credentialsService;
    private static final String KEY = "qwerty"; // todo move in property and encrypt

    @Override
    public String getToken(String login, String password) throws AuthenticationException {
        if (login == null || password == null) {
            // todo log exception
            throw new AuthenticationException();
        }
        Credentials credentials = credentialsService.getByLogin(login);
        if (isValidPassword(password, credentials.getPassword())) {
            Map<String, Object> tokenData = new HashMap<>();
            tokenData.put(TokenClaims.USER_ROLE.name(), credentials.getRole());
            tokenData.put(TokenClaims.LOGIN.name(), login);
            tokenData.put(TokenClaims.TOKEN_CREATE_TIME.name(), LocalDateTime.now());
            tokenData.put(TokenClaims.TOKEN_EXPIRATION_TIME.name(), LocalDateTime.now().plusDays(1));
            JwtBuilder jwtBuilder = Jwts.builder();
            jwtBuilder.setClaims(tokenData);
            return jwtBuilder.signWith(SignatureAlgorithm.HS512, KEY).compact();
        }
        // todo log exception
        throw new AuthenticationException();
    }

    private boolean isValidPassword(String password, String passwordHash){
        return true; //todo use BasePasswordEncoder
    }
}
