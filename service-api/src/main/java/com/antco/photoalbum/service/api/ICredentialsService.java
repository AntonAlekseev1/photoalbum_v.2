package com.antco.photoalbum.service.api;

import com.antco.photoalbum.model.entity.Credentials;

public interface ICredentialsService extends IGenericService<Credentials, Long> {

    Credentials getByLogin(String login);
}
