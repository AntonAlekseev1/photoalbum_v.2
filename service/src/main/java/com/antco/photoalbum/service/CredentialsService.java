package com.antco.photoalbum.service;

import com.antco.photoalbum.dao.api.ICredentialsDao;
import com.antco.photoalbum.dao.api.IGenericDao;
import com.antco.photoalbum.model.entity.Credentials;
import com.antco.photoalbum.service.api.ICredentialsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CredentialsService extends AbstractService<Credentials, Long> implements ICredentialsService {

    private final ICredentialsDao credentialsDao;

    @Override
    public Credentials getByLogin(String login) {
        return credentialsDao.getByLogin(login);
    }

    @Override
    protected IGenericDao<Credentials, Long> getDao() {
        return credentialsDao;
    }
}
