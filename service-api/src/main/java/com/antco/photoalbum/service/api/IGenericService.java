package com.antco.photoalbum.service.api;

import java.io.Serializable;

public interface IGenericService<T, PK extends Serializable> {

    T getById(PK id);

    PK save(T entity);

    T update(T entity);

    void delete(PK id);
}
