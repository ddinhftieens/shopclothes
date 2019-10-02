package com.ddinhftieens.shopclothes.DAO.Impl;

import com.ddinhftieens.shopclothes.DAO.ICommon;
import com.ddinhftieens.shopclothes.Entity.ViewEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ViewDAOImpl implements ICommon<ViewEntity> {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void add(ViewEntity viewEntity) {
        entityManager.persist(viewEntity);
        entityManager.close();
    }

    @Override
    public void edit(ViewEntity viewEntity) {

    }

    @Override
    public void delete(ViewEntity viewEntity) {

    }

    @Override
    public ViewEntity getbyID(int ID) {
        return null;
    }

    @Override
    public ViewEntity getbyName(String name) {
        return null;
    }

    @Override
    public List<ViewEntity> getAll() {
        return null;
    }
}
