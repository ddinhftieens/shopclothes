package com.ddinhftieens.shopclothes.DAO.Impl;

import com.ddinhftieens.shopclothes.DAO.ICommon;
import com.ddinhftieens.shopclothes.Entity.CategoryEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CategoryDAOImpl implements ICommon<CategoryEntity> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(CategoryEntity categoryEntity) {
        entityManager.persist(categoryEntity);
        entityManager.close();
    }

    @Override
    public void edit(CategoryEntity categoryEntity) {

    }

    @Override
    public void delete(CategoryEntity categoryEntity) {
        entityManager.remove(categoryEntity);
        entityManager.close();
    }

    @Override
    public CategoryEntity getbyID(int ID) {
        String hql = "select c from CategoryEntity c where c.ID = :ID";
        Query query = entityManager.createQuery(hql,CategoryEntity.class);
        query.setParameter("ID",ID);
        entityManager.close();
        return (CategoryEntity) query.getSingleResult();
    }

    @Override
    public CategoryEntity getbyName(String name) {
        return null;
    }

    @Override
    public List<CategoryEntity> getAll() {
        String hql = "select i from CategoryEntity i";
        Query query = entityManager.createQuery(hql,CategoryEntity.class);
        entityManager.close();
        return query.getResultList();
    }
}
