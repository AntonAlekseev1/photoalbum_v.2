package com.antco.photoalbum.dao;

import com.antco.photoalbum.dao.api.IGenericDao;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractDao<T, PK extends Serializable> implements IGenericDao<T, PK> {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    public T getById(PK id) {
        return entityManager.find(this.getGenericEntityClass(), id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public PK save(T entity) {
        return (PK) getSession().save(entity);
    }

    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public void delete(PK id) {
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @SuppressWarnings("unchecked")
    private Class<T> getGenericEntityClass() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass()
                .getGenericSuperclass();
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }
}
