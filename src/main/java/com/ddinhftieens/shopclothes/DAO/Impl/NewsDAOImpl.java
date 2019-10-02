package com.ddinhftieens.shopclothes.DAO.Impl;

import com.ddinhftieens.shopclothes.DAO.ICommon;
import com.ddinhftieens.shopclothes.Entity.NewsEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class NewsDAOImpl implements ICommon<NewsEntity> {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void add(NewsEntity newsEntity) {
        entityManager.persist(newsEntity);
        entityManager.close();
    }

    @Override
    public void edit(NewsEntity newsEntity) {

    }

    @Override
    public void delete(NewsEntity newsEntity) {

    }

    @Override
    public NewsEntity getbyID(int ID) {
        return null;
    }

    @Override
    public NewsEntity getbyName(String name) {
        return null;
    }

    @Override
    public List<NewsEntity> getAll() {
        String hql = "select e from NewsEntity e";
        Query query = entityManager.createQuery(hql,NewsEntity.class);
        entityManager.close();
        return query.getResultList();
    }
}
