package com.antco.photoalbum.dao;


import com.antco.photoalbum.dao.api.ICategoryDao;
import com.antco.photoalbum.model.entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends AbstractDao<Category, Long> implements ICategoryDao {

}
