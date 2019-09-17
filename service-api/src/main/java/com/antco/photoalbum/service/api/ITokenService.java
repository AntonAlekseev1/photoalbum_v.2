package com.antco.photoalbum.service.api;

import javax.naming.AuthenticationException;

public interface ITokenService {

    String getToken(String login, String password) throws AuthenticationException;
}
