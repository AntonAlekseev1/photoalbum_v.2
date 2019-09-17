package com.antco.photoalbum.dao;

import com.antco.photoalbum.dao.api.ICredentialsDao;
import com.antco.photoalbum.model.entity.Credentials;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class CredentialsDao extends AbstractDao<Credentials, Long> implements ICredentialsDao {

    @Override
    public Credentials getByLogin(String login) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Credentials> criteriaQuery = builder.createQuery(Credentials.class);
        Root<Credentials> root = criteriaQuery.from(Credentials.class);
        criteriaQuery.select(root).where(builder.equal(root.get("login"), login));
        return getEntityManager().createQuery(criteriaQuery).getSingleResult();
    }
}
