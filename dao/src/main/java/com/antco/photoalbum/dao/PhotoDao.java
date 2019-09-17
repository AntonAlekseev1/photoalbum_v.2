package com.antco.photoalbum.dao;

import com.antco.photoalbum.dao.api.IPhotoDao;
import com.antco.photoalbum.model.entity.Photo;
import org.springframework.stereotype.Repository;

@Repository
public class PhotoDao extends AbstractDao<Photo, Long> implements IPhotoDao {

}
