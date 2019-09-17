package com.antco.photoalbum.controller;

import com.antco.photoalbum.controller.dto.CredentialsDto;
import com.antco.photoalbum.controller.response.Response;
import com.antco.photoalbum.model.entity.Credentials;
import com.antco.photoalbum.service.api.ITokenService;
import com.antco.photoalbum.service.api.ICredentialsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequiredArgsConstructor
public class CredentialsController { // todo add ErrorHandler

    private final ICredentialsService credentialsService;
    private final ITokenService tokenService;

    @PostMapping("/signup")
    public Response signUp(@RequestBody CredentialsDto dto) throws AuthenticationException {
       // userService.save()
        Credentials credentials = new Credentials(); // todo use dozer
        credentials.setLogin(dto.getLogin());
        credentials.setPassword(dto.getPassword()); // todo encoding ?
        Long credentialsId = credentialsService.save(credentials);
        return new Response(credentialsId); // todo add responseDto(token, credentialsId);
    }

    @PostMapping("/rest/signin")
    public Response login(@RequestBody CredentialsDto dto) throws AuthenticationException {
        String token = tokenService.getToken(dto.getLogin(), dto.getPassword());
        return new Response(token);
    }

    @PostMapping("/logout")
    public void logout() {

    }
}
