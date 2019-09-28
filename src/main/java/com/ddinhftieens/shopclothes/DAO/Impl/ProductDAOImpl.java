package com.ddinhftieens.shopclothes.DAO.Impl;

import com.ddinhftieens.shopclothes.DAO.ICommon;
import com.ddinhftieens.shopclothes.Entity.ProductEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ProductDAOImpl implements ICommon<ProductEntity> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(ProductEntity productEntity) {
        entityManager.persist(productEntity);
        entityManager.close();
    }

    @Override
    public void edit(ProductEntity productEntity) {

    }

    @Override
    public void delete(ProductEntity productEntity) {
        entityManager.remove(productEntity);
        entityManager.close();
    }

    @Override
    public ProductEntity getbyID(int ID) {
        String hql = "select e from ProductEntity e where e.id = :ID";
        Query query = entityManager.createQuery(hql,ProductEntity.class);
        query.setParameter("ID",ID);
        entityManager.close();
        return (ProductEntity) query.getSingleResult();
    }

    @Override
    public ProductEntity getbyName(String name) {
        return null;
    }

    @Override
    public List<ProductEntity> getAll() {
        String hql = "select e from ProductEntity e";
        Query query = entityManager.createQuery(hql,ProductEntity.class);
//        query.setFirstResult(0);
//        query.setMaxResults(2);
        entityManager.close();
        return query.getResultList();
    }
}
