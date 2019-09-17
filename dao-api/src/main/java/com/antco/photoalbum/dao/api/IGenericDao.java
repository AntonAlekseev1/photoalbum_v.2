package com.antco.photoalbum.dao.api;

import java.io.Serializable;

public interface IGenericDao<T, PK extends Serializable> {

    T getById(PK id);

    PK save(T entity);

    T update(T entity);

    void delete(PK id);
}
