package com.ddinhftieens.shopclothes.DAO.Impl;

import com.ddinhftieens.shopclothes.DAO.ICommon;
import com.ddinhftieens.shopclothes.Entity.ColorEntity;
import com.ddinhftieens.shopclothes.Entity.SizeEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
@Transactional
public class ColorDAOImpl implements ICommon<ColorEntity> {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void add(ColorEntity colorEntity) {
        entityManager.persist(colorEntity);
        entityManager.close();
    }

    @Override
    public void edit(ColorEntity colorEntity) {

    }

    @Override
    public void delete(ColorEntity colorEntity) {
        entityManager.remove(colorEntity);
        entityManager.close();
    }

    @Override
    public ColorEntity getbyID(int ID) {
        String hql = "select e from ColorEntity e where e.id = :ID";
        Query query = entityManager.createQuery(hql,ColorEntity.class);
        query.setParameter("ID",ID);
        entityManager.close();
        return (ColorEntity) query.getSingleResult();
    }

    @Override
    public ColorEntity getbyName(String name) {
        return null;
    }

    @Override
    public List<ColorEntity> getAll() {
        return null;
    }
}
