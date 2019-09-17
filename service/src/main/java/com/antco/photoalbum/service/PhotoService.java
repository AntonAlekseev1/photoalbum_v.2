package com.antco.photoalbum.service;

import com.antco.photoalbum.dao.api.IGenericDao;
import com.antco.photoalbum.dao.api.IPhotoDao;
import com.antco.photoalbum.model.entity.Photo;
import com.antco.photoalbum.service.api.IPhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PhotoService extends AbstractService<Photo, Long> implements IPhotoService {

    private final IPhotoDao photoDao;

    @Override
    protected IGenericDao<Photo, Long> getDao() {
        return photoDao;
    }
}
