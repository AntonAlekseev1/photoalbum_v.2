package com.antco.photoalbum.service;

import com.antco.photoalbum.dao.api.IGenericDao;
import com.antco.photoalbum.dao.api.IUserDao;
import com.antco.photoalbum.model.entity.User;
import com.antco.photoalbum.service.api.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService extends AbstractService<User, Long>  implements IUserService {

    private final IUserDao userDao;

    @Override
    protected IGenericDao<User, Long> getDao() {
        return userDao;
    }
}
