package com.ddinhftieens.shopclothes.DAO.Impl;

import com.ddinhftieens.shopclothes.DAO.ICommon;
import com.ddinhftieens.shopclothes.Entity.ImageHomeEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ImageHomeDAOImpl implements ICommon<ImageHomeEntity> {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void add(ImageHomeEntity imageHomeEntity) {
        entityManager.persist(imageHomeEntity);
        entityManager.close();
    }

    @Override
    public void edit(ImageHomeEntity imageHomeEntity) {

    }

    @Override
    public void delete(ImageHomeEntity imageHomeEntity) {
        entityManager.remove(imageHomeEntity);
        entityManager.close();
    }

    @Override
    public ImageHomeEntity getbyID(int ID) {
        String hql = "select e from ImageHomeEntity e where e.id = :IDimage";
        Query query = entityManager.createQuery(hql,ImageHomeEntity.class);
        query.setParameter("IDimage",ID);
        return (ImageHomeEntity) query.getSingleResult();
    }

    @Override
    public ImageHomeEntity getbyName(String name) {
        return null;
    }

    @Override
    public List<ImageHomeEntity> getAll() {
        String hql = "select e from ImageHomeEntity e";
        Query query = entityManager.createQuery(hql,ImageHomeEntity.class);
        entityManager.close();
        return query.getResultList();
    }
}
