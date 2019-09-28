package com.ddinhftieens.shopclothes.DAO.Impl;

import com.ddinhftieens.shopclothes.DAO.ICommon;
import com.ddinhftieens.shopclothes.Entity.CatalogEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CatalogDAOImpl implements ICommon<CatalogEntity> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(CatalogEntity catalogEntity) {
        entityManager.persist(catalogEntity);
        entityManager.close();
    }

    @Override
    public void edit(CatalogEntity catalogEntity) {

    }

    @Override
    public void delete(CatalogEntity catalogEntity) {
        entityManager.remove(catalogEntity);
        entityManager.close();
    }

    @Override
    public CatalogEntity getbyID(int ID) {
        String hql = "select i from CatalogEntity i where i.ID = :ID";
        Query query = entityManager.createQuery(hql,CatalogEntity.class);
        query.setParameter("ID",ID);
        entityManager.close();
        return (CatalogEntity) query.getSingleResult();
    }

    @Override
    public CatalogEntity getbyName(String name) {
        return null;
    }

    @Override
    public List<CatalogEntity> getAll() {
        String hql = "SELECT i from CatalogEntity i";
        Query query = entityManager.createQuery(hql,CatalogEntity.class);
        entityManager.close();
        return query.getResultList();
    }
}
