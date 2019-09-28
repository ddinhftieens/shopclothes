package com.ddinhftieens.shopclothes.DAO.Impl;

import com.ddinhftieens.shopclothes.DAO.ICommon;
import com.ddinhftieens.shopclothes.Entity.SizeEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
@Transactional
public class SizeDAOImpl implements ICommon<SizeEntity> {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void add(SizeEntity sizeEntity) {
        entityManager.persist(sizeEntity);
        entityManager.close();
    }

    @Override
    public void edit(SizeEntity sizeEntity) {
        entityManager.merge(sizeEntity);
        entityManager.close();
    }

    @Override
    public void delete(SizeEntity sizeEntity) {
        entityManager.remove(sizeEntity);
        entityManager.close();
    }

    @Override
    public SizeEntity getbyID(int ID) {
        String hql = "select e from SizeEntity e where e.id = :ID";
        Query query = entityManager.createQuery(hql,SizeEntity.class);
        query.setParameter("ID",ID);
        entityManager.close();
        return (SizeEntity) query.getSingleResult();
    }

    @Override
    public SizeEntity getbyName(String name) {
        return null;
    }

    @Override
    public List<SizeEntity> getAll() {
        return null;
    }
}
