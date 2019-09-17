package com.antco.photoalbum.service;

import com.antco.photoalbum.dao.api.ICategoryDao;
import com.antco.photoalbum.dao.api.IGenericDao;
import com.antco.photoalbum.model.entity.Category;
import com.antco.photoalbum.service.api.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService extends AbstractService<Category, Long> implements ICategoryService {

    private final ICategoryDao categoryDao;

    @Override
    protected IGenericDao<Category, Long> getDao() {
        return categoryDao;
    }
}
