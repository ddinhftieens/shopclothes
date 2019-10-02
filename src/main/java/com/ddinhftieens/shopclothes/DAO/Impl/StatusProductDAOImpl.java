package com.ddinhftieens.shopclothes.DAO.Impl;

import com.ddinhftieens.shopclothes.DAO.ICommon;
import com.ddinhftieens.shopclothes.Entity.StatusProductEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class StatusProductDAOImpl implements ICommon<StatusProductEntity> {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void add(StatusProductEntity statusProductEntity) {
        entityManager.persist(statusProductEntity);
        entityManager.close();
    }

    @Override
    public void edit(StatusProductEntity statusProductEntity) {

    }

    @Override
    public void delete(StatusProductEntity statusProductEntity) {

    }

    @Override
    public StatusProductEntity getbyID(int ID) {
        return null;
    }

    @Override
    public StatusProductEntity getbyName(String name) {
        return null;
    }

    @Override
    public List<StatusProductEntity> getAll() {
        String hql = "select e from StatusProductEntity e where e.status = 'New'";
        Query query = entityManager.createQuery(hql,StatusProductEntity.class);
        entityManager.close();
        return query.getResultList();
    }
}
