package com.antco.photoalbum.dao.api;

import com.antco.photoalbum.model.entity.Credentials;

public interface ICredentialsDao extends IGenericDao<Credentials, Long> {

    Credentials getByLogin(String login);
}
