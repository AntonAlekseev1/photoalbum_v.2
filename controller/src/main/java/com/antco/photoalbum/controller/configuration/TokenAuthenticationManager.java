package com.antco.photoalbum.controller.configuration;

import com.antco.photoalbum.model.entity.Credentials;
import com.antco.photoalbum.service.api.ICredentialsService;
import com.antco.photoalbum.service.api.TokenClaims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.DefaultClaims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TokenAuthenticationManager implements AuthenticationManager {

    private final ICredentialsService credentialsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication instanceof TokenAuthentication) {
            return processAuthentication((TokenAuthentication) authentication);
        }
        // todo log exception
        throw new AuthenticationServiceException("Authentication failed");
    }

    private TokenAuthentication processAuthentication(TokenAuthentication authentication) throws AuthenticationException {
        String token = authentication.getToken();
        String key = "qwerty";
        DefaultClaims claims = (DefaultClaims) Jwts.parser().setSigningKey(key).parse(token).getBody();
      //  LocalDateTime expirationTime = (LocalDateTime) claims.get(TokenClaims.TOKEN_EXPIRATION_TIME.name());
    //    if (expirationTime != null && expirationTime.isAfter(LocalDateTime.now())) {
            return buildFullTokenAuthentication(authentication, claims);
    //    }
        // todo log exception
      //  throw new AuthenticationServiceException("Token expired date error");
    }

    private TokenAuthentication buildFullTokenAuthentication(TokenAuthentication authentication, DefaultClaims claims) {
        String login = (String) claims.get(TokenClaims.LOGIN.name());
        final List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (login != null) {
            Credentials credentials = credentialsService.getByLogin(login);
            authorities.add(new SimpleGrantedAuthority(credentials.getRole().name()));
            return new TokenAuthentication(authentication.getToken(), authorities, true, credentials);
        }
        // todo log exception
        throw new AuthenticationServiceException("User disabled");
    }
}
