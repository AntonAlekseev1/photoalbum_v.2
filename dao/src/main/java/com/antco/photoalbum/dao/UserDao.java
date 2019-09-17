package com.antco.photoalbum.dao;


import com.antco.photoalbum.dao.api.IUserDao;
import com.antco.photoalbum.model.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends AbstractDao<User, Long> implements IUserDao {

}
