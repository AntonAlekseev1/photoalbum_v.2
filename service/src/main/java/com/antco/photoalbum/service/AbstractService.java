package com.antco.photoalbum.service;


import com.antco.photoalbum.dao.api.IGenericDao;
import com.antco.photoalbum.service.api.IGenericService;

import java.io.Serializable;

public abstract class AbstractService<T, PK extends Serializable> implements IGenericService<T, PK> {

    @Override
    public T getById(PK id) {
        return getDao().getById(id);
    }

    @Override
    public PK save(T entity) {
        return getDao().save(entity);
    }

    @Override
    public T update(T entity) {
        return getDao().update(entity);
    }

    @Override
    public void delete(PK id) {
        getDao().delete(id);
    }

    protected abstract IGenericDao<T, PK> getDao();
}
