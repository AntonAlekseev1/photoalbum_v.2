package com.antco.photoalbum.controller;

import com.antco.photoalbum.controller.dto.UserDataDto;
import com.antco.photoalbum.controller.response.Response;
import com.antco.photoalbum.controller.dto.IdDto;
import com.antco.photoalbum.model.entity.User;
import com.antco.photoalbum.service.api.ICredentialsService;
import com.antco.photoalbum.service.api.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;
    private final ICredentialsService credentialsService;

    @PostMapping("rest/get-data")
    public Response getUserData(@RequestBody IdDto dto) {
        User user = userService.getById(dto.getId());
        return new Response(user.getFirstName()); // todo use dozer
    }

    @PostMapping("/save")
    public Response saveUser(@RequestBody UserDataDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setCredentials(credentialsService.getById(dto.getCredentialsId()));
        userService.save(user);
        return new Response(Response.ResponseStatus.SUCCESS);
    }
}
